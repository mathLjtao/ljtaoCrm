package com.web;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.service.impl.UserServiceImpl;



public class UserAction extends ActionSupport implements  ModelDriven<User>{
	private UserService us=new UserServiceImpl();
	private User user=new User();
	public String login() throws Exception{
		System.out.println(user.getUser_code());
		User u=us.login(user);
		if(u==null){
			System.out.println("用户不存在");
		}
		else{
			System.out.println(u);
			if(user.getUser_password().equals(u.getUser_password())){
				System.out.println("用户存在,密码正确");
			}
			else{
				System.out.println("用户存在，密码错误");
			}
		}
		ActionContext.getContext().getSession().put("user",u);
		return "toIndex";
	}
	
	public User getModel(){
		return user;
	}
}
