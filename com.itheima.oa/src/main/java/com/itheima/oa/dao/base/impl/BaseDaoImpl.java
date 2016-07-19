package com.itheima.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima.oa.dao.base.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T>{
   @Resource(name="hibernateTemplate")
   public HibernateTemplate hibernateTemplate;
   
   private Class entityClass;
   
   private String identifierPropertyName;
   @PostConstruct
   public void init(){
	   this.identifierPropertyName = this.hibernateTemplate.getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName();
   }
   
   public BaseDaoImpl(){
	   ParameterizedType type= (ParameterizedType)this.getClass().getGenericSuperclass();
	   this.entityClass = (Class)type.getActualTypeArguments()[0];
	   System.out.println(type.getRawType());
   }
	public void saveEntity(T t) {
		this.hibernateTemplate.save(t);
	}

	public void deleteEntity(Serializable id) {
		T t = (T)this.hibernateTemplate.get(this.entityClass, id);
		this.hibernateTemplate.delete(t);
	}

	public void updateEntity(T t) {
		this.hibernateTemplate.update(t);
	}

	public Collection<T> queryEntity() {
		
		return this.hibernateTemplate.find("from"+this.entityClass.getClass());
	}

	public T getEntityById(Serializable id) {
		// TODO Auto-generated method stub
		return (T)this.hibernateTemplate.get(this.entityClass, id);
	}


	public Set<T> getEntityByIds(Serializable[] ids) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from "+this.entityClass.getName());
		buffer.append(" where "+this.identifierPropertyName+" in(");
		for(int i=0;i<ids.length;i++){
			if(i==ids.length-1){
				buffer.append(ids[i]);
			}else{
				buffer.append(ids[i]+",");
			}
		}
		buffer.append(")");
		return new HashSet<T>(this.hibernateTemplate.find(buffer.toString()));
	}

}
