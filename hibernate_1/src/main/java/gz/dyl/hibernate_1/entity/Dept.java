package gz.dyl.hibernate_1.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @author DengYL
 * @version 2016年9月16日 下午12:25:36
 */
public class Dept implements Serializable {

	private static final long serialVersionUID = 9013388311417115500L;
	
	private String id;
	private String name;
	private Set<Emp> emps;
	
	public Dept(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Dept() {
		super();
	}
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
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", emps=" + emps + "]";
	}

}
