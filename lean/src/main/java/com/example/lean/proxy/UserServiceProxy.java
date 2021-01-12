package com.example.lean.proxy;

import com.example.lean.user.UserService;

public class UserServiceProxy implements UserService {
	private UserService target;

	public UserServiceProxy(UserService target){
		this.target=target;
	}

	public void select(){

	}

	public void update(){

	}
}
