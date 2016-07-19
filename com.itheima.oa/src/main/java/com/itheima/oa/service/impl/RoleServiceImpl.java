package com.itheima.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.oa.dao.RoleDao;
import com.itheima.oa.dao.base.BaseDao;
import com.itheima.oa.domain.Role;
import com.itheima.oa.service.RoleService;
import com.itheima.oa.service.base.impl.BaseServiceImpl;
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public BaseDao<Role> getBaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}


}
