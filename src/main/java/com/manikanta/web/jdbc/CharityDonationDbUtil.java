package com.manikanta.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class CharityDonationDbUtil {
	
	private DataSource dataSource;

	public CharityDonationDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<CharityDonation> getCharityDonations() throws Exception {
		
		List<CharityDonation> charityDonations = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from charityDonation order by receipt";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				System.out.println("myRs is: " + myRs);
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String financialYear = myRs.getString("financial_year");
				double amount = myRs.getDouble("amount");
				String receipt = myRs.getString("receipt");
				String institution = myRs.getString("institution");
				String address = myRs.getString("address");
				String pan = myRs.getString("pan");
				String receipts = myRs.getString("receipts");
				String remarks = myRs.getString("remarks");

				// create new charityDonation object
				CharityDonation tempCharityDonation = new CharityDonation(id, financialYear, amount, receipt, institution, address, pan, receipts, remarks);
				
				// add it to the list of charityDonations
				charityDonations.add(tempCharityDonation);	
				System.out.println("tempCharityDonation is: " + tempCharityDonation);
			}
			
			return charityDonations;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
				System.out.println("myRs closed");
			}
			
			if (myStmt != null) {
				myStmt.close();
				System.out.println("myStmt closed");
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
				System.out.println("myConn closed");
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}


	public void addCharityDonation(CharityDonation theCharityDonation) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into charityDonation "
					   + "(financial_year, amount, receipt, institution, address, pan, receipts, remarks) "
					   + "values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the charityDonation
			myStmt.setString(1, theCharityDonation.getFinancialYear());
			myStmt.setDouble(2, theCharityDonation.getAmount());
			myStmt.setString(3, theCharityDonation.getReceipt());
			myStmt.setString(4, theCharityDonation.getInstitution());
			myStmt.setString(5, theCharityDonation.getAddress());
			myStmt.setString(6, theCharityDonation.getPan());
			myStmt.setString(7, theCharityDonation.getReceipts());
			myStmt.setString(8, theCharityDonation.getRemarks());

			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public CharityDonation getCharityDonation(String theCharityDonationId) throws Exception {

		CharityDonation theCharityDonation = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int charityDonationId;
		
		try {
			// convert charityDonation id to int
			charityDonationId = Integer.parseInt(theCharityDonationId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected charityDonation
			String sql = "select * from charityDonation where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, charityDonationId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String financialYear = myRs.getString("financial_year");
				double amount = myRs.getDouble("amount");
				String receipt = myRs.getString("receipt");
				String institution = myRs.getString("institution");
				String address = myRs.getString("address");
				String pan = myRs.getString("pan");
				String receipts = myRs.getString("receipts");
				String remarks = myRs.getString("remarks");
				
				// use the charityDonationId during construction
				theCharityDonation = new CharityDonation(charityDonationId, financialYear, amount, receipt, institution, address, pan, receipts, remarks);
			}
			else {
				throw new Exception("Could not find charityDonation id: " + charityDonationId);
			}				
			
			return theCharityDonation;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateCharityDonation(CharityDonation theCharityDonation) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update charityDonation "
						+ "set financial_year=?, amount=?, receipt=?, institution=?, address=?, pan=?, receipts=?, remarks=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theCharityDonation.getFinancialYear());
			myStmt.setDouble(2, theCharityDonation.getAmount());
			myStmt.setString(3, theCharityDonation.getReceipt());
			myStmt.setString(4, theCharityDonation.getInstitution());
			myStmt.setString(5, theCharityDonation.getAddress());
			myStmt.setString(6, theCharityDonation.getPan());
			myStmt.setString(7, theCharityDonation.getReceipts());
			myStmt.setString(8, theCharityDonation.getRemarks());
			myStmt.setInt(9, theCharityDonation.getId());
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteCharityDonation(String theCharityDonationId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert charityDonation id to int
			int charityDonationId = Integer.parseInt(theCharityDonationId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete charityDonation
			String sql = "delete from charityDonation where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, charityDonationId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}
