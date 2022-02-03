package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.repository.UserRepository2;
//import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.UserService;
//import com.zee.zee5app.service.UserService2;

@Service
public class UserServiceImpl implements UserService {
	
	// static UserService service;
	//private static UserRepositoryimpl repository;
	
	public UserServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private UserRepository userRepository;
	/*public static UserService getInstance() throws IOException {
		if(service==null) {
			service=new UserServiceImpl();
		}
		return service;
	}*/
	
	//UserRepository userRepository = UserRepositoryimpl.getInstance();
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Register register2 = userRepository.save(register);
		if(register2 != null)
		{
			return "success";
		}
		return "failure";
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (!this.userRepository.existsById(id)) {
			throw new IdNotFoundException("Invalid Id");
		}

		return (this.userRepository.save(register) != null) ? "success" : "fail";
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Register>optional = this.getUserById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			userRepository.deleteById(id);
			return "success";
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

	
}
