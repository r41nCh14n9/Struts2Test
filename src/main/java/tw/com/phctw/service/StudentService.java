package tw.com.phctw.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.phctw.dao.StudentDao;
import tw.com.phctw.entity.Student;
import tw.com.phctw.util.ForgetPwdMail;

@Service(value = "studentService")
@Transactional
public class StudentService {

	@Autowired
	private StudentDao dao;

	@Autowired
	private ForgetPwdMail fpm;

	public Student getStudentBySid(Long sid) throws Exception{
		try {
			return dao.getStudentBySid(sid);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Student> getAllStudents() throws Exception{
		try {
			return dao.getAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean deleteStudentBySid(Long sid) throws Exception  {
		try {
			return dao.deleteStudentBySid(sid);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean insertStudent(Student student) throws Exception {
		try {
			return dao.insertStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean updateStudent(Student student) throws Exception {
		try {
			return dao.updateStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// login
	public Student validateStudent(Student s) throws Exception {
		System.out.println("in service...");
		try {
			s.setSpwd(getMD5Endocing(s.getSpwd()));
			Student student = dao.getStudentForLogin(s);
			if (student != null) {
				System.out.println("account exist.");
			} else {
				System.out.println("account is invalid.");
			}
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// register check
	public boolean checkSaccExist(String sacc) throws Exception {
		try {
			if (dao.getStudentBySacc(sacc) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// register
	public boolean register(Student student) throws Exception {
		try {
			String encPwd = getMD5Endocing(student.getSpwd());
			student.setSpwd(encPwd);
			if (dao.insertStudent(student)) {
				System.out.println("學生資料建立成功");
				return true;
			} else {
				System.out.println("學生資料建立失敗");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// forgetPwd check
	public Student checkForgotenStd(Student student) throws Exception {
		try {
			String sacc = student.getSacc();
			String smail = student.getSmail();
			Student studentOut = dao.getStudentBySaccAndSmail(sacc, smail);
			if (studentOut != null) {
				System.out.println("account exist.");
			} else {
				System.out.println("account is invalid.");
			}
			return studentOut;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// reset Pwd
	public boolean resetPwd(Student student) throws Exception {
		try {
			String newPwd = fpm.createPwd();
			String encPwd = getMD5Endocing(newPwd);
			String toAddr = student.getSmail();

			student.setSpwd(encPwd);

			if (dao.updateStudent(student)) {
				fpm.send(toAddr, newPwd);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public String getMD5Endocing(String message)throws Exception {
		final StringBuffer buffer = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(message.getBytes());
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; ++i) {
				final byte b = digest[i];
				final int value = Byte.toUnsignedInt(b);
				buffer.append(value < 16 ? "0" : "");
				buffer.append(Integer.toHexString(value));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw e;
		}
		return buffer.toString();
	}

}
