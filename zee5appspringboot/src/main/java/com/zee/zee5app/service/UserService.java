package com.zee.zee5app.service;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Register;

public interface UserService {

	public Register addUser(Register register) throws AlreadyExistsException;
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Register getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException;
	public String deleteUserById(String id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException;

}
