package com.itheima.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.oa.dao.DepartmentDao;
import com.itheima.oa.dao.base.BaseDao;
import com.itheima.oa.domain.Department;
import com.itheima.oa.service.DepartmentService;
import com.itheima.oa.service.base.impl.BaseServiceImpl;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements
		DepartmentService {
 
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao<Department> getBaseDao() {
		// TODO Auto-generated method stub
		return this.departmentDao;
	}
   

}
