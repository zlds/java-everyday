package org.example.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: hanchaowei
 * @date 2023/3/5
 * @description:
 */

public class NettyClient {
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(eventLoopGroup)
				.channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel socketChannel) throws Exception {
						// 添加解码器
						socketChannel.pipeline().addLast(new MessageDecoder());
						// 添加编码
						socketChannel.pipeline().addLast(new MessageEncoder());
						socketChannel.pipeline().addLast(new NettyClientHandler());
					}
				});

		ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999).sync();
		channelFuture.channel().closeFuture().sync();
		eventLoopGroup.shutdownGracefully();

	}
}
