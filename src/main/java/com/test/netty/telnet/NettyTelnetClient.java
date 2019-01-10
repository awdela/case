package com.test.netty.telnet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;

import org.apache.commons.net.SocketClient;
import org.apache.commons.net.telnet.TelnetClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyTelnetClient {

    static final String HOST = "192.168.7.221";
    static final int PORT = 23;
    private static SocketClient telnetClient;
    private static EventLoopGroup group;
    private static Bootstrap bootstrap;

    public static void init() throws Exception {
        telnetClient = new TelnetClient();
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        // bootstrap.group(group).channel(NioSocketChannel.class).handler(new
        // TelnetClientInitializer(sslCtx));
    }

    public static void channelRegistered(Class<? extends Channel> channelClass) {
        if (channelClass == null) {
            throw new NullPointerException("channelClass");
        }
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        try {
            init();
            telnetClient.connect(InetAddress.getByName("192.168.7.221"), PORT);
            Class cls = Class.forName("org.apache.commons.net.SocketClient");
            Field field = cls.getDeclaredField("_socket_");
            field.setAccessible(true);
            Socket socket = (Socket) field.get(telnetClient);
            InputStream in = socket.getInputStream();
            ReadableByteChannel source = Channels.newChannel(in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = null;
            reader.readLine();
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }finally {
                in.close();
            }
            System.out.println(sb.toString());
            SocketChannel socketChannel = socket.getChannel();
            // 设置为非阻塞模式
            socketChannel.configureBlocking(false);
            bootstrap.group(group).channel(NioSocketChannel.class).handler(new TelnetClientHandler());

            // Channel ch = bootstrap.connect(HOST, PORT).sync().channel();
            // read commands from stdin
            // ChannelFuture lastWriteFuture = null;
            // lastWriteFuture = ch.writeAndFlush("");
            // if (lastWriteFuture != null) {
            // lastWriteFuture.sync();
            // }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        if (group != null && group.isTerminated()) {
            group.shutdownGracefully();
        }
    }
}
