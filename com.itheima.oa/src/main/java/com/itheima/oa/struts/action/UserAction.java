package com.itheima.oa.struts.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;

import com.itheima.oa.domain.Department;
import com.itheima.oa.domain.Role;
import com.itheima.oa.domain.User;
import com.itheima.oa.service.DepartmentService;
import com.itheima.oa.service.RoleService;
import com.itheima.oa.service.UserService;
import com.itheima.oa.service.base.BaseService;
import com.itheima.oa.struts.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
@Controller("userAction")
public class UserAction extends BaseAction<User> {

	@Resource(name="userService")
	private UserService userService;
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@Resource(name="roleService")
	private RoleService roleService;
	
	private Long did;
	private Long[] rids;
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public Long[] getRids() {
		return rids;
	}
	public void setRids(Long[] rids) {
		this.rids = rids;
	}
	
	public  String showAllUser(){
		Collection<User> userList = this.userService.getAllUser();
		ActionContext.getContext().put("userList", new HashSet<User>(userList));
		return listAction;
	}
	
	public String addUI(){
		Collection<Department> dList = this.departmentService.queryEntity();
		Collection<Role> rList = this.roleService.queryEntity();
		ActionContext.getContext().put("dList", dList);
		ActionContext.getContext().put("rList", rList);
		return addUI;
	}
	
	public String add(){
		User user = new User();
		try {
			BeanUtils.copyProperties(this.getModel(), user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userService.saveUser(user, did, rids);
		return action2action;
	}
	


}
