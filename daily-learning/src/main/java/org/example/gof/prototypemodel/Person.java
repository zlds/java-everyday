package org.example.gof.prototypemodel;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class Person implements Cloneable {
	String name;
	int age;
	Address address;

	public Person(String name, int age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	protected Person clone() throws CloneNotSupportedException {
		// 创建有个新的对象。对于基本类型是值拷贝。对于引用类型是引用拷贝
		Person clonedPerson = (Person) super.clone();
		// 对引用类型进行深拷贝
		clonedPerson.address = this.address.clone();
		return clonedPerson;
	}

}
