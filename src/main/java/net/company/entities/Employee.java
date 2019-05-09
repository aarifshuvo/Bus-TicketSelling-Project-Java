package main.java.net.company.entities;

import java.util.Scanner;

public class Employee {
	
	private int employeeId;
	private String name;
	private String userName;
	private String email;
	private String password;
	private String phoneNumber;
	private Scanner sc = new Scanner(System.in);

	public Employee()
	{
		this.name = "root";
		this.userName = "root";
		this.email = "root";
		this.password = "root";
	}
	
	public void setEmployee()
	{
		System.out.print("Enter Employee ID :: ");
		this.employeeId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Employee Name :: ");
		this.name = sc.nextLine();
		System.out.print("Enter Employee UserName :: ");
		this.userName = sc.nextLine();
		System.out.print("Enter Employee Email :: ");
		this.email = sc.nextLine();
		System.out.print("Enter Employee Password :: ");
		this.password = sc.nextLine();
		System.out.print("Enter Employee Phone Number :: ");
		this.phoneNumber = sc.nextLine();
	}
	
	public void setLoginInfo()
	{
		System.out.println("Enter your username :: ");
		this.userName = sc.nextLine();
		System.out.println("Enter Password :: ");
		this.password = sc.nextLine();
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
