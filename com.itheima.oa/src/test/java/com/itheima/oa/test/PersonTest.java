package com.itheima.oa.test;

import org.junit.Test;

import com.itheima.oa.domain.Person;
import com.itheima.oa.service.PersonService;
import com.itheima.oa.struts.action.PersonAction;

public class PersonTest extends SpringUtils{
	@Test
	public void testPersonService(){
		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setName("1552989");
		person.setDescription("98925");
		personService.saveEntity(person);
	}
	
	@Test
	public void testPersonAction(){
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		System.out.println(personAction);
	}
}
