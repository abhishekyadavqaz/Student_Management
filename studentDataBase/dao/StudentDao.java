package main.Java.com.scg.studentDataBase.dao;

import java.sql.SQLException;
import java.util.List;

import main.Java.com.scg.studentDataBase.vo.Student;

public interface StudentDao {
	
	public boolean insertStudent(Student student) throws SQLException;
	
	 
   public List<Student> getAllStudents() throws SQLException;
   
   public Student getStudentbyId(int rollNo) throws SQLException;
   
   public List<Student> getStudentbyName(String name) throws SQLException;
   
   public List<Student> getStudentbyKey(String name) throws SQLException;
   
   public void UpdateStudent(int studentId , String name,int age, String field) throws SQLException;
   
   public boolean deleteStudent(int studentId) throws SQLException;
   
   public List<Student> Pagination(int pageNo,int pageSize) throws SQLException;
   
   public boolean rollback() throws SQLException;
   
   public boolean commit() throws SQLException;
   
}
