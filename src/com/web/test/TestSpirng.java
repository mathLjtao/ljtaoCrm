package com.web.test;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.domain.User;

public class TestSpirng {
	public String run1() {
		/*
		 * 在web.xm文件中设置sping容器随项目的启动而创建后，
		 * 获得spring容器，从Application域中获得即可。
		 * 这样子就可以让整个项目中只有一个spring容器，
		 */
		//获得ServletContext对象
		ServletContext sc=ServletActionContext.getServletContext();
		//从sc中获得ac容器
		WebApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		User user=(User)ac.getBean("user");
		user.setUser_name("aa");
		System.out.println(user.toString());
		return "success";
	}
}
