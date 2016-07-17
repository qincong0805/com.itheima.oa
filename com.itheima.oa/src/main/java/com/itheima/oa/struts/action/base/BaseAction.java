package com.itheima.oa.struts.action.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

import com.itheima.oa.service.base.BaseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> implements ModelDriven<T> {
   public abstract BaseService<T> getBaseService();
	
	private Class modelDriverClass;
	private Long id;
	public static final String LISTACTION="listAction";
	public static final String UPDATEUI="updateUI";
	public static final String ADDUI="addUI";
	public static final String ACTION2ACTION="action2action";
	
	
	public String listAction = LISTACTION;
	public String addUI = ADDUI;
	public String updateUI = UPDATEUI;
	public String action2action = ACTION2ACTION;
	
	public void setId(Long id) {
		this.id = id;
	}

	private T t;
	
	public BaseAction(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		this.modelDriverClass = (Class)type.getActualTypeArguments()[0];
		
		try {
			this.t = (T) this.modelDriverClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}
	
	public String showDate(){
		Collection<T> dateList = this.getBaseService().queryEntity();
		System.out.println(dateList.size());
		ActionContext.getContext().put("dateList", null);
		return "list";
	}
	
	
	public String addUI(){
		return "addUI";
	}
	
	public String add() throws Exception{
		Object obj = this.modelDriverClass.newInstance();
		BeanUtils.copyProperties(this.getModel(), obj);
		T t = (T)obj;
		this.getBaseService().saveEntity(t);
		return "action2action";
	}
	
	
	public String updateUI(){
T t = this.getBaseService().getEntityById(this.id);
	ActionContext.getContext().getValueStack().push(t);
	return "updateUI";
	
	}
}
