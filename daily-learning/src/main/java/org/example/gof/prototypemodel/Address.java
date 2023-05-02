package org.example.gof.prototypemodel;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class Address implements Cloneable {
	String street;
	String city;

	Address(String street,String city) {
		this.street = street;
		this.city = city;
	}

	// 重新clone方法
	@Override
	protected Address clone() throws CloneNotSupportedException {
		return (Address) super.clone();
	}

}
