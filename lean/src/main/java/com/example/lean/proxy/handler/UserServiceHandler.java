package com.example.lean.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class UserServiceHandler implements InvocationHandler {

	Object target;

	public UserServiceHandler(Object target){
		this.target=target;
	}

	@Override
	public Object invoke(Object proxy, Method method,Object[] args){
		try {
			before();
			Object result = method.invoke(target, args);
			after();
			return result;
		}catch (Exception e){
			e.printStackTrace();
		}finally {
		}
		return null;
	}

	private void before(){
		System.out.println(String.format("UserServiceHandler before time [%s] ", new Date()));
	}
	private void after(){
		System.out.println(String.format("UserServiceHandler after time [%s] ", new Date()));
	}

}
