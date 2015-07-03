package com.alex.jungletiger.admin;

import java.util.concurrent.*;
import io.netty.handler.codec.string.*;
import io.netty.handler.codec.bytes.*;
import io.netty.handler.codec.*;
import io.netty.channel.socket.*;
import io.netty.channel.*;

public class JTAdminInitializer extends ChannelInitializer<SocketChannel> 
{
    private ArrayBlockingQueue mq;

    public JTAdminInitializer(ArrayBlockingQueue mq)
    {
        this.mq = mq;
    }

    @Override
    public void initChannel(SocketChannel ch) 
    {
        ChannelPipeline p = ch.pipeline();
        // p.addLast(new LengthFieldBasedFrameDecoder(0xFFFFFF, 0, 3, 0, 3));
        // p.addLast(new ByteArrayDecoder());
        // p.addLast(new LengthFieldPrepender(3));
        // p.addLast(new ByteArrayEncoder());
        p.addLast("decoder", new ByteArrayDecoder());
        p.addLast("encoder", new ByteArrayEncoder());
        p.addLast(new JTAdminHandler(mq));
    }
}
