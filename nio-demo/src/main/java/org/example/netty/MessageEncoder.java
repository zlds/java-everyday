package org.example.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/3/5
 * @description:
 */

public class MessageEncoder extends MessageToMessageEncoder {
	@Override
	protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
		System.out.println("编码器开始...");
		String str = (String) o;
		list.add(Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
	}
}
