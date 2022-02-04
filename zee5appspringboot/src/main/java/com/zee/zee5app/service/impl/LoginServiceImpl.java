package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.repository.LoginRepository;
//import com.zee.zee5app.repository.impl.LoginRepositoryImpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

//	@Autowired
//	private LoginService service;
	
	public LoginServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	/*public static LoginService getInstance() throws IOException {
		if(service==null) {
			service=new LoginServiceImpl();
		}
		return service;
	}*/
	
	@Autowired
	LoginRepository LoginRepository;// = LoginRepositoryImpl.getInstance();
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login Login2 = LoginRepository.save(login);
		if(Login2 != null)
		{
			return "success";
		}
		return "failure";
	}
	@Override
	public String deleteCredentials(String userName) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login>optional = LoginRepository.findById(userName);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			LoginRepository.deleteById(userName);
			return "success";
		}
	}
	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String changeRole(String userName, EROLE role) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
