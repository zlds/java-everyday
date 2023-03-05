package org.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author: hanchaowei
 * @date 2023/3/5
 * @description:
 */

public class NettyClientHandler implements ChannelInboundHandler {
	@Override
	public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {

	}

	@Override
	public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

	}

	@Override
	public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
		channelHandlerContext.writeAndFlush("你好，我是客户端");
	}

	@Override
	public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

	}

	@Override
	public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
		System.out.println("服务端响应： " + o);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {

	}

	@Override
	public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

	}

	@Override
	public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

	}

	@Override
	public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

	}
}
