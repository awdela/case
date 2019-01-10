package com.test.netty.telnet;

import java.net.InetAddress;
import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TelentServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("The time server receive order: "+body);
        String currentTime = "QUERY TIME ORDER".equals(body)?new Date().toString():"BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    //建立连接的时候触发
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //执行触发前的操作
        System.out.println("remoteAddress: "+ctx.channel().remoteAddress()+" arrived \n");
        ctx.writeAndFlush("welcome to "+InetAddress.getLocalHost().getHostName()+" service!\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
