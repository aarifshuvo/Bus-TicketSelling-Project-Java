package main.java.net.company.entities;

import java.util.Scanner;

public class Passenger {
	private String name;
    private String age;
    private String phone;
    private Scanner sc = new Scanner(System.in);
    
    
    public void setPassenger()
    {
    	System.out.print("Enter Passenger's Name :: ");
    	this.name = sc.nextLine();
    	System.out.print("Enter Passenger's Age :: ");
    	this.age = sc.nextLine();
    	System.out.print("Enter Passenger's PhoneNumber :: ");
    	this.phone = sc.nextLine();
    }
    
    public void setName(String n)
    {
    	this.name = n;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public void setAge(String a)
    {
    	this.age = a;
    }
    
    public String getAge()
    {
    	return age;
    }
    
    public void setNumber(String p)
    {
    	this.phone = p;
    }
    
    public String getNumber()
    {
    	return phone;
    }
}
