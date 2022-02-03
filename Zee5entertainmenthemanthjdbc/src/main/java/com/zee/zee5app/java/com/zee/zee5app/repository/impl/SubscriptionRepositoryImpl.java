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

import org.springframework.stereotype.Repository;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.repository.SubscriptionRepository;
//import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.utils.DBUtils;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository{
	public SubscriptionRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static SubscriptionRepository repository;
	DBUtils dbutils = DBUtils.getInstance();
	
	/*public static SubscriptionRepository getInstance() throws IOException {
		if(repository==null) {
			repository=new SubscriptionRepositoryImpl();
			return repository;
		}
		return repository;
	}*/
	//private Subscriptions[] Subscriptionss = new Subscriptions[10];
	private ArrayList<Subscriptions> set = new ArrayList();
	//private static int count = -1;

	@Override
	public String addSubscription(Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into subscription"+" (id,dop,expiry,amount,paymentmode,status,subscriptiontype,autorenewal,regId)"+"values(?,?,?,?,?,?,?,?,?)";
		
		connection= dbutils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, Subscriptions.getId());
			preparedStatement.setString(2, Subscriptions.getDop());
			preparedStatement.setString(3,Subscriptions.getExpiry());
			preparedStatement.setString(4,Subscriptions.getAmount());
			preparedStatement.setString(5,Subscriptions.getPaymentmode());
			preparedStatement.setString(6,Subscriptions.getStatus());
			preparedStatement.setString(7,Subscriptions.getSubscriptiontype());
			preparedStatement.setString(8,Subscriptions.getAutorenewal());
			preparedStatement.setString(9,Subscriptions.getRegid());
			
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
	public String updateSubscription(String id, Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Subscriptions> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		String selectStatement="select * from subscriptions where id=?";
		
		connection = dbutils.getConnection();
		Subscriptions subscriptions = new Subscriptions();
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
			preparedStatement.setString(1,id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {//next is used to traverse the Resultset
				
				
				subscriptions.setId(resultSet.getString("id"));
				subscriptions.setDop(resultSet.getString("dop"));
				subscriptions.setExpiry(resultSet.getString("expiry"));
				try {
					subscriptions.setamount(resultSet.getString("amount"));
				} catch (InvalidAmountException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				subscriptions.setPaymentmode(resultSet.getString("paymentmode"));
				subscriptions.setStatus(resultSet.getString("status"));
				subscriptions.setSubscriptiontype(resultSet.getString("subscriptiontype"));
				subscriptions.setAutorenewal(resultSet.getString("autorenewal"));
				subscriptions.setRegid(resultSet.getString("regId"));
				
				return Optional.of(subscriptions);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbutils.closeConnection(connection);
		}
		return Optional.ofNullable(Optional.of(subscriptions)).orElseThrow(()-> new IdNotFoundException("id not found"));
		
		
	}
	@Override
	public Subscriptions[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Subscriptions> getAllSubscriptionDetails() {
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
				
				Subscriptions subscriptions = new Subscriptions();
				subscriptions.setId(resultSet.getString("id"));
				subscriptions.setDop(resultSet.getString("dop"));
				subscriptions.setExpiry(resultSet.getString("expiry"));
				try {
					subscriptions.setamount(resultSet.getString("amount"));
				} catch (InvalidAmountException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				subscriptions.setPaymentmode(resultSet.getString("paymentmode"));
				subscriptions.setStatus(resultSet.getString("status"));
				subscriptions.setSubscriptiontype(resultSet.getString("subscriptiontype"));
				subscriptions.setAutorenewal(resultSet.getString("autorenewal"));
				subscriptions.setRegid(resultSet.getString("regId"));
				
				set.add(subscriptions);
			}
			return set;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbutils.closeConnection(connection);
		}
		
		return set;
		
	}
	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		//ResultSet resultSet =null;
		
		String deleteStatement="delete from subscription where id=?";
		
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

	/*@Override
	public String addSubscription(Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		
		boolean result = this.set.add(Subscriptions);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}
	@Override //assignment 21-01-22
	public String updateSubscription(String id, Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		for(Subscriptions Subscription2: set) {
			if(Subscription2.getId().equals(id)) {
				boolean result = this.set.remove(Subscription2);
				boolean result2 = this.set.add(Subscriptions);
				return "success";
				
			}
		}
		return "failure";
	}
	@Override
	public Optional<Subscriptions> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Subscriptions Subscriptions2 = null;
		for(Subscriptions Subscriptions: set) {
			if(Subscriptions.getId().equals(id)) {
				Subscriptions2 = Subscriptions;
				break;
			}
		}
		
		return Optional.ofNullable(Optional.of(Subscriptions2)).orElseThrow(()-> new IdNotFoundException("id not found"));
	}
	
	@Override
	public Subscriptions[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		Subscriptions Subscriptions[]=new Subscriptions[set.size()];
		return set.toArray(Subscriptions);
	}
	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Subscriptions> optional = this.getSubscriptionById(id);
		
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
	
	public ArrayList<Subscriptions> getAllSubscriptionDetails(){
	  
		//Collections.sort((List<Subscriptions>)set);
	  
		return new ArrayList<Subscriptions>(set);
		//return new ArrayList<Subscriptions>(set.descendingSet());  //descending order
	}
	  //assignment 21-01-22: */
	
}
