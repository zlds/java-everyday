package org.example.gof.proxymodel;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class RealImage implements Image {
	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadFromDisk();
	}

	private void loadFromDisk() {
		System.out.println("loading " + filename);
	}

	@Override
	public void display() {
		System.out.println("displaying " + filename);
	}
}
