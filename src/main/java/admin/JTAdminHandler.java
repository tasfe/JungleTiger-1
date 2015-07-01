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
    private Logger logger;
    private Connection conn;
    private Statement stmt;

    public JTAdminHandler()
    {
        logger = LoggerFactory.getLogger(JTAdminHandler.class);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception 
    {
        logger.info(ctx.channel().remoteAddress().toString() + " is connected");
        Handshake hspacket = new Handshake();
        ctx.write(hspacket.toPacket());
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) 
    {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException
    {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) 
    {
        cause.printStackTrace();
        ctx.close();
    }
}