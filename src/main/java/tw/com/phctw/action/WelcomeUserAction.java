//package tw.com.phctw.action;
//
//import org.apache.struts2.convention.annotation.Action;
//import org.apache.struts2.convention.annotation.Actions;
//import org.apache.struts2.convention.annotation.Namespace;
//import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.convention.annotation.ResultPath;
//import org.apache.struts2.convention.annotation.Results;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//import tw.com.phctw.entity.Student;
//import tw.com.phctw.service.StudentService;
//
//
//@Namespace("/")
//@ResultPath(value = "/WEB-INF/views")
//public class WelcomeUserAction extends ActionSupport{
//
//	@Autowired
//	private StudentService service;
//	
////	@Autowired
////	@Qualifier("FormBean")
////	private FormBean bean;
//
//	Student student;
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//	
//	Student s;
//	public Student getS() {
//		return s;
//	}
//	public void setS(Student s) {
//		this.s = s;
//	}
//
//	@Action(value = "Welcome", results={
//			@Result(name="success",location="HelloWorld.jsp"),
//			@Result(name="fail",location="login.jsp")})
//	public String loginProcess() {
//		System.out.println(student);
//		s = service.validateStudent(student);
//		System.out.println(s);
//		if (s!=null) {
//			System.out.println("login success");
//	        return "success";
//		}
//		System.out.println("login fail");
//        return "fail";
//    }	
//} 
//
//
