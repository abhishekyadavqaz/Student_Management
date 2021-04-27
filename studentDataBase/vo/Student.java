package main.Java.com.scg.studentDataBase.vo;

public class Student {
	
	private  int studentId;
	private String studentName;
	private String studentField;
	private int studentAge;
	
	public Student(String studentName, String studentField, int studentAge) {
		
		
		super();		
		this.studentName = studentName;
		this.studentField = studentField;
		this.studentAge = studentAge;
	}
	
public Student(int studentId, String studentName, String studentField, int studentAge) {
		
		
		super();	
		this.studentId=studentId;
		this.studentName = studentName;
		this.studentField = studentField;
		this.studentAge = studentAge;
	}

	public  int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentFields() {
		return studentField;
	}

	public void setStudentFields(String studentFields) {
		this.studentField = studentFields;
	}

	@Override
	public String toString() {
		return "STUDENT {  studentName = " + studentName + ", studentField = " + studentField + ", studentAge = " + studentAge
				+ ", studentId = " + studentId +" }";
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	

}
