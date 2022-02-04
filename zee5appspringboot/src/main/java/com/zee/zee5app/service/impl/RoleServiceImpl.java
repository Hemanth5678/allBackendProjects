package com.zee.zee5app.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository Rolerepository;
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role role2 = Rolerepository.save(role);
		if(role2!=null)
			return "roles added";
		return "fail";
	}

	@Override
	public void deleteRole(int roleId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Role> optional;
		optional = this.getRoleById(roleId);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			Rolerepository.deleteById(roleId);
			
	}
	}

	@Override
	public Optional<Role> getRoleById(int roleId) {
		// TODO Auto-generated method stub
		return Rolerepository.findById(roleId);
	}

	
}
