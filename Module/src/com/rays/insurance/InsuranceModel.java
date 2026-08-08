package com.rays.insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rays.util.JDBCDataSource;

public class InsuranceModel {

//	-----------------------------------------Create--------------------------------------------
	public void Create() throws Exception{
		Connection conn = null;
		
		try {
			
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("create table insurance(policyId int PRIMARY KEY, policyHolderName varchar(50), policyType varchar(50), premiumAmount int, expiryDate date )");
			
			int i = pstmt.executeUpdate();
			conn.commit();
			
			System.out.println("Table Created Successfully");
			
		}catch(Exception e) {
			e.printStackTrace();
			conn.commit();
			
		}finally {
			conn.close();
		}
	}
	
//	--------------------------------------------------Insert-----------------------------------------------
	
	
	
}
