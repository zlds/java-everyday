package org.example.gof.prototypepattern;

import java.io.Serializable;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class AddressSerializable implements Serializable {
	String street;
	String city;

	AddressSerializable(String street,String city) {
		this.street = street;
		this.city = city;
	}

}
