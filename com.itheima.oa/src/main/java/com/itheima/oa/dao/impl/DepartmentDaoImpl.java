package com.itheima.oa.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.itheima.oa.dao.DepartmentDao;
import com.itheima.oa.dao.base.impl.BaseDaoImpl;
import com.itheima.oa.domain.Department;
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {

}
