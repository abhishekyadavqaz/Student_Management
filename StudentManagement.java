package main.Java.com.scg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import main.Java.com.scg.studentDataBase.UserInput;
import main.Java.com.scg.studentDataBase.service.StudentService;
import main.Java.com.scg.studentDataBase.service.StudentServiceImplementation;
import main.Java.com.scg.studentDataBase.service.StudentValidation;
import main.Java.com.scg.studentDataBase.vo.Student;

public class StudentManagement {
	
	 public static void main(String[] args) throws IOException, SQLException{
		 
		 System.out.println("Welcome to Student Management App");
		 System.out.println();
		 
		 StudentService imp = new StudentServiceImplementation();
		 
		 StudentValidation sv= new  StudentValidation();
		 
		 UserInput ui = new UserInput();
		 
		 while(true)
		 {
			 System.out.println("     PRESS 1 to ADD student");
			 System.out.println("     PRESS 2 to DELETE student");
			 System.out.println("     PRESS 3 to DISPLAY student");
			 System.out.println("     PRESS 4 to Update student");
			 System.out.println("     PRESS 5 to To display set of student");
			 System.out.println("     PRESS 6 to Search student by id");
			 System.out.println("     PRESS 7 to Search student by name");
			 System.out.println("     PRESS 8 to Search student by Key");
			 System.out.println("     PRESS 9 to RollBack");
			 System.out.println("     PRESS 10 to Commit");
			 System.out.println("     PRESS 11 to EXIT student");
			 
			 int c=ui.integerInput(); 
			    
			  c= sv.intValidation(c,1,9);
			 
			 if(c==1)
			 {
				  String name;			 
				  System.out.println("Enter Student name :");
				  name = ui.stringInput();
				  name=sv.stringValidation(name);
				 
				 int age;	
				 System.out.println("Enter Student age :");
				 age = ui.integerInput(); 
				 age=sv.intValidation(age,18,28);
				 
				 String field ;				
				 System.out.println("Enter student field :");
				  field = ui.stringInput();
				 field= sv.stringValidation(field);	
				 
				
				 boolean isCreated=imp.creatStudent(new Student(name,field,age));
				 
				
				 if(isCreated)
				 {
				 System.out.println("Student added successfully");
				 }
				 else
				 {
					 System.out.println("Something went wrong");
				 }
				 
				 System.out.println();
				 System.out.println("--------------------------------------------------------");
				 System.out.println();
				 
			 }else if(c==2)
			 {
				 System.out.println("Enter student id to delete :");
				 
				 int studentId=ui.integerInput();
				 
				boolean isDeleted= imp.deleteStudent(studentId);
				 
				 if(isDeleted)
				 {
					 System.out.println(" Student with id  "+studentId+" is remove from database");
				 }
				 else
				 {
				 System.out.println(" no Student with id  "+studentId+" present in  database");
				 }
				 
				 System.out.println();
				 
			 }else if(c==3)
			 {
				 List<Student> students=imp.getAllStudents();
				 
				 if(students!=null)
				 {
				 for(Student student : students)
				 {
					 System.out.println(student);
				 }
				 }
				 else
				 {
					 System.out.println("empty set");
				 }
				 System.out.println();
				 
			 }else if(c==4)
			 {
				 System.out.println("Enter student id to Update:");
				 
				 int Id=ui.integerInput(); 
				 
							  String name=null;			 
							  System.out.println("Do you Want to update student name ? : [y/n]");
							  String input=ui.stringInput();
							  
							  if(input.equals("y"))
							  {
							  name = ui.stringInput();
							  name=sv.stringValidation(name);
							  
							  }						  
							 
							 int age =-1;	
							 System.out.println("Do you Want to update Student age ?: [y/n]");
							 input=ui.stringInput();
							 
							 if(input.equals("y"))
							 {
							 age = ui.integerInput(); 
							 age=sv.intValidation(age,18,28);
							 }
							 
							 
							 String field = null;				
							 System.out.println("Do you Want to update student field ?: [y/n]");
							 input=ui.stringInput();
							 
							 if(input.equals("y"))
							 {
							 field = ui.stringInput();
							 field= sv.stringValidation(field);	
							 }
							
							boolean isupdated= imp.updateStudent(Id,name,age,field);
							 
							if(isupdated)
							{
							 System.out.println("Student updated");
							}
							else
							{
								System.out.println("No student with such id");
							}
				
			 }else if(c==5)
			 {
				 
                 System.out.println("Enter set of student you want to skip:");
				 
				 int pageNo=ui.integerInput(); 
				 pageNo=sv.intValidation(pageNo,0,999);
				 
                System.out.println("Enter set of students details you want to see :");
				 
				int pageSize=ui.integerInput(); 
				pageSize=sv.intValidation(pageSize,0,25);
				
				List<Student> students=imp.Pagination(pageNo , pageSize);
				
				
				
				if(students!=null)
				{
				 for(Student st : students)
				 {
					 
					 System.out.println(st);
				 }
				}
				else
				{
					System.out.println("empty set" );
				}
				 
				 System.out.println();
				 
			 }else if(c==6)
			 {
				 System.out.println("Enter student id you want to search :");
				 
				 int id=ui.integerInput(); 
				 
				Student student=imp.getStudentbyId(id);
				
				if(student==null)
				{
					System.out.println("No such student with id "+id);
				}
				else
				{
				System.out.println(student);
				}
				
				System.out.println();
				 
			 }
			 else if(c==7){
				 
                 System.out.println("Enter student name you want to search :");
				 
				 String name=ui.stringInput();
				 name=sv.stringValidation(name);
				 
				List<Student>st=imp.getStudentbyName(name);
				
				if(st.isEmpty())
				{
					System.out.println("No such student with name "+name);
				}
				else
				{
				System.out.println(st);
				}
				
				System.out.println();
				 
			 }else if(c==8)
			 {
				 
                 System.out.println("Enter the Keyword you want to search in the name :");
				 
				 String key=ui.stringInput();
				 key=sv.stringValidation(key);
				 
				List<Student>st=imp.getStudentbyKey(key);
				
				if(st.isEmpty())
				{
					System.out.println("No such student with name "+key);
				}
				else
				{
				System.out.println(st);
				}
				
				System.out.println();
				 
			 }else if(c==9)
			 {
				 boolean isRollback=imp.rollback();
				 
				 if(isRollback)
				 {
					 System.out.println("Rollback sucessfull");
				 }
				 else
				 {
					 System.out.println("Rollback faild");
				 }
				 
			 }else if(c==10)
			 {
				boolean isCommit= imp.commit();
				
				if(isCommit)
				{
					System.out.println("Commit sucessfull");
				}
				else
				{
					System.out.println("Commit fail");
				}
				 
			 }
			 else if(c==11)
			 {
				 break;			 
			 }
			 else
			 {
				 
			 }
		 }
		 
		 System.out.println("Thankyou for visiting....");
		 System.out.println("See you soon...");
		 
	 }

}
