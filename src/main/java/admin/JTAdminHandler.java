package com.alex.jungletiger.admin;

import com.alex.jungletiger.protocol.*;
import java.util.concurrent.*;
import java.sql.*;
import java.io.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import org.slf4j.*;

public class JTAdminHandler extends ChannelInboundHandlerAdapter 
{
    private ArrayBlockingQueue mq;
    private Connection conn;
    private Statement stmt;
    private Logger logger;

    public JTAdminHandler(ArrayBlockingQueue mq)
    {
        this.logger = LoggerFactory.getLogger(JTAdminHandler.class);
        this.mq = mq;
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception 
    {
        logger.info(ctx.channel().remoteAddress().toString() + " is connected");

        Handshake hspacket = new Handshake();
        hspacket.serverVersion = "5.6.22-71.0-log";
        hspacket.connectionId = 1;
        hspacket.challenge1 = "qNpjDROu";
        hspacket.capabilityFlags = Flags.CLIENT_PROTOCOL_41;
        hspacket.characterSet = 8;
        hspacket.statusFlags = 0;
        hspacket.challenge2 = "!BeYo@3|8C(;";
        hspacket.authPluginDataLength = 0;
        hspacket.authPluginName = "";

        final ChannelFuture f = ctx.writeAndFlush(hspacket.toPacket());
        hspacket.dump_stderr(hspacket.toPacket());
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
            }
        });
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) 
    {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException
    {
        Packet.dump_stderr((byte[])msg);
        OK okpacket = new OK();
        okpacket.sequenceId = 2;
        Packet.dump_stderr(okpacket.toPacket());
        ctx.write(okpacket.toPacket());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) 
    {
        cause.printStackTrace();
        ctx.close();
    }
}