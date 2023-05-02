package org.example.gof.proxymodel;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class ProxyImageTest {
	public static void main(String[] args) {
		Image image1 = new ProxyImage("test.jpg");
		Image image2 = new ProxyImage("test.jpg");
		// 图片将从磁盘加载并显示。第一次调用将执行构造函数
		image1.display();
		// 图片不需要从磁盘加载，直接显示。在次调用时对象已经创建，不需要从磁盘加载
		image1.display();

		image2.display();
	}
}
