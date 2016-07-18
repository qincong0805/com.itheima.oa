package com.itheima.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.oa.dao.DepartmentDao;
import com.itheima.oa.dao.RoleDao;
import com.itheima.oa.dao.UserDao;
import com.itheima.oa.dao.base.BaseDao;
import com.itheima.oa.domain.Department;
import com.itheima.oa.domain.Role;
import com.itheima.oa.domain.User;
import com.itheima.oa.service.UserService;
import com.itheima.oa.service.base.impl.BaseServiceImpl;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	public Collection<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.getAllUser();
	}
    @Transactional
	public void saveUser(User user, Long did, Long[] rids) {
		Department department = this.departmentDao.getEntityById(did);
		user.setDepartment(department);
		Set<Role> roles = this.roleDao.getEntityByIds(rids);
		user.setRoles(roles);
		this.userDao.saveEntity(user);
	}

	@Override
	public BaseDao<User> getBaseDao() {
		// TODO Auto-generated method stub
		return this.userDao;
	}

}
