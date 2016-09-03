package gz.dyl.struts2_1.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DengYL
 * @version 2016年8月31日 下午9:40:11
 */
public class ActionContextDemoAction extends ActionSupport {

	private static final long serialVersionUID = 8260156394629093666L;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		//获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		//往ActionContext中存数据
		context.put("contextMap", "hello contextMap");
		
		
		//往ActionContext中的request中存数据
		Map<String, Object> requestMap = (Map<String, Object>) context.get("request");
		requestMap.put("requestMap", "hello requestMap");
		//往request域中存数据
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("request", "hello request");
		return SUCCESS;
	}

}
