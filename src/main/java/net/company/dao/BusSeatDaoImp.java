package main.java.net.company.dao;

import java.sql.*;
import java.util.Scanner;

import main.java.net.company.entities.BusSeat;
import main.java.net.company.utils.ConnectionManager;


public class BusSeatDaoImp implements BusSeatDao {

	private final String SHOW_SEATS = "SELECT * from seats_table WHERE BusId = ?";
	private final String CHECK_SEAT_AVAIL = "SELECT * from seats_table WHERE BusId = ? and SeatId = ?";
	private final String DEL_BOOKED_PASSENGER = "DELETE from seats_table WHERE BusId = ? and SeatId = ?";
	private final String INSERT_INTO_SEATS_TABLE_BOOK = "INSERT INTO seats_table(BusId, SeatId, Passenger_Name, Passenger_Age, Paseenger_Phone) VALUES(? , ?, ?, ?, ?) ";
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void showSeatsByCoachNumber() {
		
		System.out.println("Enter Coach Number to see Seat Mapping :: ");
		int bid = sc.nextInt();
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
    
        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(SHOW_SEATS);

            preparedStatement.setInt(1, bid);
            resultSet = preparedStatement.executeQuery();
        	
        	System.out.println("Detailed Seat Map for Bus No :: " + bid + "\n");
        	
        	System.out.println("*********************************************************************\n");
        
        	String[] sa = new String[33];
        
        	while(resultSet.next())
        	{
        		sa[resultSet.getInt(2)] = resultSet.getString(3);
        	}
        	
        	for(int i=1; i<sa.length; i++)
        	{
        		if(i<10) System.out.print("0");
        		System.out.print(i + ". ");
        		
        		if(sa[i]==null)
        		{
        			System.out.printf("%-12s", "Empty");
        			//System.out.print(MyLibraryClass.setw(12, "Empty"));
        		}
        		else 
        			System.out.printf("%-12s", sa[i]);;
        			//System.out.print(MyLibraryClass.setw(12, sa[i]));
        		
        		if(i%4==0) System.out.println("");
        		else if(i%2==0) System.out.printf("%-9s", "||"); //System.out.print(MyLibraryClass.setw(9, "||"));
        	}
        	System.out.println("\n\n*********************************************************************\n");
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        }finally {
            ConnectionManager.close(resultSet);
            ConnectionManager.close(preparedStatement);
            ConnectionManager.close(connection);
        }
	}

	@Override
	public boolean reserveSeatofCoachNumber() {
		
		System.out.println("Enter Coach Number to book Seat :: ");
		int bid = sc.nextInt();
		
		BusSeat busSeat = new BusSeat();
		
		System.out.println("Plz Enter your desired Seat No:: ");
		int seatNo = sc.nextInt();
		
		if(seatNo>32 || seatNo<1 )
		{
			System.out.println("Invalid Seat Number!");
			return false;
		}
		else 
		{
			//Update db
			
			Connection connection = null;
	        PreparedStatement preparedStatement = null, preparedStatement2 = null;        
	        ResultSet resultSet = null;
	        
	        try
	        {
	        	connection = ConnectionManager.getConnection();
	        	
	        	preparedStatement2 = connection.prepareStatement(CHECK_SEAT_AVAIL);
	        	preparedStatement2.setInt(1, bid);
	        	preparedStatement2.setInt(2, seatNo);
	        	resultSet = preparedStatement2.executeQuery();
	        	
	        	
	        	while(resultSet.next())
	        	{
	        		if(seatNo==resultSet.getInt(2))
	        		{
	        			System.out.println("\n***Seat Already Sold. Try Another One Plz. ***\n");
	        			return false;
	        		}
	        	}
	        	
	        	busSeat.book(seatNo);
	        	
	        	preparedStatement = connection.prepareStatement(INSERT_INTO_SEATS_TABLE_BOOK);
	        	preparedStatement.setInt(1, bid);
	        	preparedStatement.setInt(2, seatNo);	        	
	        	preparedStatement.setInt(2, busSeat.getSeat_no());
	        	preparedStatement.setString(3, busSeat.getPassenger().getName());
	        	preparedStatement.setString(4, busSeat.getPassenger().getAge());
	        	preparedStatement.setString(5, busSeat.getPassenger().getNumber());
	        	
	        	preparedStatement.executeUpdate();
	        	return true;
	        }
	        catch(Exception e) 
	        {
	        	e.printStackTrace();
	        }
	        finally {
	            ConnectionManager.close(preparedStatement);
	            ConnectionManager.close(connection);
	        }
			
			return true;
		}
	}

	@Override
	public void cancelTicketBySeatNo() {
		
		System.out.println("Enter Coach Number to Cancel Seat :: ");
		int bid = sc.nextInt();
		
		System.out.println("Plz Enter your Previosly Boooked Seat No:: ");
		int seatNo = sc.nextInt();
		
		if(seatNo>32 || seatNo<1 )
		{
			System.out.println("Invalid Seat Number!");
		}
		else 
		{
			//Update db
			
			Connection connection = null;
	        PreparedStatement preparedStatement = null;;        
	        
	        try
	        {
	        	connection = ConnectionManager.getConnection();
	        	
	        	preparedStatement = connection.prepareStatement(DEL_BOOKED_PASSENGER);
	        	preparedStatement.setInt(1, bid);
	        	preparedStatement.setInt(2, seatNo);
	        	
	        	int rows = preparedStatement.executeUpdate();
	        	
	        	if(rows==0)
				{
					System.out.println("\n\n**Operation Failed! Cannot Cancel!Seat not booked Yet!!");
				}
				else 
				{
					System.out.println("\n\n**Operation Succesful!  Booked Seat Canceled!!**");
				}
	        	
	        }
	        catch(Exception e) 
	        {
	        	e.printStackTrace();
	        }
	        finally {
	            ConnectionManager.close(preparedStatement);
	            ConnectionManager.close(connection);
	        }
		}
	}
	
}
