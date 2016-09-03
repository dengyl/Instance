package gz.dyl.struts2_1.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import gz.dyl.struts2_1.entity.Student;

/**
 * @author DengYL
 * @version 2016年9月3日 上午12:03:38
 */
public class FormDemoAction extends ActionSupport implements ModelDriven<Student>{

	private static final long serialVersionUID = -1231364210746600008L;
	
	private Student student = new Student();

	public Student getModel() {
		return student;
	}
	
	public String toForm(){
		return "toform";
	}
	
	public String form(){
		System.out.println(student);
		return NONE;
	}

}
