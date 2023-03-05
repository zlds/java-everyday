package org.example.netty;

import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: hanchaowei
 * @date 2023/3/5
 * @description:
 */

public class NettyServerDemo {
	public static void main(String[] args) throws InterruptedException {
		// 1.创建一个线程组，用于接收客户端的连接，但是不做任何处理
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		// 2.创建一个线程组，用于处理网络操作
		EventLoopGroup workGroup = new NioEventLoopGroup(2);

		// 3.创建服务器端的启动助手来配置参数
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(bossGroup,workGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG,128)
				.childOption(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel channel) throws Exception {
						channel.pipeline().addLast(new NettyServerHandler());
					}
				});

		// 4.绑定一个端口并且同步，生成了一个ChannelFuture对象
		ChannelFuture futuer = serverBootstrap.bind(9999).sync();
		System.out.println("服务端启动成功");
		// 5.关闭通道（并不是真正意义上关闭，而是监听关闭的状态）
		futuer.channel().closeFuture().sync();
		// 6.关闭线程组（并不是真正意义上关闭，而是监听关闭的状态）
		bossGroup.shutdownGracefully();
		workGroup.shutdownGracefully();
	}
}
