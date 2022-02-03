package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

@Repository
public class LoginRepositoryImpl implements LoginRepository{

	//private static LoginRepository repository;
	
	@Autowired
	DataSource dataSource;
	//DBUtils dbutils = null;
	public LoginRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
		//dbutils = DBUtils.getInstance();
	}
	/*public static LoginRepository getInstance() throws IOException{
		if(repository==null) {
			repository=new LoginRepositoryImpl();
			return repository;
		}
		return repository;
	}*/

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String insertStatement = "insert into login"+" (username, password, regid, role)"+"values(?,?,?,?)";
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getRegid());
			preparedStatement.setString(4, login.getRole().toString());
			
			int result = preparedStatement.executeUpdate();
			//connection.commit();
			if(result>0) {
				//connection.commit();
				return "success";
			}
			else {
				connection.rollback();
				return "failure";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			//dbutils.closeConnection(connection);
		}
		return "failure";
	}

	@Override
	public String deleteCredentials(String userName) {// didnt change this, Im passing regid instead of username
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//ResultSet resultSet =null;
		
		String deleteStatement="delete from login where regId=?";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1,userName);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {//next is used to traverse the Resultset
				//connection.commit();
				return "success";
			}
			else {
				connection.rollback();
				return "failure";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			//dbutils.closeConnection(connection);
		}
		return "failure";
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String updateStatement = "update login set role=? WHERE username=?";
		PreparedStatement preparedStatement;
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, userName);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "success";
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
			//dbutils.closeConnection(connection);
		}
	}

}
