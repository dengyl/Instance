package gz.dyl.struts2_1.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import gz.dyl.struts2_1.entity.Student;

/**
 * @author DengYL
 * @version 2016年9月2日 下午11:16:25
 */
public class TagDemoAction extends ActionSupport {

	private static final long serialVersionUID = -1649760947949297158L;
	
	private List<Student> studentList = new ArrayList<Student>();
	
	@Override
	public String execute() throws Exception {
		
		studentList.add(new Student("Jack", 12));
		studentList.add(new Student("Rose", 14));
		studentList.add(new Student("Mike", 15));
		
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
