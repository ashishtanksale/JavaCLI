package com.mysql.data;

import java.util.Scanner;

/**This is a main driver class which interacts with user 
 * and loads a CSV file from a user's choice of a database and a table  
 */
public class Driver {
	
	public static void main(String[] args) throws Exception {
	
		System.out.println("CSV Data load from MySQL.....");
		
		//Take operation no. from user 
		Scanner sc = new Scanner(System.in);
		String operation;
		String database;
		String table;
		
		//Perform specific task according to user input
		for (; ; ) {
			System.out.println("Enter 1 for Fetch operation and 0 for exiting the terminal");
			operation = sc.nextLine();
			
			//If user input is other than 0 or 1, notify user
			if (operation.equals("1")) {
				System.out.println("Enter the database name");
				database = sc.nextLine();	
				System.out.println("Enter the table name");
				table = sc.nextLine();
				System.out.println("Please wait......");
				new DataDumper(database, table);
				continue;
			}
			
			//If user input is 0, Terminate the program
			else if (operation.equals("0")) {
				System.out.println("Program terminated");
				sc.close();
				break;
			}
			
			//If user input is 1, ask user to enter database and table name
			else {
				
				System.out.println("Wrong input entered");
		    }
		
		}
	}
}
