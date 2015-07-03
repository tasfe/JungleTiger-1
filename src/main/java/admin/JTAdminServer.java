package com.alex.jungletiger.admin;

import java.util.concurrent.*;
import java.io.*;
import io.netty.channel.socket.nio.*;
import io.netty.handler.logging.*;
import io.netty.channel.nio.*;
import io.netty.bootstrap.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import org.slf4j.*;
import org.json.*;

public final class JTAdminServer
{
    private Logger logger = LoggerFactory.getLogger(JTAdminServer.class);
    private ArrayBlockingQueue mq;
    private JSONObject json;

    // [TODO] there can be only one admin thread now
    //        may be able to execute admin task concurrently in the future 
    private static final int admin_workers = 1;

    public JTAdminServer(JSONObject json) {
        this.json = json;
    }

    public void run() throws Exception
    {
        logger.info(">>>> jungletiger admin server run ...");

        // create message queue. 
        ArrayBlockingQueue mq = new ArrayBlockingQueue(admin_workers, true);

        // create worker thread pool
        ExecutorService executor = Executors.newFixedThreadPool(admin_workers);

        for (int i = 0; i < admin_workers; i++) 
        {
            // Runnable worker = new JAdminTWorker(dsn, mq);
            // executor.execute(worker);
        }

        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(1);
        try 
        {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(bossGroup, workerGroup);
            b.channel(NioServerSocketChannel.class);
            b.handler(new LoggingHandler(LogLevel.INFO));
            b.childHandler(new JTAdminInitializer(mq));

            Channel ch = b.bind(json.getInt("port")).sync().channel();
            ch.closeFuture().sync();
        }
        finally 
        {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}