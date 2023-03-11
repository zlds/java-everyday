package org.example.classload;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author: hanchaowei
 * @date 2023/3/11
 * @description:
 */

public class JvmClassLoaderPrintPath {


	public static void main(String[] args) {
		// 启动类加载器
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		System.out.println("启动类加载器");
		for (URL url : urls) {
			System.out.println(" ==> " + url.toExternalForm());
		}

		// 扩展类加载器
		printClassLoad("扩展类加载器",JvmClassLoaderPrintPath.class.getClassLoader().getParent());

		// 应用类加载器
		printClassLoad("应用类加载器",JvmClassLoaderPrintPath.class.getClassLoader());
	}



	public static void printClassLoad(String name,ClassLoader cl) {
		if (cl != null) {
			System.out.println(name + " ClassLoad -> " + cl.toString());
			printURLForClassLoader(cl);
		} else {
			System.out.println(name + " ClassLoader -> null");
		}
	}

	public static void printURLForClassLoader(ClassLoader cl) {
		Object ucp = insightField(cl, "ucp");
		Object path = insightField(ucp, "path");
		System.out.println(" -> " + path.toString());
	}

	private static Object insightField(Object obj, String fName) {
		try {
			Field f = null;
			if (obj instanceof URLClassLoader) {
				f = URLClassLoader.class.getDeclaredField(fName);
			} else {
				f = obj.getClass().getDeclaredField(fName);
			}
			f.setAccessible(true);
			return f.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
