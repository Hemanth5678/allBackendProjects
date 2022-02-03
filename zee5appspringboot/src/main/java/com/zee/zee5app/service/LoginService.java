package com.zee.zee5app.service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginService {

	public String addCredentials(Login login);
	public String deleteCredentials(String userName) throws IdNotFoundException;
	public String changePassword(String userName,String password);
	public String changeRole(String userName,ROLE role);
}
