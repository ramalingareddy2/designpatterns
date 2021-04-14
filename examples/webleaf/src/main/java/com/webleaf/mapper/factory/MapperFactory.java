package com.webleaf.mapper.factory;

import com.webleaf.mapper.HttpMapper;
import com.webleaf.mapper.Mapper;

public class MapperFactory {
	public static Mapper createMapper(String protocol) {
		Mapper mapper = null;

		if (protocol.equals("http")) {
			mapper = new HttpMapper();
		}

		return mapper;
	}
}
