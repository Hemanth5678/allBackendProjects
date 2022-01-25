package com.zee.zee5app.repository.impl;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryimpl implements UserRepository {

	public UserRepositoryimpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	
	public static UserRepository getInstance() {
		if(repository==null) {
			repository=new UserRepositoryimpl();
			return repository;
		}
		return repository;
	}
	//private Register[] registers = new Register[10];
	private TreeSet<Register> set = new TreeSet<Register>();
	//private static int count = -1;

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		
		boolean result = this.set.add(register);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}
	@Override //assignment 21-01-22
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		/*Optional<Register> optional = this.getUserById(id);
		
		if(optional.isPresent()) {
			
			set.remove(optional.get());
			set.add(register);
			return "success";
		}*/
		for(Register register2: set) {
			if(register2.getId().equals(id)) {
				this.set.remove(register2);
				this.set.add(register);
				return "success";
				
			}
		}
		return "failure";
		
	}
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Register register2 = null;
		for(Register register: set) {
			if(register.getId().equals(id)) {
				register2 = register;
				break;
			}
		}
		
		return Optional.ofNullable(Optional.of(register2)).orElseThrow(()-> new IdNotFoundException("id not found"));
	}
	
	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		Register register[]=new Register[set.size()];
		return set.toArray(register);
	}
	@Override
	public String deleteUserById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		
		if(optional.isPresent()) {
			
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else {
				return "failure";
			}
		}
//		else {
//			throw new IdNotFoundException("id not found exception");
//		}
		return "failure";
	}
	
	public List<Register> getAllUserDetails(){
	  
		//Collections.sort((List<Register>)set);
	  
		return new ArrayList<Register>(set);
		//return new ArrayList<Register>(set.descendingSet());  //descending order
	}
	  //assignment 21-01-22: 
	
	
}
