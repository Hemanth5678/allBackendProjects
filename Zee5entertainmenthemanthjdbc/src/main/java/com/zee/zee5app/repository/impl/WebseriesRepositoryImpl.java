package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.repository.WebseriesRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.repository.WebseriesRepository;

public class WebseriesRepositoryImpl implements WebseriesRepository{

	public WebseriesRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	private static WebseriesRepository repository;
	DBUtils dbutils = DBUtils.getInstance();
	
	public static WebseriesRepository getInstance() throws IOException {
		if(repository==null) {
			repository=new WebseriesRepositoryImpl();
			return repository;
		}
		return repository;
	}
	
	private TreeSet<Webseries> set = new TreeSet<Webseries>();

	@Override
	public String addWebseries(Webseries Webseries) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into Webseries"+" (id,name,agelimit,cast,genere,length,trailer,releasedate,language,noofepisodes)"+"values(?,?,?,?,?,?,?,?,?,?)";
		
		connection= dbutils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, Webseries.getId());
			preparedStatement.setString(2, Webseries.getName());
			preparedStatement.setString(3, Webseries.getAgelimit());
			preparedStatement.setString(4, Webseries.getCast());
			preparedStatement.setString(5, Webseries.getGenre());
			preparedStatement.setString(6, Webseries.getLength());
			preparedStatement.setString(7, Webseries.getTrailer());
			preparedStatement.setString(8, Webseries.getReleasedate());
			preparedStatement.setString(9, Webseries.getLanguage());
			preparedStatement.setString(10, Webseries.getNoofepisodes());
			
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
	}

	@Override
	public String updateWebseries(String id, Webseries Webseries) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Webseries> getWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		String selectStatement="select * from webseries where id=?";
		
		connection = dbutils.getConnection();
		Webseries webseries = new Webseries();
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
			preparedStatement.setString(1,id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {//next is used to traverse the Resultset
				
				webseries.setId(resultSet.getString("id"));
				webseries.setName(resultSet.getString("name"));
				webseries.setAgelimit(resultSet.getString("agelimit"));
				webseries.setCast(resultSet.getString("cast"));
				webseries.setGenre(resultSet.getString("genere"));
				webseries.setLength(resultSet.getString("length"));
				webseries.setReleasedate(resultSet.getString("releasedate"));
				webseries.setLanguage(resultSet.getString("language"));
				webseries.setNoofepisodes(resultSet.getString("noofepisodes"));
				return Optional.of(webseries);
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
		return Optional.ofNullable(Optional.of(webseries)).orElseThrow(()-> new IdNotFoundException("id not found"));
		
	}

	@Override
	public Webseries[] getAllWebseries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Webseries> getAllWebseriesDetails() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		String selectStatement="select * from webseries";
		
		connection = dbutils.getConnection();
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {//next is used to traverse the Resultset
				
				Webseries webseries = new Webseries();
				webseries.setId(resultSet.getString("id"));
				webseries.setName(resultSet.getString("name"));
				webseries.setAgelimit(resultSet.getString("agelimit"));
				webseries.setCast(resultSet.getString("cast"));
				webseries.setGenre(resultSet.getString("genere"));
				webseries.setLength(resultSet.getString("length"));
				webseries.setReleasedate(resultSet.getString("releasedate"));
				webseries.setLanguage(resultSet.getString("language"));
				webseries.setNoofepisodes(resultSet.getString("noofepisodes"));
				
				set.add(webseries);
			}
			return new ArrayList<Webseries>(set);
			
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
		
		return new ArrayList<Webseries>(set);
	}

	@Override
	public String deleteWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		//ResultSet resultSet =null;
		
		String deleteStatement="delete from webseries where id=?";
		
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
	}
	
	
	/*
	@Override
	public String addWebseries(Webseries Webseries) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(Webseries);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateWebseries(String id, Webseries Webseries) {
		// TODO Auto-generated method stub
		for(Webseries Webseries2: set) {
			if(Webseries2.getId().equals(id)) {
				boolean result = this.set.remove(Webseries2);
				boolean result2 = this.set.add(Webseries);
				return "success";
				
			}
		}
		return "failure";
	}

	@Override
	public Optional<Webseries> getWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Webseries Webseries2 = null;
		for(Webseries Webseries: set) {
			if(Webseries.getId().equals(id)) {
				Webseries2 = Webseries;
				break;
			}
		}
		
		return Optional.ofNullable(Optional.of(Webseries2)).orElseThrow(()-> new IdNotFoundException("id not found"));
	}

	@Override
	public Webseries[] getAllWebseries() {
		// TODO Auto-generated method stub
		Webseries Webseries[]=new Webseries[set.size()];
		return set.toArray(Webseries);
	}

	@Override
	public List<Webseries> getAllWebseriesDetails() {
		// TODO Auto-generated method stub
		return new ArrayList<Webseries>(set);
	}

	@Override
	public String deleteWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
Optional<Webseries> optional = this.getWebseriesById(id);
		
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
	 */
}
