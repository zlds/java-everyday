package org.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/3/5
 * @description:
 */

public class MessageDecoder extends MessageToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
		System.out.println("解码数据");
		ByteBuf byteBuf = (ByteBuf) o;
		list.add(byteBuf.toString(CharsetUtil.UTF_8));

	}
}
