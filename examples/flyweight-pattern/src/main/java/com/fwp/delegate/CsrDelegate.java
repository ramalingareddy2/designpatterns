package com.fwp.delegate;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.fwp.bo.CsrBo;
import com.fwp.dao.CsrDao;
import com.fwp.dto.CsrDto;
import com.fwp.exception.GenericException;
import com.fwp.factory.ObjectFactory;

public class CsrDelegate {
	private CsrDao csrDao;

	public CsrDelegate() {
		csrDao = ObjectFactory.getObject(CsrDao.class);
	}

	public void addCsr(CsrDto csrDto) {
		CsrBo csrBo = null;

		try {
			csrBo = new CsrBo();
			BeanUtils.copyProperties(csrBo, csrDto);
			csrDao.saveCsr(csrBo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new GenericException("failed during addCsr");
		}

	}

}
