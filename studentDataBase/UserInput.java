package main.Java.com.scg.studentDataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Java.com.scg.studentDataBase.service.StudentException;

public class UserInput {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	  public String stringInput() throws IOException
	  {
		  String st= br.readLine();
		  
		  return st;
	  }
	  
	  
	  public int  integerInput() throws StudentException 
	  {
		  int input=-1;
		 
		  
		  while(true)
		  {
		  try
		  {
		   input= Integer.parseInt(br.readLine());
		   break;
		  }
		  catch(Exception e)
		  {
			  System.out.println("invalid input -> it should contain only number");
		  }
		  
		  
		  }
		  
		  return input;
	  }

	}
