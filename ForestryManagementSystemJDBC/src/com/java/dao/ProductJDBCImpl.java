package com.java.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.java.beans.Product;

public class ProductJDBCImpl implements ProductDAO {

	@Override
	public Product addProduct(Product product) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Product state = null;
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
			String sql = "insert into product values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,product.getProductId());
			preparedStatement.setString(2,product.getProductName());
			preparedStatement.setString(3,product.getProductDescription());

			int count = preparedStatement.executeUpdate();
			// 4. Process the result
			if(count > 0) {
				state = product;
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

	@Override
	public Product modifyProduct(Integer productId, Product product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Product state = null;
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
			String sql="update product set product_Name =? , product_Description=? where product_id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,product.getProductName());
			preparedStatement.setString(2,product.getProductDescription());
			preparedStatement.setInt(3, productId);

			// 4. process result
			int count=preparedStatement.executeUpdate();
			if(count>0) {
				state = product;
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
	public boolean deleteProduct(Integer productId) {
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
			String sql = "delete from product where Product_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,productId);
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
