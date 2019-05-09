package main.java.net.company.utils;

import java.util.Scanner;

public class UserInterface {
	
	private static Scanner sc = new Scanner(System.in);

	public static void rootMenu()
	{
		System.out.println("Plz select from the following options ::\n");
		
		System.out.println("1. Press 1 for Company Admin\n");
		System.out.println("2. Press 2 for Ticket Booking Employee\n");
		System.out.println("3. Press 3 for exit!\n");
	}
	
	public static void adminOptions(){
		
		System.out.println("\nPlz select from the following options ::\n");
		
		System.out.println("1. Add bus");
		System.out.println("2. Show Available Buses");
		System.out.println("3. Delete Bus");
		System.out.println("4. Add Bus Ticket Seller");
		System.out.println("5. Show Current Ticket Sellers");
		System.out.println("6. Delete Ticket Seller");
		System.out.println("7. Exit! ");
	}
	
	public static void userOptions()
	{
		System.out.println("\nPlz select from the following options ::\n");
		
		System.out.println("1. Show Available Buses");
		System.out.println("2. See Current Seat Mapping of specific bus");
		System.out.println("3. Book a Seat");
		System.out.println("4. Cancel Booking");
		System.out.println("5. Exit! ");
	}
	
	public static boolean promptForMasterPass()
	{
		String username = "harcoded_temp_user";
		String pass = "harcoded_temp_pass";
		
		System.out.print("Plz Enter Admin's Master Username :: ");
		String u = sc.nextLine();
		System.out.print("Enter Admin's Master Password :: ");
		String p = sc.nextLine();
		
		if(u.equals(username) && p.equals(pass)) 
		{
			System.out.println("\nAdmin Acces Granted!!\n");
			return true;
		}
		else 
		{
			System.out.println("\nWrong Master Username/Password!! Acces Denied!!\n");
			return false;
		}
		
	}
}
