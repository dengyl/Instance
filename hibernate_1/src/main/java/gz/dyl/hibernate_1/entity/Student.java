package gz.dyl.hibernate_1.entity;

import java.io.Serializable;

/**
 * @author DengYL
 * @version 2016年9月11日 下午3:33:38
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 824981646383976247L;
	
	private String id;
	private String name;
	private Integer age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
