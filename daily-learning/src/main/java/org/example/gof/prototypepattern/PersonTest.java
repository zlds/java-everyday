package org.example.gof.prototypepattern;

import java.io.*;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class PersonTest {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		// 通过重新clone方法实现深拷贝
		Address address = new Address("三墩", "杭州");
		Person person1 = new Person("张三", 20, address);
		Person person2 = person1.clone();
		person2.address.city = "上海";
		// 输出 "杭州"
		System.out.println(person1.address.city);
		// 输出 "上海"
		System.out.println(person2.address.city);

		// 通过序列化方式实现深拷贝
		AddressSerializable addressSerializable = new AddressSerializable("三墩", "杭州");
		PeronSerializable peronSerializable1 = new PeronSerializable("张三", 20, addressSerializable);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(peronSerializable1);
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		PeronSerializable peronSerializable2 = (PeronSerializable) ois.readObject();
		peronSerializable2.address.city = "南京";
		// 输出 "杭州"
		System.out.println(peronSerializable1.address.city);
		// 输出 "南京"
		System.out.println(peronSerializable2.address.city);
	}
}
