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
	private boolean married;
	private String hobby;
	private String city;
	private String remark;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
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
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", birthday=" + birthday + ", married=" + married + ", hobby="
				+ hobby + ", city=" + city + ", remark=" + remark + "]";
	}

}
