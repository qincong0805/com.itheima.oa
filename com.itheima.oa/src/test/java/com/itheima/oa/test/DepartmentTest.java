package com.itheima.oa.test;

import org.junit.Test;

import com.itheima.oa.domain.Department;
import com.itheima.oa.service.DepartmentService;
import com.itheima.oa.struts.action.DepartmentAction;

public class DepartmentTest extends SpringUtils {
	@Test
	public void testSaveDepartment(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Department department = new Department();
		department.setName("公关部");
		department.setDescription("美女多");
		departmentService.saveEntity(department);
	}
	
	@Test
	public void testDepartmentAction(){
		DepartmentAction departmentAction = (DepartmentAction)context.getBean("departmentAction");
		System.out.println(departmentAction);
	}
	
	@Test
	public void testGetDeparment(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Department department = departmentService.getEntityById(1L);
		department.getUsers();
	}
}
