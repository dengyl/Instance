package gz.dyl.struts2_1.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DengYL
 * @version 2016年8月20日 下午1:09:35
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 7040954547118278087L;
	
	private String name;
	private Integer age;
	private Date birthday;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}

}
