package com.test.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 解码器
 * 对消息进行分割
 */
public class TimeInitializer extends ChannelInitializer<SocketChannel>{

    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //以\n结尾分割的解码器
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        //字符串解码和编码
        pipeline.addLast("decoder", DECODER);
        pipeline.addLast("encoder", ENCODER);
        //自己逻辑的handler
        pipeline.addLast("handler", new TimeServerHandler());
    }

}
