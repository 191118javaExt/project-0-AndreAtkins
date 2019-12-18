package com.revature.services;

import java.util.HashMap;

import com.rev.users.Employee;
import com.rev.users.User;
import com.revature.resources.EmployeeDAO;
import com.revature.resources.EmployeeDAOImp;
import com.revature.resources.UserDAO;
import com.revature.resources.UserDAOImp;

public class EmployeeServices {

	EmployeeDAO  employeerepo = new EmployeeDAOImp();

	
    public boolean addEmployee(Employee emp) {
		return employeerepo.addEmployee(emp);
	}
	
    public boolean updateEmpBal(Employee emp) {
		return employeerepo.updateEmpBal(emp);
    		
    }
    
     public HashMap<String, String> getEmpFromDataBaseMap() {

    	 return employeerepo.getEmpFromDataBaseMap();
    	 
    	 
     }

     public HashMap<String, Employee> getUsersFromDataBaseEmpList(){
		
    	return employeerepo.getUsersFromDataBaseEmpList();
      }

     public boolean deleteEmployee(Employee emp) {
    	 return employeerepo.deleteEmployee(emp);
    	 
     }







}
