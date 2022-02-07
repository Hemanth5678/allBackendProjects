package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
//import com.zee.zee5app.repository.UserRepository2;
//import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.UserService;
//import com.zee.zee5app.service.UserService2;

@Service
public class UserServiceImpl implements UserService {
	
	// static UserService service;
	//private static UserRepositoryimpl repository;
	
//	public UserServiceImpl() throws IOException{
//		// TODO Auto-generated constructor stub
//	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginRepository loginRepository;
	/*public static UserService getInstance() throws IOException {
		if(service==null) {
			service=new UserServiceImpl();
		}
		return service;
	}*/
	
	//UserRepository userRepository = UserRepositoryimpl.getInstance();
	
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		
		if(userRepository.existsByEmailAndContactnumber(register.getEmail(), register.getContactnumber()) == true) {
			throw new AlreadyExistsException("this record already exists");
			//throw new NullPointerException("nullpointer");
		}
		Register register2 = userRepository.save(register);
		if (register2 != null) {
//			Login login = new Login(register.getEmail(), register.getPassword(), register.getId());
//			if(loginRepository.existsByUserName(register.getEmail())) {
//				throw new AlreadyExistsException("login name already exists");
//			}
//			
//			String result = loginService.addCredentials(login);
//			if(result == "success") {
				//return "record added in register and login";
				return register2;
//			}
//			else {//rollback here
//				return null;
//			}
		}else {
			return null;
		}
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
	public Register getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = userRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id doesnt exists");
		}
		else {
			return optional.get();
		}
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
		
		Register optional = this.getUserById(id);
		if(optional==null) {
			throw new IdNotFoundException("user record not found");
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
