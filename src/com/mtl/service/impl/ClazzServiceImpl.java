package com.mtl.service.impl;

import java.util.List;

import com.mtl.dao.impl.ExeClazzImpl;
import com.mtl.pojo.Clazz;
import com.mtl.service.ClazzService;

public class ClazzServiceImpl implements ClazzService {

	@Override
	public List<Clazz> getAllClazz() {
		// TODO Auto-generated method stub
		return new ExeClazzImpl().getAllClazz();
	}

}
