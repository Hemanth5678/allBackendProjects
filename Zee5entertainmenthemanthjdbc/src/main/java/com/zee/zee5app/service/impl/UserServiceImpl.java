package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.UserService;
//import com.zee.zee5app.service.UserService2;

public class UserServiceImpl implements UserService {
	
	private static UserService service;
	//private static UserRepositoryimpl repository;
	
	public UserServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	public static UserService getInstance() throws IOException {
		if(service==null) {
			service=new UserServiceImpl();
		}
		return service;
	}
	
	UserRepository userRepository = UserRepositoryimpl.getInstance();
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}


	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException{
		// TODO Auto-generated method stub
		return userRepository.getAllUserDetails();
	}
}
