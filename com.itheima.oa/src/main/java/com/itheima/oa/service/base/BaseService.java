package com.itheima.oa.service.base;

import java.io.Serializable;
import java.util.Collection;

public interface BaseService<T>{
	 public void saveEntity(T t);
	    public void deleteEntity(Serializable id);
	    public void updateEntity(T t);
	    public Collection<T> queryEntity();
	    public T getEntityById(Serializable id);
}
