package gz.dyl.struts2_1.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts2中通配符的使用
 * @author DengYL
 * @version 2016年8月16日 下午11:47:35
 */
public class PersonAction extends ActionSupport {

	private static final long serialVersionUID = -5473731461712841737L;
	
	public String add(){
		System.out.println("add");
		return SUCCESS;
	}
	
	public String update(){
		System.out.println("update");
		return SUCCESS;
	}
	
	public String find(){
		System.out.println("find");
		return SUCCESS;
	}
	
	public String delete(){
		System.out.println("delete");
		return SUCCESS;
	}

}
