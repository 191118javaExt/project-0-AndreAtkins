package com.revature.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rev.users.User;
import com.revature.resources.UserDAO;
import com.revature.resources.UserDAOImp;

public class UserServices {
	
	UserDAO  userrepo = new UserDAOImp();
	
	
	
    public boolean addUser(User user) {
		return userrepo.addUser(user);
	}
	
    public boolean updateUserBal(User user) {
		return userrepo.updateUserBal(user);
    		
    }
    
     public HashMap<String, String> getUsersFromDataBaseMap() {

    	 return userrepo.getUsersFromDataBaseMap();
    	 
    	 
     }

     public HashMap<String, User> getUsersFromDataBaseUserList(){
		
    	return userrepo.getUsersFromDataBaseUserList();
    	
      }
     public boolean deleteUser(User user) {
    	 
    	 
    	 return userrepo.deleteUser(user);
     }
     
     
     
     
}