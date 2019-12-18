package com.rev.menus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rev.users.Employee;
import com.rev.users.User;
import com.revature.services.EmployeeServices;
import com.revature.services.UserServices;


public class Menu {
  boolean exit = false;
  boolean exit2 = false;
  boolean exit3 = false;
  
  UserServices us = new UserServices();
  EmployeeServices es = new EmployeeServices();
  public HashMap< String,String> membermap =  us.getUsersFromDataBaseMap(); 
  public HashMap< String,String> membermap2 =  es.getEmpFromDataBaseMap(); 
  public HashMap< String,User> namemap = us.getUsersFromDataBaseUserList(); 
  public HashSet<User> userset= new HashSet<User>();
  HashSet<Employee> employeeset=new HashSet<Employee>();
  HashMap< String,Employee> bossmap =  es.getUsersFromDataBaseEmpList();
  HashMap< String,Employee> adminmap =  new HashMap< String,Employee>();	
  Employee admin = new Employee("andre", "admin123", 800, 1000000);
  private static Logger logger = Logger.getLogger(Menu.class);
  
  
  //UserServices us2 = new UserServices();
 
  
  
	public static void main(String[] args) {
	
		
		
		start();
			
	}
	
	
	public static void start() {
		
				
		
		Menu menu1 = new Menu();
		menu1.runmenu();
			
		
	}
	
		
	public void runmenu() {

		
		
		
		adminmap.put("andre",admin);
		membermap2.put("andre", "admin123");
		//es.addEmployee(admin);
		
		printHeader();
		
		while(!exit) {
			
			printMenu();
			
			int selection = getSelection(3);
			performActionMain(selection);
			
			
						
		}
			
     }
	
	public void printHeader() {	
		
		
		System.out.println("      _._._                       _._._\n" + 
				"        _|   |_                     _|   |_\n" + 
				"        | ... |_._._._._._._._._._._| ... |\n" + 
				"        | ||| |  o ANDRE'S BANK  o  | ||| |\n" + 
				"        | \"\"\" |  \"\"\"    \"\"\"    \"\"\"  | \"\"\" |\n" + 
				"   ())  |[-|-]| [-|-]  [-|-]  [-|-] |[-|-]|  ())\n" + 
				"  (())) |     |---------------------|     | (()))\n" + 
				" (())())| \"\"\" |  \"\"\"    \"\"\"    \"\"\"  | \"\"\" |(())())\n" + 
				" (()))()|[-|-]|  :::   .-\"-.   :::  |[-|-]|(()))()\n" + 
				" ()))(()|     | |~|~|  |_|_|  |~|~| |     |()))(()\n" + 
				"    ||  |_____|_|_|_|__|_|_|__|_|_|_|_____|  ||\n" + 
				" ~ ~^^ @@@@@@@@@@@@@@/=======\\@@@@@@@@@@@@@@ ^^~ ~");
		System.out.println("\n");
		System.out.println("----------------------------");
		System.out.println("| Welcome to Andre's Bank! |");
		System.out.println("----------------------------");
		System.out.println("\n");
	
			 
	}
	public void printMenu() {	
		
		System.out.println("1. |Register|");
		System.out.println("---------------");
		System.out.println("2. |Login|");
		System.out.println("---------------");
		System.out.println("3. |Exit|");
		System.out.println("---------------");
		System.out.println("Select an option 1 - 3");
		
			 
	}
	
	public int getSelection(int choices) {	
		
		Scanner scan = new Scanner(System.in);
		int selection = -1;
		while(selection < 0 || selection > choices) {
			try {
			    selection = Integer.parseInt(scan.nextLine());
				
			} catch(NumberFormatException e ) {
				
			  System.out.println("Please select an appropiate menu option");
			}			
			
			
		}
		return selection;				
	}
	
	
    public void performActionMain(int selection) {
    	
      switch(selection) {
    
      case 1:
    	
    	  createAccount();
    	  
    	  break;
      case 2:
    
    	  ValidateLog();
    	  break;
      case 3:
    	  exit = true;
    	  System.out.println("Thanks for banking with us!");
    	  
      }	
    }
    
