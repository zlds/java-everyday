package org.example.classload;

/**
 * @author: hanchaowei
 * @date 2024/2/4
 * @description: 自定义类加载器
 */

public class MyClassLoader extends ClassLoader {

	// 重写loadClass方法，打破双亲委派机制
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		// 检查请求的类是否已经被加载
		Class<?> loadedClass = findLoadedClass(name);
		if (loadedClass == null) {
			try {
				// 如果请求的类没有被加载,委托给父类加载器加载该类
				loadedClass = getParent().loadClass(name);
			} catch (ClassNotFoundException e) {
				// 父类加载器无法加载该类，自定义加载逻辑
				byte[] classData = loadClassData(name);
				if (classData == null) {
					throw new ClassNotFoundException("没有找到要加载的类" + name);
				}
				// 将字节码数据转换为Class对象
				loadedClass = defineClass(name, classData, 0, classData.length);
			}


		}
		return loadedClass;
	}

	// 自定义方法，从特定位置加载
	private byte[] loadClassData(String name) {
		// 从文件系统,数据库,网络等地方加载字节码数据
		return null;
	}

}
