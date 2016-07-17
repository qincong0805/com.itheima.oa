package com.itheima.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.oa.dao.PersonDao;
import com.itheima.oa.dao.base.BaseDao;
import com.itheima.oa.domain.Person;
import com.itheima.oa.service.PersonService;
import com.itheima.oa.service.base.impl.BaseServiceImpl;
@Service("personService")
public class PersonServiceImpl extends BaseServiceImpl<Person> implements
		PersonService {
   @Resource(name="personDao")
   private PersonDao personDao;
	

	@Override
	public BaseDao<Person> getBaseDao() {
		// TODO Auto-generated method stub
		return this.personDao;
	}


       
}
