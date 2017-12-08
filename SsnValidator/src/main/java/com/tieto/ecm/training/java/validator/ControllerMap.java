package com.tieto.ecm.training.java.validator;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {
	static final Map<Integer, Character> controllerMap = createMap();

	private static Map<Integer, Character> createMap() {
		Map<Integer, Character> controllerMap = new HashMap<Integer, Character>();
		controllerMap.put(0, '0');
		controllerMap.put(1, '1');
		controllerMap.put(2, '2');
		controllerMap.put(3, '3');
		controllerMap.put(4, '4');
		controllerMap.put(5, '5');
		controllerMap.put(6, '6');
		controllerMap.put(7, '7');
		controllerMap.put(8, '8');
		controllerMap.put(9, '9');
		controllerMap.put(10, 'A');
		controllerMap.put(11, 'B');
		controllerMap.put(12, 'C');
		controllerMap.put(13, 'D');
		controllerMap.put(14, 'E');
		controllerMap.put(15, 'F');
		controllerMap.put(16, 'H');
		controllerMap.put(17, 'J');
		controllerMap.put(18, 'K');
		controllerMap.put(19, 'L');
		controllerMap.put(20, 'M');
		controllerMap.put(21, 'N');
		controllerMap.put(22, 'P');
		controllerMap.put(23, 'R');
		controllerMap.put(24, 'S');
		controllerMap.put(25, 'T');
		controllerMap.put(26, 'U');
		controllerMap.put(27, 'V');
		controllerMap.put(28, 'W');
		controllerMap.put(29, 'X');
		controllerMap.put(30, 'Y');
		
		return controllerMap;
	}

}
