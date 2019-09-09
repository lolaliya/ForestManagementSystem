package com.java.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.java.beans.Haulier;

public class HaulierJDBCImpl implements HaulierDAO  {

	@Override
	public Haulier addHaulier(Haulier haulier) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Haulier state = null;
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
			String sql = "insert into haulier values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,haulier.getHaulierId());
			preparedStatement.setString(2,haulier.getHaulierName());
			preparedStatement.setString(3,haulier.getStreetAddress1());
			preparedStatement.setString(4,haulier.getStreetAddress2());
			preparedStatement.setString(5,haulier.getTownCity());
			preparedStatement.setInt(6,haulier.getPostCode());
			preparedStatement.setLong(7,haulier.getTelephoneNo());
			preparedStatement.setString(8,haulier.getEmail());

			int count = preparedStatement.executeUpdate();
			// 4. Process the result
			if(count > 0) {
				state = haulier;
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
	public boolean deleteHaulier(Integer haulierId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean state=false;
		try {
			// 1. load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. get connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagement_db";
			con=DriverManager.getConnection(dbUrl,"root","root");
			// 3. issue sql queries
			String sql = "delete from haulier where haulier_id=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,haulierId);
			int count = pstmt.executeUpdate();
			// 4. Process the result

			if(count > 0) {
				state = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. close all jdbc objects
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}
}
