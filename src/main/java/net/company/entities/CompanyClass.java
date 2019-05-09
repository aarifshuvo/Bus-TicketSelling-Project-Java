package main.java.net.company.entities;

import java.util.Scanner;

public class CompanyClass {

	private String companyName;
	private String companyTradeID;
	private Employee employee;
	
	
	public CompanyClass()
	{
		this.companyName = "Green Line Premium Bus Company";
	}
	
	public void setCompany()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Company Name :: ");
		this.companyName = sc.nextLine();
		System.out.print("Enter Company companyTradeID :: ");
		this.companyTradeID = sc.nextLine();
		
		employee.setEmployee();
		sc.close();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyTradeID() {
		return companyTradeID;
	}

	public void setCompanyTradeID(String companyTradeID) {
		this.companyTradeID = companyTradeID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
