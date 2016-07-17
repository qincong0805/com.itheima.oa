package com.itheima.oa.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface BaseDao<T> {
    public void saveEntity(T t);
    public void deleteEntity(Serializable id);
    public void updateEntity(T t);
    public Collection<T> queryEntity();
    public T getEntityById(Serializable id);
    public Set<T> getEntityByIds(Serializable[] ids);
}
