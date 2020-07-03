package tw.com.phctw.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


@Namespace("/")
@ResultPath(value="/")
@Action(value = "home", results = {
	@Result(name="success",location="/WEB-INF/views/home.jsp")
})
public class HomeAction extends ActionSupport{

} 