package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

public class MoviesRepositoryImpl implements MoviesRepository{
	public MoviesRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	private static MoviesRepository repository;
	DBUtils dbutils = DBUtils.getInstance();
	
	public static MoviesRepository getInstance() throws IOException {
		if(repository==null) {
			repository=new MoviesRepositoryImpl();
			return repository;
		}
		return repository;
	}
	
	private HashSet<Movies> set = new HashSet();

	@Override
	public String addMovie(Movies Movies) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into movies"+" (id,name,agelimit,cast,genere,length,trailer,releasedate,language)"+"values(?,?,?,?,?,?,?,?,?)";
		
		connection= dbutils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, Movies.getId());
			preparedStatement.setString(2, Movies.getName());
			preparedStatement.setString(3, Movies.getAgelimit());
			preparedStatement.setString(4, Movies.getCast());
			preparedStatement.setString(5, Movies.getGenre());
			preparedStatement.setString(6, Movies.getLength());
			preparedStatement.setString(7, Movies.getTrailer());
			preparedStatement.setString(8, Movies.getReleasedate());
			preparedStatement.setString(9, Movies.getLanguage());
			
			int result = preparedStatement.executeUpdate();//no of rows effected by DML statement. 1:one row inserted,.
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
			dbutils.closeConnection(connection);
		}
		/*boolean result = this.set.add(Movies);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";*/
	}

	@Override
	public String updateMovie(String id, Movies Movies) {
		// TODO Auto-generated method stub
		
		for(Movies Movies2: set) {
			if(Movies2.getId().equals(id)) {
				boolean result = this.set.remove(Movies2);
				boolean result2 = this.set.add(Movies);
				return "success";
				
			}
		}
		return "failure";
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		String selectStatement="select * from movies where id=?";
		
		connection = dbutils.getConnection();
		Movies movies = new Movies();
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
			preparedStatement.setString(1,id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {//next is used to traverse the Resultset
				
				movies.setId(resultSet.getString("id"));
				movies.setName(resultSet.getString("name"));
				movies.setAgelimit(resultSet.getString("agelimit"));
				movies.setCast(resultSet.getString("cast"));
				movies.setGenre(resultSet.getString("genere"));
				movies.setLength(resultSet.getString("length"));
				movies.setReleasedate(resultSet.getString("releasedate"));
				movies.setLanguage(resultSet.getString("language"));
				return Optional.of(movies);
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
		return Optional.ofNullable(Optional.of(movies)).orElseThrow(()-> new IdNotFoundException("id not found"));
		
		/*Movies Movies2 = null;
		for(Movies Movies: set) {
			if(Movies.getId().equals(id)) {
				Movies2 = Movies;
				break;
			}
		}
		
		return Optional.ofNullable(Optional.of(Movies2)).orElseThrow(()-> new IdNotFoundException("id not found"));
		*/
	}

	@Override
	public Movies[] getAllMovies() {
		// TODO Auto-generated method stub
		Movies Movies[]=new Movies[set.size()];
		return set.toArray(Movies);
	}

	@Override
	public HashSet<Movies> getAllMovieDetails() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		String selectStatement="select * from movies";
		
		connection = dbutils.getConnection();
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {//next is used to traverse the Resultset
				
				Movies movies = new Movies();
				movies.setId(resultSet.getString("id"));
				movies.setName(resultSet.getString("name"));
				movies.setAgelimit(resultSet.getString("agelimit"));
				movies.setCast(resultSet.getString("cast"));
				movies.setGenre(resultSet.getString("genere"));
				movies.setLength(resultSet.getString("length"));
				movies.setReleasedate(resultSet.getString("releasedate"));
				movies.setLanguage(resultSet.getString("language"));
				
				set.add(movies);
			}
			return set;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			dbutils.closeConnection(connection);
		}
		
		return set;
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Connection connection;
		PreparedStatement preparedStatement;
		//ResultSet resultSet =null;
		
		String deleteStatement="delete from movies where id=?";
		
		connection = dbutils.getConnection();
		try {
			preparedStatement=connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1,id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {//next is used to traverse the Resultset
				
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
		}
		finally {
			dbutils.closeConnection(connection);
		}
		return "failure";
		
		/*Optional<Movies> optional = this.getMovieById(id);
		
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
		return "failure";*/
	}
	
}
