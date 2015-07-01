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
    private JSONObject json;

    public JTAdminServer(JSONObject json) {
        this.json = json;
    }

    public void run() throws Exception
    {
        logger.info(">>>> jungletiger admin server run ...");

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
            b.childHandler(new JTAdminInitializer());

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