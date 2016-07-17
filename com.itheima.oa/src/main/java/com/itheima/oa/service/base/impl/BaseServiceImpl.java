package com.itheima.oa.service.base.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.oa.dao.base.BaseDao;
import com.itheima.oa.service.base.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    public abstract BaseDao<T> getBaseDao();
    @Transactional
	public void saveEntity(T t) {
		this.getBaseDao().saveEntity(t);
	}

	@Transactional
	public void deleteEntity(Serializable id) {
		this.getBaseDao().deleteEntity(id);
	}

	@Transactional
	public void updateEntity(T t) {
		this.getBaseDao().updateEntity(t);
	}

	@Transactional(readOnly=true)
	public Collection<T> queryEntity() {
		// TODO Auto-generated method stub
		return this.getBaseDao().queryEntity();
	}

	@Transactional(readOnly=true)
	public T getEntityById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getBaseDao().getEntityById(id);
	}

	

}
