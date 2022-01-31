package com.zee.zee5app.repository.impl;

import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryimpl implements UserRepository {

	
	LoginRepository loginRepository = LoginRepositoryImpl.getInstance();
	
	public UserRepositoryimpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	DBUtils dbutils = DBUtils.getInstance();
	
	public static UserRepository getInstance() throws IOException {
		if(repository==null) {
			repository=new UserRepositoryimpl();
			return repository;
		}
		return repository;
	}
	//private Register[] registers = new Register[10];
	//private TreeSet<Register> set = new TreeSet<Register>();
	//private static int count = -1;

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into register"+" (regid,firstname,lastname,email,contactnumber,password)"+"values(?,?,?,?,?,?)";
		
		connection= dbutils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			String salt = PasswordUtils.getSalt(30);
			String encryptedpassword = PasswordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedStatement.setString(6, encryptedpassword);
			
			int result = preparedStatement.executeUpdate();//no of rows effected by DML statement. 1:one row inserted,.
			if(result>0) {
				Login login = new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encryptedpassword);
				login.setRegid(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepository.addCredentials(login);
				if(res.equals("success")) {
					connection.commit();
					return "success";
				}
				else {
					connection.rollback();
					return "failure";
				}
			}
			else {
				connection.rollback();
				return "failure";
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "failure";
		}
		finally {
			dbutils.closeConnection(connection);
		}
		
		
	}
	
	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		String selectStatement="select * from Register where regid=?";
		
		connection = dbutils.getConnection();
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
			preparedStatement.setString(1,id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {//next is used to traverse the Resultset
				
				Register register = new Register();
				register.setId(resultSet.getString("regid"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				register.setPassword(resultSet.getString("password"));
				return Optional.of(register);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbutils.closeConnection(connection);
		}
		
		return Optional.empty();
	}
	
	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional =getAllUserDetails();
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Register> list = optional.get();
			Register[] registers = new Register[list.size()];
			return list.toArray(registers);
		}
		
	}
	
	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		ArrayList<Register> arraylist = new ArrayList<>();
		
		String selectStatement="select * from Register";
		
		connection = dbutils.getConnection();
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
			//preparedStatement.setString(1,id);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {//next is used to traverse the Resultset
				
				Register register = new Register();
				register.setId(resultSet.getString("regid"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				register.setPassword(resultSet.getString("password"));
				arraylist.add(register);
			}
			return Optional.ofNullable(arraylist);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			dbutils.closeConnection(connection);
		}
		
		return Optional.empty();
	}
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		//ResultSet resultSet =null;
		
		String deleteStatement="delete from Register where regid=?";
		
		connection = dbutils.getConnection();
		try {
			preparedStatement=connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1,id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {//next is used to traverse the Resultset
				
				
				String res = loginRepository.deleteCredentials(id);
				if(res.equals("success")) {
					connection.commit();
					return "success";
				}
				else {
					connection.rollback();
					return res;
				}
			}
			else {
				connection.rollback();
				return "failure";
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			dbutils.closeConnection(connection);
		}
		return "failure";
	
	
	}
}
