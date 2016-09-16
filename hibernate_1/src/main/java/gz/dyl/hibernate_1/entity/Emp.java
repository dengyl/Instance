package gz.dyl.hibernate_1.entity;

import java.io.Serializable;

/**
 * @author DengYL
 * @version 2016年9月16日 下午12:27:06
 */
public class Emp implements Serializable {

	private static final long serialVersionUID = -4456395273459214370L;
	
	private String id;
	private String name;
	private Dept dept;
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
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
