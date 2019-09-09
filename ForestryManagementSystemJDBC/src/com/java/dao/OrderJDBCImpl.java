package com.java.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.java.beans.Orders;

public class OrderJDBCImpl implements OrderDAO {

	@Override
	public Orders addOrders(Orders order) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		Orders state = null;
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
			String sql = "insert into orders values(?,?,?,?,?,?)";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1,order.getOrderNo());
			preparedstatement.setInt(2,order.getCustomerId());
			preparedstatement.setInt(3,order.getProductId());
			preparedstatement.setInt(4,order.getHaulierId());
			preparedstatement.setDate(5,order.getDeliveryDate());
			preparedstatement.setInt(6,order.getQuantity());

			int count = preparedstatement.executeUpdate();
			// 4. Process the result
			if(count > 0) {
				state = order;	
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
			if(preparedstatement!=null) {
				try {
					preparedstatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean modifyOrders(Integer orderId, Integer quantity) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
			String sql="update orders set Quantity=? where OrderNo=? ";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, orderId);
			// 4. process result
			int count=preparedStatement.executeUpdate();
			if(count>0) {
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


	@Override
	public boolean deleteOrders(Integer orderId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean state=false;
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
			String sql = "delete from orders where OrderNo=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,orderId);
			int count = preparedStatement.executeUpdate();
			// 4. Process the result

			if(count > 0) {
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
		return state;
	}
}
