package com.zee.zee5app.service;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.dto.Register;

public class UserService {
	private UserRepository repository =UserRepository.getInstance();
	private UserService() {
		
	}
	
	static UserService service = null;
	public static UserService getInstance() {
		if(service==null)
				service=new UserService();
		return service;
	}
	
	public String addUser(Register register){
		return this.repository.addUser(register);
	}
	
	public String updateUser(String id,Register register){
		return this.repository.updateUser(id,register);
	}
	
	public Register getUserById(String Id) {
		return repository.getUserById(Id);
	}
	
	public Register[] getUsers(){
		return repository.getUsers();
	}
	
	public String deleteUser(String id) {
		return this.repository.deleteUser(id);
	}
}
