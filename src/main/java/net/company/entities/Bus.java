package main.java.net.company.entities;

import java.util.Scanner;

public class Bus {
	private int bid;
	private String driver;
	private int arr_hr, arr_min;
	private int depart_hr, depart_min;
	private String start,destination;
	public int ticketPrice;
	private Scanner sc = new Scanner(System.in);
	
	public Bus()
	{
		
	}

	Bus(int b, String d, int x, int y, int p, int q, String st, String ds, int tt )
	{
		this.bid = b;
		this.driver = d;
		
		this.depart_hr = p;
		this.depart_min = q;
		this.arr_hr = x;
		this.arr_min = y;
	
		
		this.start = st;
		this.destination = ds;
		this.ticketPrice = tt;
	}
	
	
	public void setBus()
	{
		
		System.out.print("Enter Bus Coach Number :: ");
		this.bid = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Driver's Name :: ");
		this.driver = sc.nextLine();
		
		System.out.print("Enter Departure Hour :: ");
		this.depart_hr = sc.nextInt();
		System.out.print("Enter Departure Min :: ");
		this.depart_min = sc.nextInt();
		System.out.print("Enter Arrival Hour :: ");
		this.arr_hr = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Arrival Min :: ");
		this.arr_min = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Enter Booking Counter :: ");
		this.start = sc.nextLine();
		System.out.print("Enter Destination Location :: ");
		this.destination = sc.nextLine();
		
		System.out.print("Enter Ticket Price :: ");
		this.ticketPrice = sc.nextInt();
	}
	

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getArr_hr() {
		return arr_hr;
	}

	public void setArr_hr(int arr_hr) {
		this.arr_hr = arr_hr;
	}

	public int getArr_min() {
		return arr_min;
	}

	public void setArr_min(int arr_min) {
		this.arr_min = arr_min;
	}

	public int getDepart_hr() {
		return depart_hr;
	}

	public void setDepart_hr(int depart_hr) {
		this.depart_hr = depart_hr;
	}

	public int getDepart_min() {
		return depart_min;
	}

	public void setDepart_min(int depart_min) {
		this.depart_min = depart_min;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
