package gz.dyl.hibernate_1.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @author DengYL
 * @version 2016年9月16日 下午8:47:24
 */
public class Commodity implements Serializable {

	private static final long serialVersionUID = -6657636619942986955L;
	
	private String id;
	private String name;
	private Set<Order> orders;
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
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
