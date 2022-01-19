package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.UserService2;

public class UserServiceImpl implements UserService2 {
	
	private static UserService2 service;
	private static UserRepositoryimpl repository;
	
	public static UserService2 getInstance() {
		if(service==null) {
			service=new UserServiceImpl();
		}
		return service;
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return this.repository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Register getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
