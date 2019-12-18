package com.revature.resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rev.users.User;

public interface UserDAO {

	
	public User findUserByUserName(String username);
	public boolean addUser(User user);
	public boolean updateUserBal(User user);
	public HashMap<String,String> getUsersFromDataBaseMap();
	public HashMap<String,User> getUsersFromDataBaseUserList();
	public boolean deleteUser(User user);
	 
	
	//
}
