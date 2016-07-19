package com.itheima.oa.struts.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.oa.domain.Department;
import com.itheima.oa.service.DepartmentService;
import com.itheima.oa.struts.action.base.BaseAction;
import com.mchange.v2.beans.BeansUtils;
import com.opensymphony.xwork2.ActionContext;
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	public String showAllDepartment(){
		Collection<Department> departmentList = this.departmentService.queryEntity();
		ActionContext.getContext().put("departmentList", departmentList);
		return listAction;
	}
	
	public String updateUI(){
		Department department =this.departmentService.getEntityById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	
	public String update(){
		Department department =this.departmentService.getEntityById(this.getModel().getDid());
		try {
			BeanUtils.copyProperties(this.getModel(), department);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.departmentService.updateEntity(department);
		return action2action;
	}
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		Department department = new Department();
		try {
			BeanUtils.copyProperties(this.getModel(), department);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.departmentService.saveEntity(department);
		return action2action;
	}
	
	public String delete(){
		this.departmentService.deleteEntity(this.getModel().getDid());
		return action2action;
	}
	
}
