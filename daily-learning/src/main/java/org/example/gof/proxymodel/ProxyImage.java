package org.example.gof.proxymodel;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description: 代理类。实现对原始类的扩展和增强，这样原始类只关注自己的核心逻辑。
 */

public class ProxyImage implements Image {

	private RealImage realImage;
	private String filename;

	public ProxyImage(String filename) {
		this.filename = filename;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(filename);
		}
		realImage.display();
	}
}
