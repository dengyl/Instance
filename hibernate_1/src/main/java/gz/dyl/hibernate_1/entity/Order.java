package gz.dyl.hibernate_1.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @author DengYL
 * @version 2016年9月16日 下午8:45:54
 */
public class Order implements Serializable {

	private static final long serialVersionUID = -7312133526679033489L;
	
	private String id;
	private String name;
	private Set<Commodity> commodities;
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
	public Set<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}

}
