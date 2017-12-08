package com.tieto.ecm.training.java.validator;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {
	static final Map<Integer, Character> controllerMap = createMap();

	private static Map<Integer, Character> createMap() {
		Map<Integer, Character> myMap = new HashMap<Integer, Character>();
		myMap.put(0, '0');
		myMap.put(1, '1');
		myMap.put(2, '2');
		myMap.put(3, '3');
		myMap.put(4, '4');
		myMap.put(5, '5');
		myMap.put(6, '6');
		myMap.put(7, '7');
		myMap.put(8, '8');
		myMap.put(9, '9');
		myMap.put(10, 'A');
		myMap.put(11, 'B');
		myMap.put(12, 'C');
		myMap.put(13, 'D');
		myMap.put(14, 'E');
		myMap.put(15, 'F');
		myMap.put(16, 'H');
		myMap.put(17, 'J');
		myMap.put(18, 'K');
		myMap.put(19, 'L');
		myMap.put(20, 'M');
		myMap.put(21, 'N');
		myMap.put(22, 'P');
		myMap.put(23, 'R');
		myMap.put(24, 'S');
		myMap.put(25, 'T');
		myMap.put(26, 'U');
		myMap.put(27, 'V');
		myMap.put(28, 'W');
		myMap.put(29, 'X');
		myMap.put(30, 'Y');
		
		return myMap;
	}

}