     public void createAccount() {		
    	
    	
    	System.out.println("\n"); 
    	System.out.println("Create a username"); 
    	System.out.println("\n");
    	Scanner scan = new Scanner(System.in);    	
		String unameselect = scan.nextLine();
		boolean b =  membermap.containsKey(unameselect) || membermap2.containsKey(unameselect);  //true if unavailable username, false if available
		
		if(b == false) {
		
		System.out.println("\n");
		System.out.println("Create a password");
		System.out.println("\n");
		String passselect = scan.nextLine();
		
		
		System.out.println(unameselect + " " + passselect);	
		
		int credScore = getRandomNumberInRange(300,850);
		
		System.out.println("\n");
		System.out.println("Please wait our team is running a credit check...");
		
		if(credScore< 450) {
			System.out.println("\n");
			System.out.println("Sorry, :(" + " " + unameselect + "\n you've been denied. A credit score of " + credScore + " is too low.");
					
			
		}
		
		else {
		 
		  if(credScore >= 420 && credScore < 600)	{
		
	    User user1 = new User(unameselect, passselect, credScore,0.00);
	    
	    us.addUser(user1);
	    
	    membermap.put(unameselect, passselect);	
		
		namemap.put(unameselect, user1);
		
		userset.add(user1);
		
		
		
		
		
		System.out.println(" Congrats! " + unameselect + "\n With a credit score of " + credScore  + " you have been appoved!");
		
		Login(user1);
		  
		  }else {
			  
			  System.out.println(" WoW! :O Your credit is excellent do you want to become an employee?");
			  
			  System.out.println("1. YES");
			  System.out.println("2. NO");
			  
			  
			  Scanner scann = new Scanner(System.in);
			  
			  
			  String select = scann.nextLine();
			  
			  
			  if(select.equals("1") || select.equals("2")) {
			  
			  
			  switch(select) {
			  
			  case "1":
				  
				  
				  Employee employee1 = new Employee(unameselect, passselect, credScore,0.00); 
				  
				  es.addEmployee(employee1);
				  
				  System.out.println("Congrats! You're hired, welcome to the team! :)");
				  
				  System.out.println("You may now view all acounts");
				  
				  LoginEmployee(employee1);
				  
				  membermap.put(unameselect, passselect);
				  
				  membermap2.put(unameselect, passselect);
				  
				  employeeset.add(employee1);
				  
				  bossmap.put(unameselect, employee1);  
				  
				  break;
				  
			  case "2":	  
				  
				  User user1 = new User(unameselect, passselect, credScore,0.00);
				  
				  us.addUser(user1);
				    
				  System.out.println("That's fine, you have been approved for an account :)");
				  
				  membermap.put(unameselect, passselect);	
					
			      namemap.put(unameselect, user1);
					
				  userset.add(user1);
				  
				  Login(user1);				  
			  }
			 
			  
			  }else {
				  
				  System.out.println("Please register again and enter a valid option");
				  
			  }
		  
			  
		  }
		}
		 
			
		}
		else {
			System.out.println("\n");
			System.out.println("Username is not available please register again with a different username");
		}
		
	}
    


	public void ValidateLog() {
    	
    	System.out.println("Enter your username"); 
     	Scanner scan = new Scanner(System.in);    	
 		String unamelog = scan.nextLine();	
 		boolean d = membermap.containsKey(unamelog) || membermap2.containsKey(unamelog);
 		if(!d)
 		{
 		System.out.println("Username does not exist");
 			
 		}else {
 		
 		System.out.println("Enter your password"); 
 		String passlog = scan.nextLine();
 		 
 		boolean b = passlog.equals(membermap.get(unamelog)) || passlog.equals(membermap2.get(unamelog));
 		boolean c = bossmap.containsKey(unamelog);
 		
 		if(unamelog.equals("andre") && passlog.equals("admin123")) {
 			
 	        
 			loginAdmin(adminmap.get(unamelog));
 			
 			
 			
 		}else
 		
 		
 		
 		if(!b) {
 			
 			System.out.println("password is invalid please try again");
 		}
 			
 		if(b && c) {
 		
 		LoginEmployee(bossmap.get(unamelog));
 			
 		} 
 				    
 		 if(b && !c) {
 			  			   			   
 		   Login(namemap.get(unamelog)); 
 		  }
 			
 		   
 		}
 		
	  	    	
    }	 
    
