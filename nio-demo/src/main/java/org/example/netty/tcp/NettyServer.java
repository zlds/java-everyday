package org.example.netty.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.example.netty.MessageDecoder;
import org.example.netty.MessageEncoder;
import org.example.netty.NettyServerHandler;

import java.util.Stack;

/**
 * @author: hanchaowei
 * @date 2023/9/15
 * @description:
 */

public class NettyServer {

//	public static void main(String[] args) throws InterruptedException {
//		// 负责接收客户端连接
//		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//		// 负责处理IO操作
//		EventLoopGroup workGroup = new NioEventLoopGroup(2);
//
//		// 创建服务助手
//		ServerBootstrap serverBootstrap = new ServerBootstrap();
//		serverBootstrap.group(bossGroup,workGroup)
//				.channel(NioServerSocketChannel.class)
//				.option(ChannelOption.SO_BACKLOG,128)
//				.childOption(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)
//				.childHandler(new ChannelInitializer<SocketChannel>() {
//					@Override
//					protected void initChannel(SocketChannel socketChannel) throws Exception {
//						// 添加解码器
//						socketChannel.pipeline().addLast(new MessageEncoder());
//						// 添加编码
//						socketChannel.pipeline().addLast(new MessageDecoder());
//						socketChannel.pipeline().addLast(new NettyServerHandler());
//					}
//				});
//		ChannelFuture future = serverBootstrap.bind(9999);
//		future.addListener(new ChannelFutureListener() {
//			@Override
//			public void operationComplete(ChannelFuture channelFuture) throws Exception {
//				if (channelFuture.isSuccess()) {
//					System.out.println("端口绑定成功");
//				} else {
//					System.out.println("端口绑定失败");
//				}
//			}
//		});
//		System.out.println("服务启动成功");
//
//		future.channel().closeFuture().sync();
//		bossGroup.shutdownGracefully();
//		workGroup.shutdownGracefully();
//
//	}

	static int recur(int n) {
		// 终止条件
		if (n == 1) {
			return 1;
		}
		// 递归公式
		int res = recur(n - 1);
		return n + res;

	}

	public static void main(String[] args) {
		int recur = recur(3);
		System.out.println(recur);


		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(4);

		Integer peek = stack.peek();
		System.out.println(peek);
		Integer pop = stack.pop();
		System.out.println(pop);

	}
}
