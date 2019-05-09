package main.java.net.company.dao;

import java.sql.*;
import java.util.Scanner;

import main.java.net.company.entities.Employee;
import main.java.net.company.utils.ConnectionManager;

public class EmployeeDaoImp implements EmployeeDao {

	private final String INSERT_EMPLOYEE = "INSERT INTO employees_table (Employee_ID, Emp_Name, Emp_UserName, Emp_Email, Emp_Password, Emp_PhoneNumber) VALUES( ?,?,? , ?,?,?)";
	private final String SHOW_EMPLOYEES = "SELECT * from employees_table";
	private final String DELETE_EMPLOYEE = "DELETE from employees_table where Employee_ID = ?";
	private final String EMPLOYEE_LOGIN_VALIDATION = "select * from employees_table where Emp_UserName=? and Emp_Password=?";
	private Scanner sc = new Scanner(System.in);

	@Override
	public void addEmployee(){
		
		Employee employee = new Employee();
		employee.setEmployee();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
			
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getUserName());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getPhoneNumber());
			
			preparedStatement.executeUpdate();
			
			System.out.println("\n\n**Operation Succesful! Employee Added!**");
			
		}catch(Exception e)
		{
			System.out.println("\n**** Duplicate Entry! Invalid Employee ID!! ***");
			System.out.println("**** Try Again Plz!! *****");
			//e.printStackTrace();
		}
	}

	@Override
	public void showEmployees() {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		connection = ConnectionManager.getConnection();
		
		try {
			
			preparedStatement = connection.prepareStatement(SHOW_EMPLOYEES);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("Available Employees List :: ");
			
			while(resultSet.next())
			{
				System.out.println("\nEmployee ID       :: " + resultSet.getInt(1) +
								   "\nEmployee Name     :: " + resultSet.getString(2) +
								   "\nEmployee UserName :: " + resultSet.getString(3) +
								   "\nEmployee Email    :: " + resultSet.getString(4) +
								   "\nEmployee Password :: " + resultSet.getString(5) +
								   "\nEmployee Phone    :: " + resultSet.getString(6)
						);
				System.out.println("\n*************************************\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteEmployeeByID() {
		
		System.out.println("Enter Employee ID to Delete employee Information ::");
		int eid = sc.nextInt();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			
			preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
			preparedStatement.setInt(1, eid);
			
			int rows = preparedStatement.executeUpdate();
			
			if(rows==0)
			{
				System.out.println("Invalid EmployeeID! Operation Failed! No such ID found!");
			}
			else 
			{
				System.out.println("\n\n**Operation Succesful! Employee Deleted!**");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean employeeLogin() {
		
		Employee employee = new Employee();
		employee.setLoginInfo();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(EMPLOYEE_LOGIN_VALIDATION);

			preparedStatement.setString(1, employee.getUserName());
			preparedStatement.setString(2, employee.getPassword());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				System.out.println("\nLogin Successful!!\n");
				return true;
			}
			else 
			{
				System.out.println("\nError!!! Invalid Login Information!\n\n");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}


}
