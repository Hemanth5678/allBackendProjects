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
import com.zee.zee5app.dto.User;
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
	public User addUser(User User) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		
		if(userRepository.existsByEmailAndContactnumber(User.getEmail(), User.getContactnumber()) == true) {
			throw new AlreadyExistsException("this record already exists");
			//throw new NullPointerException("nullpointer");
		}
		User User2 = userRepository.save(User);
		if (User2 != null) {
//			Login login = new Login(User.getEmail(), User.getPassword(), User.getId());
//			if(loginRepository.existsByUserName(User.getEmail())) {
//				throw new AlreadyExistsException("login name already exists");
//			}
//			
//			String result = loginService.addCredentials(login);
//			if(result == "success") {
				//return "record added in User and login";
				return User2;
//			}
//			else {//rollback here
//				return null;
//			}
		}else {
			return null;
		}
	}

	@Override
	public String updateUser(Long id, User User) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (!this.userRepository.existsById(id)) {
			throw new IdNotFoundException("Invalid Id");
		}

		return (this.userRepository.save(User) != null) ? "success" : "fail";
	}

	@Override
	public User getUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id doesnt exists");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public User[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findAll();
		User[] array = new User[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		User optional = this.getUserById(id);
		if(optional==null) {
			throw new IdNotFoundException("user record not found");
		}
		else {
			userRepository.deleteById(id);
			return "success";
		}
	}

	@Override
	public Optional<List<User>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}



	
}
