package main.Java.com.scg.studentDataBase.service;


import java.sql.SQLException;
import java.util.List;
import main.Java.com.scg.studentDataBase.dao.StudentDao;
import main.Java.com.scg.studentDataBase.dao.StudentDaoImplementation;
import main.Java.com.scg.studentDataBase.vo.Student;

public class StudentServiceImplementation implements StudentService{
	
	   private StudentDao student = new StudentDaoImplementation();
	  
	   
	   public boolean creatStudent(Student creatStudent) throws SQLException 
	   {	   
		   boolean creat=student.insertStudent(creatStudent);	   
		   
		   return creat;
	   }
	   
 
	   public List<Student> getAllStudents() throws SQLException
	   {
		    return student.getAllStudents();
	   }
	   
	   
	   public Student getStudentbyId(int Id) throws SQLException
	   {
		   return student.getStudentbyId(Id);
	   }
	   
	   
	   public List<Student> getStudentbyName(String name) throws SQLException
	   {
		   return student.getStudentbyName(name);
	   }
	   
	   
	   public List<Student> getStudentbyKey(String name) throws SQLException
	   {
		   return student.getStudentbyKey(name);
	   }	   
	   
	   
	   public boolean updateStudent(int Id,String name,int age,String field) throws SQLException 
	   {	
		   Student oldStudent = student.getStudentbyId(Id);			 
		   boolean updated = false;
		   
				  if(oldStudent!=null)
				   {
			          
			          if(name==null)
			           {
				        name = oldStudent.getStudentName();
			           }	  
			   
			          if(age==-1)
			           {
				        age = oldStudent.getStudentAge();
			           }
			        
			          if(field==null)
			           {
				       field = oldStudent.getStudentFields();
			           }	
			          
			          student.UpdateStudent( Id ,name, age,field);		          
			         updated=true;
				   }
				  
			return updated;		  			  		
	   }	   
	   
	   
	   public boolean deleteStudent(int studentId) throws SQLException
	   {
		   boolean delete=student.deleteStudent(studentId);		   
		   return delete;
	   }
	   
	   
	   public List<Student> Pagination(int pageNo,int pageSet) throws SQLException
	   {	   		   
		   int totalStudent=student.getAllStudents().size();		   
		   
			if(pageNo*pageSet<totalStudent&&(pageNo*pageSet+pageSet)>totalStudent)	
			{								
				int totalStudentleft=totalStudent-pageNo*pageSet;
				
				return student.Pagination(pageNo*pageSet,totalStudentleft);	
			}
			else if ((pageNo*pageSet+pageSet)<totalStudent)
			{			
				return student.Pagination(pageNo*pageSet,pageSet);	
			}
			else
			{
				return null;
			}		   
	    }


	@Override
	public boolean rollback() throws SQLException {
		
		return student.rollback();
	}


	@Override
	public boolean commit() throws SQLException {
		
		return student.commit();
	}

}
