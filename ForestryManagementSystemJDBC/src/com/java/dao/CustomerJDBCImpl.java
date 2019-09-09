package com.java.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.java.beans.Customer;

public class CustomerJDBCImpl implements CustomerDAO {

	@Override
	public Customer addCustomer(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sum=0;
		Customer state = null;
		try {

			// 1. load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Get the DB Connection via Driver

			String dbUrl="jdbc:mysql://localhost:3306/forestrymanagement_db?";
			FileReader in = new FileReader("C:/cleverIdiots/db.properties");
			Properties properties = new Properties();
			properties.load(in);
			connection = DriverManager.getConnection(dbUrl, properties);
			System.out.println("Connected...");

			// 3. issue sql queries
			String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,customer.getCustomerId());
			preparedStatement.setString(2,customer.getCustomerName());
			preparedStatement.setString(3,customer.getStreetAddress1());
			preparedStatement.setString(4,customer.getStreetAddress2());
			preparedStatement.setString(5,customer.getTownCity());
			preparedStatement.setInt(6,customer.getPostCode());
			preparedStatement.setLong(7,customer.getTelephoneNo());
			preparedStatement.setString(8,customer.getEmail());
			preparedStatement.setString(9,customer.getPassword());

			int count = preparedStatement.executeUpdate();
			// 4. Process the result
			if(count > 0) {
				sum++;
				state = customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. close all jdbc objects
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(sum >0)
		{
			return state;
		}else {
			System.out.println(state);
			return state;
		}
	}

	@Override
	public boolean deleteCustomer(Integer customerId, String customerPassword) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sum=0;
		boolean state = false;
		try {
			// 1. load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Get the DB Connection via Driver

			String dbUrl="jdbc:mysql://localhost:3306/forestrymanagement_db?";
			FileReader in = new FileReader("C:/cleverIdiots/db.properties");
			Properties props = new Properties();
			props.load(in);
			connection = DriverManager.getConnection(dbUrl, props);
			System.out.println("Connected...");
			// 3. issue sql queries
			String sql = "delete from customer where customer_id=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,customerId);
			//	pstmt.setString(2,customerPassword);
			int count = preparedStatement.executeUpdate();
			// 4. Process the result

			if(count > 0) {
				sum++;
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. close all jdbc objects
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(sum > 0)
		{
			return state;
		} else
		{
			return state;
		}

	}

	@Override
	public Customer modifyCustomer(Customer customer ,Integer customerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Customer state = null;
		try {
			// 1. load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. get connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagement_db";
			connection=DriverManager.getConnection(dbUrl,"root","root");
			// 3. issue sql queries
			String sql="update customer set customer_name =? , password=?,streetaddress1 =? ,streetaddress2=?,town_city=?,"
					+ "postcode=? ,telephoneno=? , email=? where customer_id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,customer.getCustomerName());
			preparedStatement.setString(2,customer.getPassword());
			preparedStatement.setString(3,customer.getStreetAddress1());
			preparedStatement.setString(4,customer.getStreetAddress2());
			preparedStatement.setString(5,customer.getTownCity());
			preparedStatement.setInt(6,customer.getPostCode());
			preparedStatement.setLong(7,customer.getTelephoneNo());
			preparedStatement.setString(8,customer.getEmail());
			preparedStatement.setInt(9,customer.getCustomerId());
			// 4. process result
			int count=preparedStatement.executeUpdate();
			if(count>0) {
				state = customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. close all jdbc objects
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}
}