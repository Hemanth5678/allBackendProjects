package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Role;

public interface RoleService {

	public String addRole(Role role);
	public void deleteRole(int roleId) throws IdNotFoundException;
	public Optional<Role> getRoleById(int roleId);
}
