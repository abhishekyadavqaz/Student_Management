package main.Java.com.scg.studentDataBase.service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Java.com.scg.studentDataBase.UserInput;

public class StudentValidation {
	
	static  UserInput ui = new UserInput();
	
	public  String stringValidation(String input) throws IOException
	{
		
		while(true)
		 {
			 String regx = "^[a-zA-Z\\s]*$";
			 Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
			 Matcher matcher = pattern.matcher(input);
			    
		 if(matcher.find())
		 {
			 break;
		 }
		 System.out.println("invalid input -> it should contain only alphabet:");		   
		 input=ui.stringInput();
		 
		 }
		
		return input;
	}
	
	public  int intValidation(int userInput,int minimum,int maximum) throws StudentException
	{
		while(true)
		{		   
			 if(userInput<minimum||userInput>maximum)
			 {
				 
			  System.out.println(" input should be within "+minimum+" to "+ maximum +"  TRY AGAIN");
			  
			 }	 
			 else
			 {
				 break;
			 }
			 userInput =ui.integerInput(); 
		}
		
		return userInput;
	}

}
