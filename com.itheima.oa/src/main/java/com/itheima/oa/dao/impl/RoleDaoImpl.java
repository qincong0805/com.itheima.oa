package com.itheima.oa.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.itheima.oa.dao.RoleDao;
import com.itheima.oa.dao.base.impl.BaseDaoImpl;
import com.itheima.oa.domain.Role;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

}
