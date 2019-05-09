package main.java.net.company.services;

import java.util.Scanner;

import main.java.net.company.dao.BusDaoImp;
import main.java.net.company.dao.BusSeatDaoImp;
import main.java.net.company.dao.EmployeeDaoImp;
import main.java.net.company.entities.CompanyClass;
import main.java.net.company.utils.UserInterface;

public class CompanyServiceImp implements CompanyService {
	
	private Scanner sc = new Scanner(System.in);
	private boolean type , flag = false;
	private int loginTryCount = 0;

	public void run()
	{
		CompanyClass companyClass = new CompanyClass();
		
		System.out.println("Welcome to " + companyClass.getCompanyName() + "!\n\n");
		
	
		int cc = 0;
		
		while(cc!=3)
		{
			UserInterface.rootMenu();
			cc = sc.nextInt();
			BusDaoImp busDaoImp = new BusDaoImp();
			BusSeatDaoImp busSeatDaoImp =  new BusSeatDaoImp();
			EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
			
			if(cc==1) System.out.println("\n\nHello Admin! Welcome To Manager Panel!!\n");
			else if(cc==2) System.out.println("\n\nHello User! Welcome!!\n");
			
			while(true)
			{
				if(cc==1)
				{
						type = UserInterface.promptForMasterPass();
						
						if(type==false) break;
					
						UserInterface.adminOptions();
						
						int choice = sc.nextInt();
	
						if(choice==1)
						{
							busDaoImp.addBus();
						}
						else if(choice==2)
						{
							busDaoImp.showBuses();
						}
						else if(choice==3)
						{
							busDaoImp.deleteBusbyCoachNumber();;
						}
						else if(choice==4)
						{
							employeeDaoImp.addEmployee();
						}
						else if(choice==5)
						{
							employeeDaoImp.showEmployees();
						}
						else if(choice==6)
						{
							employeeDaoImp.deleteEmployeeByID();
						}
						else
						{
							System.out.println("**Admin Options Exited!**\n\n");
							break;
						}
				}
				
				else if(cc==2)
				{
					if(flag==false){
						type = employeeDaoImp.employeeLogin();
					}
					
					if(type==true)
					{
						flag = true;
						
						UserInterface.userOptions();
						
						int choice;
						choice = sc.nextInt();
						
						if(choice==1)
						{
							busDaoImp.showBuses();
						}
						else if(choice==2)
						{
							busSeatDaoImp.showSeatsByCoachNumber();
						}
						else if(choice==3)
						{
							busSeatDaoImp.reserveSeatofCoachNumber();
						}
						else if(choice==4)
						{
							busSeatDaoImp.cancelTicketBySeatNo();
						}
						else 
						{
							loginTryCount = 0;
							flag = false;
							System.out.println("\nUser Options Logged Out!\n");
							break;
						}
					}
					else 
					{
						loginTryCount++;
						if(loginTryCount>=3)
						{
							System.out.println("**Number of Invalid Login Reached! Login Form Removed!**\n\n");
							loginTryCount = 0;
							flag = false;
							break;
						}
					}
				}
				else if(cc==3)
				{
					System.out.println("\nProgram Exited!\nThanks for being with us!");
					break;
				}
			}
		}
		
	}
}