     public void loginUserMenu() {
 		
    	System.out.println("======================"); 
    	System.out.println("\n");
    	System.out.println("1. |Deposit|");
    	System.out.println("   ---------------");
    	System.out.println("2. |Withdraw|");
    	System.out.println("   ---------------");
    	System.out.println("3. |Transfer|");
    	System.out.println("   ---------------");
 	    System.out.println("4. |Check Balance|");
 	    System.out.println("   ---------------");
 	    System.out.println("5. |Exit|");
 	    System.out.println("\n");
 	    System.out.println("======================");
 	    
 	}
   
    
    public void withdraw(User user1, double amount){
          
    	 
    if(user1.balance > amount) {	 
    
    
    double balance = getBalance(user1) - amount;

     user1.balance = balance; 
     
     us.updateUserBal(user1);
     System.out.println("\n");

     System.out.println("Your new balance is " + balance);
     
     logger.info(amount + "has been withdrawn");
    }
     else {
    	
     System.out.println("Insuficcient Funds");
     
    
     
     
     
     
    	
    }

} 
     
     public boolean deposit(User user1, double amount){
    	                                             //accept user object and amount increases objects balance returns true if balance is updated
    	double obalance = user1.balance;
    	
    	double balance = getBalance(user1) + amount;
		
    	user1.balance = balance; 
    	
    	us.updateUserBal(user1);
    	
    	System.out.println("\n");
    	System.out.println("Your new balance is " + balance); 
        logger.info(amount + " has been deposited");
    	
    	if(obalance != balance) {
    		return true;
    	}else {
    		return false;
    		
    	}
     }
     
     
     public void transferMoney(User giver, User reciever, double amount) {

         if(giver.balance > amount) {
    	 
    	 
    	 double balance = getBalance(giver) - amount;
          
          giver.balance = balance;
          
          double balance2 = getBalance(reciever) + amount;
          
          reciever.balance = balance2;
          
          us.updateUserBal(giver);
          
          us.updateUserBal(reciever);
          
          logger.info(amount + "has been transferred");
         }else {
        	 System.out.println("\n");
        	 System.out.println("You dont have enough funds to transfer");
         }
     }
     
     
     public void transferMenu(User user) {
    	 
    	System.out.println("Enter the username that you want to transfer money to"); 
    	
    	Scanner scan = new Scanner(System.in);
    	
    	String unametransfer = scan.nextLine();
    	
    	if(namemap.containsKey(unametransfer)) {
    		
    	User user2 = namemap.get(unametransfer);
    		
    	System.out.println("How much would you like to transfer?");
    	
    	Scanner scan2 = new Scanner(System.in);
    	
    	double amount = Double.parseDouble(scan2.nextLine());
    	
    	
    		transferMoney(user, user2, amount);
    	}
    	
    	  
     }
     
     
     
     
     public void checkBalance(User user1) {
    	 us.updateUserBal(user1);
    	 
    	 
    	 System.out.println("\n");
    	 System.out.println("Your current balance is " + user1.balance);
    	
    	 
     }
     
     
     //private void getBalance(User user1) {

    		public double getBalance(User obj) {
    			
    		double bal  =	obj.balance;
    		
    		    return bal;
    			
    		
		
	}

	public void performActionLogin(int selection, User obj) {
    	 
    	 switch(selection) {
    	    
         case 1:
         System.out.println("\n");
       	 System.out.println("Enter an amount to deposit");
         
     
       	  deposit(obj, getAmountFromUser());
  
       	  //System.out.println("depo");
       	  break;
          case 2:  
          System.out.println("\n");
          System.out.println("Enter an amount to withdraw");
          
          withdraw(obj, getAmountFromUser());
          
          //System.out.println("withd");
       	  break;
          case 3:
       	  
       	  transferMenu(obj);
       	   
       	  break;
       	  
         case 4:
          
         System.out.println("\n");	 
         System.out.println("your new balance is " + obj.balance); 
        
          break;
          
         case 5:
         System.out.println("\n");
         System.out.println("Thanks for banking with us!");
         
         
         exit2 = true;
        	 
       	  
         }	 
     } 	 
    	 public void Login(User obj) {
			
    		do {
		
    		loginUserMenu();
    				
    		int selection = getSelection(5);
    		performActionLogin(selection, obj);
    		 
    		}while(!exit2);
        }
    
    	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
    	throw new IllegalArgumentException("max must be greater than min");
  		}
  			Random r = new Random();
    		return r.nextInt((max - min) + 1) + min;
    		} 
     
    
     
     public double getAmountFromUser() {
    	
    	Scanner scan = new Scanner(System.in);	 
         	 
		double amountinput;
			
		amountinput = Double.parseDouble(scan.nextLine());        		
			
			
		System.out.println("Please select an appropiate menu option");
					
		
		return amountinput; 
    	 
     }
     
     
     public void checkInfoByUsername() {
    	 
    	System.out.println("Enter again to confirm"); 
    	 
    	Scanner scan = new Scanner(System.in);	
    	
    	String userr = scan.nextLine();
    	
    	if(namemap.containsKey(userr)) {
    		
        	User user2 = namemap.get(userr);
        	
        	System.out.println("username: " + user2.username);
        	System.out.println("\n");
        	System.out.println("password: " + user2.password);
        	System.out.println("\n");
        	System.out.println("balance: " + user2.balance);
        	System.out.println("\n");
        	System.out.println("Credit Score: " + user2.creditScore);
    	}
    	 
     }
     
     public void LoginEmployee(Employee obj) {
			
 		do {
		
 		loginUserMenuEmp();
 				
 		int selection = getSelection(6);
 		performActionEmpLogin(selection, obj);
 		 
 		}while(!exit2);
     }
     
     
     public void loginUserMenuEmp() {
  		System.out.println("==============================");
  		System.out.println("\n");
     	System.out.println("1. |Deposit|");
    	System.out.println("--------------------------");
     	System.out.println("2. |Withdraw|");
     	System.out.println("--------------------------");
     	System.out.println("3. |Transfer|");
     	System.out.println("--------------------------");
  	    System.out.println("4. |Check Balance|");
  	    System.out.println("--------------------------");
  	    System.out.println("5. |View Accounts & Info|");
  	    System.out.println("--------------------------");
  	    System.out.println("6. |Exit|");
  	    System.out.println("\n");
  		System.out.println("==============================");
  	}
    
