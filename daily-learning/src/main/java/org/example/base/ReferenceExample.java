package org.example.base;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author: hanchaowei
 * @date 2024/7/14
 * @description:
 */

public class ReferenceExample {

	public static void main(String[] args) {
		// 强引用
		String s1 = new String("abc");
		// 软引用
		SoftReference<String> softReference = new SoftReference<>(s1);
		// 去掉引用进行垃圾回收
		s1 = null;
		System.gc();
		// 内存足够不会被回收(当gc之后发现内存不足时才会进行回收)
		System.out.println(softReference.get());


		String s2 = new String("123");
		// 弱引用
		WeakReference<String> weakReference = new WeakReference<>(s2);
		s2 = null;
		System.gc();
		// gc时一定被回收
		System.out.println(weakReference.get());

	}
}
