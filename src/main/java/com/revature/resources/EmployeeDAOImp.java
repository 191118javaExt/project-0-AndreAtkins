package com.revature.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.rev.users.Employee;
import com.rev.users.User;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImp implements EmployeeDAO{

	@Override
	public Employee findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		
try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			// We use ?'s as placeholders, which we can insert values from Java using
			// PreparedStatements
			String sql = "INSERT INTO \"Project0\".employee (username, pass, creditscore, balance) " +
					"VALUES (?, ?, ?, ?);";
			
			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the placeholders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.username);
			stmt.setString(2, emp.password);
			stmt.setInt(3, emp.creditScore);
			stmt.setDouble(4, emp.balance);
			//Employee sup = user.getSupervisor();
			stmt.execute();
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			System.out.println("Unable to retrieve all employees " + ex.getMessage());
			return false;
		}
		
		return true;	
		

		
	}

	@Override
	public boolean updateEmpBal(Employee emp) {
	
    try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			// We use ?'s as placeholders, which we can insert values from Java using
			// PreparedStatements
			String sql = "UPDATE \"Project0\".employee " + "SET balance = ? WHERE username = ?";
				
			
			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the placeholders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, emp.balance);
			stmt.setString(2, emp.username);
		
			
			stmt.execute();
		} catch(SQLException ex) {
			
			System.out.println("Unable to update balance " + ex.getMessage());
			return false;
		}
		
		return false;
		
		
	}

	@Override
	public HashMap<String, String> getEmpFromDataBaseMap() {
	
		
		

		HashMap<String, String> membermap =  new HashMap< String,String>(); 
			
			
			try (Connection conn = ConnectionUtil.getConnection()) {
				
				// This String represents the SQL which we will execute on our database
				String sql = "SELECT * FROM \"Project0\" .employee;";
				
				// This Statement object is a wrapper around our SQL string
				// And is obtained through our connection to the database
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				// ResultSets start 1 position behind the starting point
				// So, in order to access the first value, we invoke next to start
				// This is a small difference, the only thing is that it simplifies
				// our syntax. Since we can use a while loop instead of a do-while loop
				while(rs.next()) {
					String username = rs.getString("username");
					String password = rs.getString("pass");
					int creditScore = rs.getInt("creditscore");
					double balance= rs.getDouble("balance");
	
					
                    Employee emp = new Employee(username, password, creditScore, balance);
					
				    emp.balance = balance;
					emp.creditScore = creditScore;
					emp.password = password;
					emp.username = username;
					membermap.put(username, password);

				}
				
				rs.close();
			} catch(SQLException e) {
				System.out.println("Unable to retrieve all users" + e.getMessage());
				
			}
	
		return membermap;
	}

	@Override
	public HashMap<String, Employee> getUsersFromDataBaseEmpList() {
	
		  HashMap<String, Employee> namemap =  new HashMap<String, Employee>(); 
			
		  try (Connection conn = ConnectionUtil.getConnection()) {
	
			String sql = "SELECT * FROM \"Project0\" .employee;";
	
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				
				String username = rs.getString("username");
				String password = rs.getString("pass");
				int creditScore = rs.getInt("creditscore");
				double balance= rs.getDouble("balance");

				
              Employee emp = new Employee(username, password, creditScore, balance);
				   
				emp.balance = balance;
				emp.creditScore = creditScore;
				emp.password = password;
				emp.username = username;
				
				namemap.put(username, emp);
	

			}
			
			rs.close();
		} catch(SQLException e) {
			System.out.println("Unable to retrieve all users" + e.getMessage());
			
		}

	return namemap;
		
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
     try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			// We use ?'s as placeholders, which we can insert values from Java using
			// PreparedStatements
			String sql = "DELETE FROM \"Project0\".employee WHERE \"Project0\".employee.username = (?)";
			
			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the placeholders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.username);
			
		
			stmt.execute();
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			System.out.println("Unable to retrieve all users " + ex.getMessage());
			return false;
		}
		
		return true;	
		
	}
	
	

}
