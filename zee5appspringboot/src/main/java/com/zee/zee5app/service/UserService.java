package com.zee.zee5app.service;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.User;

public interface UserService {

	public User addUser(User User) throws AlreadyExistsException;
	public String updateUser(Long id, User User) throws IdNotFoundException;
	public User getUserById(Long id) throws IdNotFoundException;
	public User[] getAllUsers() throws InvalidIdLengthException, InvalidNameException;
	public String deleteUserById(Long id) throws IdNotFoundException;
	public Optional<List<User>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException;

}
