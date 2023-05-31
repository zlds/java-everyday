package org.example.security;

import org.owasp.encoder.Encode;

/**
 * @author: hanchaowei
 * @date 2023/5/31
 * @description:
 */

public class XssDemo {

	public static void main(String[] args) {


		/**
		 * 存储型XSS过滤测试
		 */
		// xss原始字符串
		String content = "<script>alert('xss')</script>";
		String replace = content.replace("<", "&lt;").replace(">", "&gt;");
		// 输出结果为：&lt;script&gt;alert('xss')&lt;/script&gt;
		System.out.println(replace);

		// 通过owasp的encoder进行过滤
		String safeOutput = Encode.forHtml(content);
		System.out.println(safeOutput);

	}
}
