package com.zee.zee5app.repository;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Register;

public interface UserRepository {
	
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException;
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException;
	public String deleteUserById(String id) throws IdNotFoundException;
	
}
