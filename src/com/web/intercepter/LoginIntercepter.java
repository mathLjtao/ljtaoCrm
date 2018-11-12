package com.web.intercepter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/*
 * 只能拦截action的，不能拦截访问jsp页面的，servlet应该也不行，。
 * 如果实在要拦截jsp的话，那么将jsp放到web-inf里面，再通过写action转发到jsp
 * 
 */
public class LoginIntercepter extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入到LoginIntercepter拦截器中");
		return invocation.invoke();
		
		//下面这些是用于登陆拦截的，用户只用登陆成功才能访问其他action
		/*
		//获得session域
		Map<String, Object> session = ActionContext.getContext().getSession();
		//获得登陆标识
		Object user = session.get("user");
		if(user==null){
			return "toLogin";
		}
		else{
			
		}
		*/
	}

}
