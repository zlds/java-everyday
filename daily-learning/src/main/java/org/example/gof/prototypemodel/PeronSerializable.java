package org.example.gof.prototypemodel;

import java.io.Serializable;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class PeronSerializable implements Serializable {
	String name;
	int age;
	AddressSerializable address;

	public PeronSerializable(String name, int age, AddressSerializable address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
}
