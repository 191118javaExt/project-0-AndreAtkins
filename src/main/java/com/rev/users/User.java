package com.rev.users;

public class User {
	
	public String username;
	public String password;
	public int creditScore;
	public double balance;

	 
	
	
	public double getBalance(User obj) {
		
	double bal  =	obj.balance;
	
	    return bal;
		
	}
	
	public int getCredit(User obj) {
		
		int bal  =	obj.creditScore;
		
		    return bal;
			
		}



	public User(String unameselect, String passselect, int randomNumberInRange, double balanc) {
		 
		 this.username = unameselect;
		 this.password = passselect;
		 this.balance = balanc;
		 this.creditScore = randomNumberInRange;
	
	
	}
























	
    	
    	
    	
	
	
	
	
}

  