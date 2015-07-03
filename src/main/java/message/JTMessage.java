package com.alex.jungletiger.admin;

import io.netty.channel.*;

class JTMySQLProtocolMessage {
    public byte[] message;
    public ChannelHandlerContext ctx;
}