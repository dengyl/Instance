package gz.dyl.struts2_1.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import gz.dyl.struts2_1.entity.Student;

/**
 * @author DengYL
 * @version 2016年8月20日 下午1:11:39
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 3655577974596521423L;
	
	//注意：使用模型驱动必须自己实例化对象
	private Student student = new Student();

	public Student getModel() {
		return student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	//@SkipValidation
	public String toAdd(){
		return "toadd";
	}
	
	public String add(){
		System.out.println(student);
		return SUCCESS;
	}
	
	/**
	 * 默认validate()方法会在调用当前动作类方法前调用，进行数据验证。
	 * 
	 * 若动作类中个别方法执行前不需要调用validate()方法进行数据验证，可在这些方法上添加注解@SkipValidation跳过该方法
	 * 
	 * 若动作类中只有个别方法执行前需要调用validate()方法进行数据验证，可将validate()方法改名，格式为：
	 * validate+方法名（首字母转大写）。
	 */
	/*public void validate() {
		if(StringUtils.isBlank(student.getName())){
			addFieldError("name", "姓名不能为空！");
		}else if(student.getName().length() < 3 || student.getName().length() > 4){
			addFieldError("name", "姓名只能为3-4位！");
		}
	}*/
	
	//数据验证
	/*public void validateAdd() {
		if(StringUtils.isBlank(student.getName())){
			addFieldError("name", "姓名不能为空！");
		}else if(student.getName().length() < 3 || student.getName().length() > 4){
			addFieldError("name", "姓名只能为3-4位！");
		}
	}*/

}
