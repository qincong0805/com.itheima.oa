package com.itheima.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.oa.dao.PersonDao;
import com.itheima.oa.dao.base.impl.BaseDaoImpl;
import com.itheima.oa.domain.Person;
@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao{

}
