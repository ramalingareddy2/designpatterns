package com.vlh.helper;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
	private static Map<Class<?>, Object> objectMap = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <T> T getObject(Class<T> clazz) {
		T obj = null;
		try {
			if (objectMap.containsKey(clazz) == false) {

				obj = clazz.newInstance();

				objectMap.put(clazz, obj);
			} else {
				obj = (T) objectMap.get(clazz);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("failed in creating object", e);
		}

		return obj;
	}
}
