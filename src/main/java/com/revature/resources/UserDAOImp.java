package com.revature.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rev.menus.Menu;
import com.rev.users.Employee;
import com.rev.users.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImp implements UserDAO {
    
	
	
	@Override
	public User findUserByUserName(String username) {
	
		
		
		return null;
	}

	@Override
	public boolean addUser(User user) {		

try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			// We use ?'s as placeholders, which we can insert values from Java using
			// PreparedStatements
			String sql = "INSERT INTO \"Project0\".users (username, pass, creditscore, balance) " +
					"VALUES (?, ?, ?, ?);";
			
			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the placeholders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.username);
			stmt.setString(2, user.password);
			stmt.setInt(3, user.creditScore);
			stmt.setDouble(4, user.balance);
			//Employee sup = user.getSupervisor();
			stmt.execute();
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			System.out.println("Unable to retrieve all users " + ex.getMessage());
			return false;
		}
		
		return true;	
	
	}

	@Override
	public boolean updateUserBal(User user) {
try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			// We use ?'s as placeholders, which we can insert values from Java using
			// PreparedStatements
			String sql = "UPDATE \"Project0\".users " + "SET balance = ? WHERE username = ?";
				
			
			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the placeholders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, user.balance);
			stmt.setString(2, user.username);
		
			
			stmt.execute();
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			System.out.println("Unable to update balance " + ex.getMessage());
			return false;
		}
		
		return false;
	}

	@Override
	public HashMap<String,String> getUsersFromDataBaseMap() {
		
		
		HashMap<String, String> membermap =  new HashMap< String,String>(); 
			
			
			try (Connection conn = ConnectionUtil.getConnection()) {
				
				// This String represents the SQL which we will execute on our database
				String sql = "SELECT * FROM \"Project0\" .users;";
				
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
	
					
                    User user1 = new User(username, password, creditScore, balance);
					
					user1.balance = balance;
					user1.creditScore = creditScore;
					user1.password = password;
					user1.username = username;
					membermap.put(username, password);
		
					
					
					
	
	
				}
				
				rs.close();
			} catch(SQLException e) {
				System.out.println("Unable to retrieve all users" + e.getMessage());
				
			}
	
		return membermap;
	}

	@Override
	public HashMap<String, User> getUsersFromDataBaseUserList() {
		   
		  HashMap<String, User> namemap =  new HashMap<String, User>(); 
		
		  try (Connection conn = ConnectionUtil.getConnection()) {
	
			String sql = "SELECT * FROM \"Project0\" .users;";
	
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				
				String username = rs.getString("username");
				String password = rs.getString("pass");
				int creditScore = rs.getInt("creditscore");
				double balance= rs.getDouble("balance");

				
                User user1 = new User(username, password, creditScore, balance);
				
                
				user1.balance = balance;
				user1.creditScore = creditScore;
				user1.password = password;
				user1.username = username;
				namemap.put(username, user1);
	
			
			}
			
			rs.close();
		} catch(SQLException e) {
			System.out.println("Unable to retrieve all users" + e.getMessage());
			
		}

	return namemap;
		

	
	}

	@Override
	public boolean deleteUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			// We use ?'s as placeholders, which we can insert values from Java using
			// PreparedStatements
			String sql = "DELETE FROM \"Project0\".users WHERE \"Project0\".users.username = (?)";
			
			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the placeholders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.username);
	
			stmt.execute();
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			System.out.println("Unable to retrieve all users " + ex.getMessage());
			return false;
		}
		
		return true;	
		
	}


}
