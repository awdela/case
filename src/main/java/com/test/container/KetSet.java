package com.test.container;

import java.util.HashMap;
import java.util.Set;

public class KetSet {

	public static void main(String args[]) {
		// create hash map
		HashMap newmap = new HashMap();
		// populate hash map
		newmap.put(1, "tutorials");
		newmap.put(2, "point");
		newmap.put(3, "is best");

		// get keyset value from map
		Set keyset=newmap.keySet();
		Set entryset=newmap.entrySet();

		// check key set values
		System.out.println("Key set values are: " + keyset);
		System.out.println("Entry set values are: " + entryset);
	}

}
