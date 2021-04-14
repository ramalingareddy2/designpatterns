package com.fwp.factory;

import java.util.HashMap;
import java.util.Map;

import com.fwp.exception.GenericException;

public class ObjectFactory {
	private static Map<Class<?>, Object> objectMap = new HashMap<Class<?>, Object>();

	public static <T> T getObject(Class<T> clazz) {
		T object = null;
		if (objectMap.containsKey(clazz)) {
			return (T) objectMap.get(clazz);
		}
		try {
			object = clazz.newInstance();
			objectMap.put(clazz, object);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new GenericException("Failed while creating object");
		}
		return object;
	}
}
