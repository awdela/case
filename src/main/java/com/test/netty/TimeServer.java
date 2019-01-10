package com.test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new TimeServerHandler());
        }

    }

    private static final int port = 8080;
    // 服务端启动类
    private ServerBootstrap bootStrap;

    // 负责收集客户端连接 NioEventLoopGroup对应一个被封装好的NIO线程池
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    // 负责处理每个连接的IO读写
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void bind() throws Exception {
        try {
            bootStrap = new ServerBootstrap();
            bootStrap.group(bossGroup, workerGroup);
            bootStrap.channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());

            // 服务器绑定端口监听
            ChannelFuture f = bootStrap.bind(port).sync();
            // 等待关闭 同步端口
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new TimeServer().bind();
    }
}
