package com.example.lean.user.impl;

import com.example.lean.user.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void select(){
		System.out.println("select");
	}

	@Override
	public void update(){
		System.out.println("update");
	}
}
