package com.java.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.java.beans.Contract;

public class ContractJDBCImpl implements ContractDAO{

	@Override
	public Contract addContractor(Contract contract) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Contract state = null;
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
			String sql = "insert into contract values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,contract.getContractNo());
			preparedStatement.setInt(2,contract.getCustomerId());
			preparedStatement.setInt(3,contract.getProductId());
			preparedStatement.setInt(4,contract.getHaulierId());
			preparedStatement.setDate(5,contract.getDeliveryDate());
			preparedStatement.setString(6,contract.getDeliveryDay());
			preparedStatement.setInt(7,contract.getQuantity());
			int count = preparedStatement.executeUpdate();
			// 4. Process the result
			if(count > 0) {
				state = contract;
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
	public boolean deleteContractor(Integer contractNo) {
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
			String sql = "delete from contract where ContractNo=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,contractNo);
			int count = preparedStatement.executeUpdate();
			// 4. Process the result

			if(count > 0) {
				state = true;			}
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
