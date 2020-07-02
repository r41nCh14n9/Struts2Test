package tw.com.phctw.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


@Namespace("/test")
public class IndexAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Action(value = "index", results={
			@Result(name="success",location="/index.jsp")})
	public String index() {
		System.out.println("succ");
        return "success";
    }

	@Action(value = "second", results = {
			@Result(name="success",location="/WEB-INF/views/HelloWorld.jsp")})
	public String second() {
		System.out.println("exec");
        return "success";
    }
} 