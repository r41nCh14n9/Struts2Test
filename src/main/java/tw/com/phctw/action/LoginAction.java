package tw.com.phctw.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import tw.com.phctw.entity.Student;
import tw.com.phctw.service.StudentService;


@Namespace("/")
@ResultPath(value="/WEB-INF/views")
public class LoginAction extends ActionSupport{

	//log4j
	Logger log = Logger.getLogger(LoginAction.class);
	
	@Autowired
	private StudentService service;
	
	Student studentIn;
	public Student getStudentIn() {
		return studentIn;
	}
	public void setStudentIn(Student studentIn) {
		this.studentIn = studentIn;
	}
	
	Student studentOut;
	public Student getStudentOut() {
		return studentOut;
	}
	public void setStudentOut(Student studentOut) {
		this.studentOut = studentOut;
	}
	
	//output message
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	List<Student> studentOutList;
	public List<Student> getStudentOutList() {
		return studentOutList;
	}
	public void setStudentOutList(List<Student> studentOutList) {
		this.studentOutList = studentOutList;
	}
	
	
	@Action(value = "login", results = {
			@Result(name="success",location="login.jsp")
	})
	public String loginPage() {
		return "success";
	}
	
	
	@Action(value = "loginProcess", results={
			@Result(name="success",location="showOneInfo.jsp"), //,type = "redirect"
			@Result(name="fail",location="login.jsp")
	})
	public String loginProcess() {
		try {
			System.out.println(studentIn);
			studentOut = service.validateStudent(studentIn);
			System.out.println(studentOut);
			if (studentOut!=null) {
				System.out.println("login success");
		        return "success";
			}
			ActionContext.getContext().put("message", "AccountName or Password is invalid!!");
			System.out.println("login fail");
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
		}
		return "fail";
    }	
	
	@Action(value = "forgetPwd", results = {
			@Result(name="success", location="forgetPwd.jsp")
	})
	public String forgetPwdPage() {
		return "success";
	}
	
	@Action(value = "resetPwdProcess", results={
			@Result(name="success",type = "redirect",location="login", params = {"message", "%{message}"}),
			@Result(name="fail",location="forgetPwd.jsp")
	})
	public String resetPwdProcess() {
		
		try {
			System.out.println(studentIn);
			studentOut = service.checkForgotenStd(studentIn);
			System.out.println(studentOut);
			if (studentOut!=null) {
				service.resetPwd(studentOut);
				message = "reset success";
				System.out.println("reset success");
		        return "success";
			}
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
		}
		ActionContext.getContext().put("message", "AccountName or Email is invalid!!");
		System.out.println("reset fail");
        return "fail";
	}
	
	@Action(value = "query", results = {
			@Result(name="success", location="showInfo.jsp")
	})
	public String query() {
		try {
			studentOutList = service.getAllStudents();
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
		}
		return "success";
	}
	
} 