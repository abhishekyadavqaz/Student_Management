package main.Java.com.scg.studentDataBase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Java.com.scg.studentDataBase.vo.Student;

public class StudentDaoImplementation implements StudentDao  {  		 

	   public StudentDaoImplementation() {			   
		    connect = StudentConnection.createConnection();			
	   }	
	   
	   static Connection connect;
	   
	   @Override
		public boolean insertStudent(Student student) throws SQLException {
		   
			boolean creat=false;
			
			try {				
				
				String query = "insert into students(studentName,studentAge,studentField) values(?,?,?)";
				
				PreparedStatement statement =connect.prepareStatement(query);			
				
				statement.setString(1,  student.getStudentName());
				statement.setInt(2,  student.getStudentAge());
				statement.setString(3,  student.getStudentFields());
				
				statement.executeUpdate();
				
               String query2 = "insert into eligible(studentAge,studentEligible) values(?,?)";
				
				PreparedStatement statement2 =connect.prepareStatement(query2);	
				
				boolean isEligible=false;
				
				if(student.getStudentAge()>=22)
				{
					isEligible=true;
				}
				statement2.setInt(1,  student.getStudentAge());
				statement2.setBoolean(2, isEligible );
				
				statement2.executeUpdate();				
				
				creat=true;
				
			}catch(Exception e) {
				
				connect.rollback();
				e.printStackTrace();
				
			}finally {
				
				if(creat)
				{
					connect.commit();
				}
				{
					connect.rollback();
				}
			}		
		
			return creat;
		}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		
		List<Student> studentList = new  ArrayList<Student>();		
        try {
			
			String query = "select * from students";
			
			PreparedStatement statement =connect.prepareStatement(query);		
			
			ResultSet resultSet = statement.executeQuery();
			
			Student student;
		    
			while(resultSet.next()) {
				
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String field= resultSet.getString(4);
				
				student = new Student(id,name,field,age);
				studentList.add(student);
			}
			
		}catch(Exception e) {
			
			connect.rollback();
			e.printStackTrace();
			
		}
        
        return studentList;
	}
	
	@Override
	public Student getStudentbyId(int studentId) throws SQLException {
		
		Student student=null;
		
		try {			
			
			String query = "select * from students where studentId=?";
			 
			PreparedStatement statement =connect.prepareStatement(query);
			
		statement.setInt(1,studentId);
		
			ResultSet resultSet = statement.executeQuery();
						
			while(resultSet.next()) {
				
				int id = resultSet.getInt("studentId");
				String name = resultSet.getString("studentName");
				int age = resultSet.getInt("studentAge");
				String field= resultSet.getString("studentField");
				
				student = new Student(id,name,field,age);				
			}
			
		}catch(Exception e) {
			
			connect.rollback();
			e.printStackTrace();		
			
		}
		
		return student;
	}

	@Override
	public void UpdateStudent(int Id , String name,int age, String field)throws SQLException {	
		
		try {			
			
			String query = "UPDATE students SET studentName = ?, studentAge = ?,studentField = ?  WHERE studentId=?;";						
			
			PreparedStatement statement =connect.prepareStatement(query);
			
			statement.setString(1, name);
			statement.setInt(2,  age);
			statement.setString(3, field);
			statement.setInt(4,  Id);
			
			statement.executeUpdate();		
			
		}catch(Exception e) {
			
			connect.rollback();
			e.printStackTrace();
			
			
		}
		
	}

	@Override
	public boolean deleteStudent(int studentId) throws SQLException {
		
		boolean delete = false;
	
		try {
		
			String query = "delete from students where studentId=?";
						
			
			PreparedStatement statement =connect.prepareStatement(query);
			
			statement.setInt(1,studentId);
			
			
			int  numberOfRecordsDeleted = statement.executeUpdate();
			
			if(numberOfRecordsDeleted>0)
			{
			delete=true;
			}
		
		}catch(Exception e) {
			
			connect.rollback();
			e.printStackTrace();						
		}
	
		return delete;
		}

	@Override
	public List<Student> Pagination(int pageNo, int pageSet) throws SQLException { 
		
		List<Student> studentList = new  ArrayList<Student>();	
	
		try {
			
			 String query = String.format("select * from students limit %1$d offset %2$d", pageSet,pageNo);
			
			PreparedStatement statement =connect.prepareStatement(query);
		
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				int id = resultSet.getInt("studentId");
				String name = resultSet.getString("studentName");
				int age = resultSet.getInt("studentAge");
				String field= resultSet.getString("studentField");				
				studentList.add(new Student(id,name,field,age));				
			}
			
		}catch(Exception e) {
			
			connect.rollback();
			e.printStackTrace();					
		}
		
		return studentList;
	}

	@Override
	public List<Student> getStudentbyName(String studentName) throws SQLException {
		
		List<Student> studentList = new  ArrayList<Student>();	
	
		try {			
			
			 String query = String.format("select * from students where studentName ='%s'", studentName);
			
			PreparedStatement statement =connect.prepareStatement(query);	
			
			ResultSet resultSet = statement.executeQuery(query);		
			
			while(resultSet.next()) {
				
				int id = resultSet.getInt("studentId");
				String name = resultSet.getString("studentName");
				int age = resultSet.getInt("studentAge");
				String field= resultSet.getString("studentField");
				
				studentList.add(new Student(id,name,field,age));				
			}
			
		}catch(Exception e) {
			
			connect.rollback();
			e.printStackTrace();					
		}
		
		return studentList;
	}

	@Override
	public List<Student> getStudentbyKey(String key) throws SQLException {
		
		List<Student> studentList = new  ArrayList<Student>();	
	
		try {		
			
			 String Key="%"+key+"%";
			 String query = String.format("select * from students where studentName like '%s'", Key);
			 			
			PreparedStatement statement =connect.prepareStatement(query);		
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				int id = resultSet.getInt("studentId");
				String name = resultSet.getString("studentName");
				int age = resultSet.getInt("studentAge");
				String field= resultSet.getString("studentField");			
				studentList.add(new Student(id,name,field,age));				
			}			
			
		}catch(Exception e) {
			
			connect.rollback();
			e.printStackTrace();				
		}
		
		return studentList;
	}

	@Override
	public boolean rollback() throws SQLException {
		
		boolean isRollback=false;
		
		try {		
			 connect.rollback();
			 isRollback=true;
			 
		}catch(Exception e)
		{
			
			e.printStackTrace();	
		}
		return isRollback;
	}

	@Override
	public boolean commit() throws SQLException {
		
		boolean isCommit=false;
		
		try {		
			 
			 connect.commit();
			 isCommit=true;
			 
		}catch(Exception e)
		{
			e.printStackTrace();	
		}
		return isCommit;
	}

}
