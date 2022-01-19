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
		if(repository==null) {
			repository=new UserRepositoryimpl();
			return repository;
		}
		return repository;
	}
	private Register[] registers = new Register[10];
	private static int count = -1;
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		if(count==registers.length-1) {
			Register temp[] = new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
			registers[++count]=register;
			return "successssssssss";
		}
		registers[++count]= register;
		return "success";
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
