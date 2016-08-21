package gz.dyl.struts2_1.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DengYL
 * @version 2016年8月21日 上午11:23:32
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -6340633804446266913L;
	
	private String username;
	
	public String toLogin(){
		
		String key = getText("key");
		System.out.println(key);
		
		return "tologin";
	}
	
	public String login(){
		
		System.out.println("登录人为：" + username);
		//将username的值存入session域中模拟一直登录的情况
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		return SUCCESS; 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
