package com.itheima.oa.struts.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.oa.domain.Person;
import com.itheima.oa.service.PersonService;
import com.itheima.oa.service.base.BaseService;
import com.itheima.oa.struts.action.base.BaseAction;

@Controller("personAction")
@Scope("prototype")
public class PersonAction extends BaseAction<Person>{

	@Resource(name="personService")
	private PersonService personService;
	public BaseService<Person> getBaseService() {
		// TODO Auto-generated method stub
		return this.personService;
	}

}
