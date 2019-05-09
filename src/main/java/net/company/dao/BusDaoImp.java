package main.java.net.company.dao;

import main.java.net.company.entities.Bus;
import main.java.net.company.utils.*;

import java.sql.*;
import java.util.Scanner;


public class BusDaoImp implements BusDao {

	 private final String INSERT_INTO_BUSES_TABLE = "INSERT INTO buses_table (BusId, Driver, Depart_hr, Depart_min, Arrival_hr, Arrival_min, Start_Location, Destination, TicketPrice) VALUES (?,?,? , ?,?,? , ?,?,?)";
	 private final String SHOW_BUSES_TABLE = "SELECT * from buses_table";
	 private final String DELETE_BUS = "DELETE FROM buses_table WHERE BusId = ?";
	 private Scanner sc = new Scanner(System.in);
	@Override
	public void addBus()
	{		
			Bus bus = new Bus();
			bus.setBus();
			
			Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        
	        try
	        {
	        	connection = ConnectionManager.getConnection();
	        	
	        	preparedStatement = connection.prepareStatement(INSERT_INTO_BUSES_TABLE);
	        	
	        	preparedStatement.setInt(1, bus.getBid());
	        	preparedStatement.setString(2, bus.getDriver());
	        	preparedStatement.setInt(3, bus.getDepart_hr());
	        	preparedStatement.setInt(4, bus.getDepart_min());
	        	preparedStatement.setInt(5, bus.getArr_hr());
	        	preparedStatement.setInt(6, bus.getArr_min());
	        	preparedStatement.setString(7, bus.getStart());
	        	preparedStatement.setString(8, bus.getDestination());
	        	preparedStatement.setInt(9, bus.getTicketPrice());
	        	
	        	preparedStatement.executeUpdate();

	        	System.out.println("\n\n**Operation Succesful! New Bus Added!**");
	        }
	        catch(Exception e) 
	        {
	        	System.out.println("\n **** Duplicate Entry! Invalid Coach Number!! ***");
				System.out.println("**** Try Again Plz!! *****");
	        	//e.printStackTrace();
	        	
	        }
	}

	
	@Override
	public void showBuses() {
		
        Connection connection = null;
        
        PreparedStatement preparedStatement = null;
        
        ResultSet resultset = null;
        
        try
        {
        	connection = ConnectionManager.getConnection();
        	preparedStatement = connection.prepareStatement(SHOW_BUSES_TABLE);
       
        	resultset = preparedStatement.executeQuery();
        	
        	System.out.println("Available bus list of the Company:: \n");
        	
        	while(resultset.next())
        	{
        		System.out.println( "Coach Number    :: " + resultset.getInt(1) + "\n" +
        							"Driver's Name   :: " + resultset.getString(2) + "\n" +
        							"Booking Counter :: " + resultset.getString(7) + "\n" +
        							"Destination     :: " + resultset.getString(8) + "\n" + 
        							"Departure Time  :: " + resultset.getInt(3) + ":" + resultset.getInt(4) + "\n" + 
        							"Arrival Time    :: " + resultset.getInt(5) + ":" + resultset.getInt(6) + "\n" +
        							"Ticket Price 	:: " + resultset.getInt(9) + "\n"	
        				);
        		
        		System.out.println("*************************************\n");
        	}
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        }
        
    }

	@Override
	public void deleteBusbyCoachNumber() {
		
			System.out.println("Enter Coach Number to Delete ::");
			int bid = sc.nextInt();
		
			Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        try {
	            connection = ConnectionManager.getConnection();

	            preparedStatement = connection.prepareStatement(DELETE_BUS);
	            preparedStatement.setInt(1, bid);
	          
	            int rows = preparedStatement.executeUpdate();
	            
	            if(rows==0)
	            	System.out.println("\n\n**Operation Failed! No Bus with This Coach Number Found1!**");
	            else 
	            	System.out.println("\n\n**Operation Succesful! Bus Deleted!**");
	            
	        } catch (Exception e) {
	            if (connection != null) {
	                try {
	                    connection.rollback();
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	            e.printStackTrace();

	        } finally {
	            if (connection != null) {
	                try {
	                    connection.setAutoCommit(true);
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            ConnectionManager.close(preparedStatement);
	            ConnectionManager.close(connection);
	        }
	   }

//	@Override
//	public void updateBus(int bid) {
//		// TODO Auto-generated method stub
//		
//	}



}
