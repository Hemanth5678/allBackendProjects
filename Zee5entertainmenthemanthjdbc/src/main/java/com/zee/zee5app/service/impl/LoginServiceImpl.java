package com.zee.zee5app.service.impl;

import java.io.IOException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.impl.LoginRepositoryImpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.LoginService;

public class LoginServiceImpl implements LoginService{

	private static LoginService service;
	
	public LoginServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	public static LoginService getInstance() throws IOException {
		if(service==null) {
			service=new LoginServiceImpl();
		}
		return service;
	}
	
	LoginRepository LoginRepository = LoginRepositoryImpl.getInstance();
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		return LoginRepository.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String UserName) {
		// TODO Auto-generated method stub
		return LoginRepository.deleteCredentials(UserName);
	}

	@Override
	public String changePassword(String UserName, String password) {
		// TODO Auto-generated method stub
			return LoginRepository.changePassword(UserName,password);
	}
	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		return LoginRepository.changeRole(userName, role);
	}

}
