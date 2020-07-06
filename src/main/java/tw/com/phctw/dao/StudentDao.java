package tw.com.phctw.dao;

import java.util.List;

import tw.com.phctw.entity.Student;



public interface StudentDao {
	Student getStudentBySid(Long sid) throws Exception;
	
	List<Student> getAllStudents()throws Exception;

	boolean deleteStudentBySid(Long sid)throws Exception;

	boolean updateStudent(Student student)throws Exception;

	boolean insertStudent(Student student)throws Exception;
	
	Student getStudentForLogin(Student s)throws Exception;
	
	Student getStudentBySacc(String sacc)throws Exception;
	
	public Student getStudentBySaccAndSmail(String sacc, String smail)throws Exception;
}
