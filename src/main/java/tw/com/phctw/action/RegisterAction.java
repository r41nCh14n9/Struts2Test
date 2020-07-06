package tw.com.phctw.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import tw.com.phctw.entity.Student;
import tw.com.phctw.service.StudentService;


@ParentPackage("json-default")
@Namespace("/")
@ResultPath(value = "/WEB-INF/views")
public class RegisterAction extends ActionSupport{
	
	// log4j
	Logger log = Logger.getLogger(LoginAction.class);
	
	@Autowired
	StudentService service;
	
	private Student studentIn;
	public Student getStudentIn() {
		return studentIn;
	}public void setStudentIn(Student studentIn) {
		this.studentIn = studentIn;
	}
	
	private Student studentOut;
	public Student getStudentOut() {
		return studentOut;
	}public void setStudentOut(Student studentOut) {
		this.studentOut = studentOut;
	}
	
	//input date 
	private String studentInBD;
	public String getStudentInBD() {
		return studentInBD;
	}
	public void setStudentInBD(String studentInBD) {
		this.studentInBD = studentInBD;
	}
	
	//input sacc
	private String sacc;
	public String getSacc() {
		return sacc;
	}
	public void setSacc(String sacc) {
		this.sacc = sacc;
	}
	
	//output message
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Action(value = "register", results = {
			@Result(name="success",location="register.jsp")
		})
	public String registerPage() {
		return "success";
	}
	
	@Action(value = "registerProcess", results = {
			@Result(name="success",type = "redirect", location="login", params = {"message", "%{message}"}),
			@Result(name="fail",location="register.jsp")
		})
	public String registerProcess() {
		Date sBDate;
		try {
			sBDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(studentInBD).getTime());
			studentIn.setSbday(sBDate);
			System.out.println("student in : " + studentIn);
			studentOut = studentIn;
			System.out.println("student out : " + studentOut);
			// check if student is exist
			if(!service.checkSaccExist(studentOut.getSacc())) {
				service.register(studentOut);
				message = "Registration Success.";
				System.out.println("registration success");
				return "success";
			}
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
		}
		ActionContext.getContext().put("message", "User Data is invalid!!");
		System.out.println("registration failure");
		return "fail";

	}
	
	@Action(value = "accCheck", results = {
			@Result(name = "success",type ="json",params = {"message", "%{message}"} )
//			@Result(name = "fail"
	})
	public String accCheck() {
		
		try {
			System.out.println("sacc = " + sacc);
			boolean exist = service.checkSaccExist(sacc);
			System.out.println(exist);
			if (exist) {
//			System.out.println("accountName is occupied.");
				message = "Account Name is occupied.";
				return "success";
			}
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
		}
		message ="";
		System.out.println("account is avalible.");
		return "success";
	}
	
} 