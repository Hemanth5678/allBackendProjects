package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.UserRepository2;

public class UserRepositoryimpl implements UserRepository2 {

	public UserRepositoryimpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository2 repository;
	
	public static UserRepository2 getInstance() {
		return null;
	}
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return null;
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
