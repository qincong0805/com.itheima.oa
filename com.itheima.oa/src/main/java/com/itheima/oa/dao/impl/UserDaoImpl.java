package com.itheima.oa.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.itheima.oa.dao.UserDao;
import com.itheima.oa.dao.base.impl.BaseDaoImpl;
import com.itheima.oa.domain.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public Collection<User> getAllUser() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from User u");
		stringBuffer.append("left outer join fetch u.department");
		stringBuffer.append("left outer join fetch u.roles r");
		return this.hibernateTemplate.find(stringBuffer.toString());
	}

}