public void performActionEmpLogin(int selection, Employee obj) {
    	 
    	 switch(selection) {
    	    
         case 1:
       	 System.out.println("Enter an amount to deposit");
         
     
       	  depositEmp(obj, getAmountFromUser());
  
       
       	  break;
          case 2:      	 
          System.out.println("Enter an amount to withdraw");
          
          withdrawEmp(obj, getAmountFromUser());
          
        
       	  break;
          case 3:
       	  
       	  transferMenuEmployee(obj);
       	   
       	  break;
       	  
          case 4:
              	 
         System.out.println("your new balance is " + obj.balance); 
        
         break;
          
         case 5:
         
      	 checkInfoByUsername();
         
         break;
         
         case 6:
         System.out.println("Thanks for banking with us!");
         exit2 = true;   	 
       	  
         }	 
     } 	 
  
    public void depositEmp(Employee user1, double amount){
   
    double balance = user1.balance + amount;

    user1.balance = balance; 
    
    es.updateEmpBal(user1);
    
    //logger.info(amount + "has been deposited");

    System.out.println("Your new balance is " + balance); 	
    
}
   
    
    
    public void withdrawEmp(Employee user1, double amount){
          
    	 
    if(user1.balance > amount) {	 
    
    
    double balance = user1.balance - amount;

     user1.balance = balance; 	

     es.updateEmpBal(user1);
     
 	 System.out.println("\n");
     System.out.println("Your new balance is " + balance);
     
     logger.info(amount + "has been withdrawn");
    }
     else {
     System.out.println("\n");	
     System.out.println("Insuficcient Funds");
    	
    }

}   


  public void transferMenuEmployee(Employee user) {
	 

	System.out.println("Enter the username that you want to transfer money to"); 
	
	Scanner scan = new Scanner(System.in);
	
	String unametransfer = scan.nextLine();
		
	boolean b = bossmap.containsKey(unametransfer);
	
	boolean a = namemap.containsKey(unametransfer);
	
	System.out.println("How much would you like to transfer?");

	Scanner scan2 = new Scanner(System.in);
	
	double amount = Double.parseDouble(scan2.nextLine());	
	
	if(a) {
		
		User user2 = namemap.get(unametransfer);
	
	transferMoneyEmployeeToUser(user, user2, amount);
	}
	
	if(b) {

		Employee emp1 = bossmap.get(unametransfer);
		
		transferMoneyEmpToEmp(user, emp1, amount);
	}	
		
	if(a == false && b == false) {
	System.out.println("\n");	
	System.out.println("No account found for this user");	
	
	}

		
	
  }
	 public void transferMoneyEmployeeToUser (Employee giver, User reciever, double amount) {

         
		 if(giver.balance> amount) {
		 
		 double balance = giver.balance - amount;
         
         giver.balance = balance;
         
         double balance2 = getBalance(reciever) + amount;
         
         reciever.balance = balance2;
         
         us.updateUserBal(reciever);
         
         es.updateEmpBal(giver);
         
         //logger.info(amount + "has been transferred");
         
         
		 }else {
			 System.out.println("\n");
			 System.out.println("You dont have enough $$$ to transfer :(");
		 }
    }
	 
	 
	 public void transferMoneyEmpToEmp(Employee giver, Employee reciever, double amount) {

        if(giver.balance > amount) {

		 double balance = giver.balance - amount;
         
         giver.balance = balance;
         
         double balance2 = reciever.balance + amount;
         
         reciever.balance = balance2;
         
         es.updateEmpBal(giver);
         
         es.updateEmpBal(reciever);
         

         logger.info(amount + "has been transferred");
         
         
         
        }else {
        	
        	System.out.println("You dont have enough funds to transfer");
        }
    }
	 
	    
	 public void performActionAdminLogin(int selection, Employee obj) {
	     	 
	     	 switch(selection) {
	     	    
	          case 1:
	        	System.out.println("Enter a username to view account info");
	        	Scanner scan1 = new Scanner(System.in);
	        	String usernamev = scan1.nextLine();
	        	adminViewAccounts(usernamev);
	        
	        	  break;
	           case 2:      	 
	           
	           //System.out.println("ll");
	           System.out.println("Enter a username to edit their account info");
	           Scanner scan2 = new Scanner(System.in);
	           String usernamee = scan2.nextLine();
	           if(bossmap.containsKey(usernamee)) {
	        	   
	        	   
	        	   LoginEmployee(bossmap.get(usernamee));
	        	   
	           }else {
	           
	           
	             if(membermap.containsKey(usernamee)) {
	        	     Login(namemap.get(usernamee));
	        	  }else {
	        		  System.out.println("No such user exist double check your spelling.");
	        	  }
	           }
	         
	        	  break;
	           case 3:
	        	    
	        	 
	        	  System.out.println("Enter a user or employee that you would like to delete.");
	        	  Scanner scan = new Scanner(System.in);
	        	  String input = scan.nextLine();
	        	
	        	  if(membermap.containsKey(input)|| membermap2.containsKey(input)) {  
	        	  
	        	  
	        	    if(membermap2.containsKey(input)) {
	        	    	
	        		  es.deleteEmployee(bossmap.get(input));
                      System.out.println("POOF!" + input +" " + "has been deleted from our records and is no longer active");
	        		  
	        	    }else {
	        		  
	        	    	us.deleteUser(namemap.get(input));
	        	    	System.out.println("POOF! " + input + " " + "has been deleted from our records and is no longer active");
	        	    }
	        		  
	        	}else {
	        		
	        		System.out.println("According to our records, there is no such user.");
	        	}
	        	   
	        	   
	        	  break;
	        	  
	          case 4:
	               	 
	          
	        	  start();
	        	 
	        	  
	          }	 
	      } 	 
	   
	 
	 public void printAdminLoginMenu() {
		 
		 System.out.println("Welcome Admin!");
		 System.out.println("\n");
		 System.out.println("1. View any Account");
		 System.out.println("\n");
		 System.out.println("2. Edit Any Account");
		 System.out.println("\n");
		 System.out.println("3. Delete User");
		 System.out.println("\n");
		 System.out.println("4. Exit");
		 System.out.println("\n");
		 System.out.println("Select an option 1 - 4"); 
	 }
	 
	 
	 public void checkInfoByEmpUsername() {
    	 
	    	System.out.println("please re enter an employee username that you want info for"); 
	    	 
	    	Scanner scan = new Scanner(System.in);	
	    	
	    	String userr = scan.nextLine();
	    	
	    	if(bossmap.containsKey(userr)) {
	    		
	        	Employee emp = bossmap.get(userr);
	        	
	        	System.out.println("username: " + emp.username);
	        	System.out.println("\n");
	        	System.out.println("password: " + emp.password);
	        	System.out.println("\n");
	        	System.out.println("balance: " + emp.balance);
	        	System.out.println("\n");
	        	System.out.println("Credit Score: " + emp.creditScore);
	    	}
	    	 
	     }
	 
	public void adminViewAccounts(String username) {

		boolean b =  membermap.containsKey(username);
		boolean c =  bossmap.containsKey(username);
		
		if(b) {
		
			checkInfoByUsername();
		}
	
		if(c) {

			checkInfoByEmpUsername();
		}
			
		if(!b && !c ) {
			
			System.out.println("There is no such user");
		}
		
		}
		
	 
		public void loginAdmin(Employee admin) {

			do {
			
			printAdminLoginMenu();
		    
			int selection = getSelection(4);
			
			performActionAdminLogin(selection, admin);
		
			}while(!exit3);
		
	}	 
}


