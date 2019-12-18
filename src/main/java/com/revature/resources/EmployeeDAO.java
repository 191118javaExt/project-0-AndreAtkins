package com.revature.resources;

import java.util.HashMap;

import com.rev.users.Employee;
import com.rev.users.User;

public interface EmployeeDAO {

	public Employee findUserByUserName(String username);
	public boolean addEmployee(Employee emp);
	public boolean updateEmpBal(Employee emp);
	public HashMap<String,String> getEmpFromDataBaseMap();
	public HashMap<String,Employee> getUsersFromDataBaseEmpList();
	public boolean deleteEmployee(Employee emp);
	 
	
	
}
