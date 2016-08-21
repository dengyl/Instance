package gz.dyl.struts2_1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 登录拦截器
 * @author DengYL
 * @version 2016年8月21日 上午11:47:56
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -2808921962184712728L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截器执行-前");
		
		//从session域中取出username的值，若值有值则处于登录状态，其它情况为未登录
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println("当前登录人为：" + username);
		if(StringUtils.isBlank(username)){
			return "tologin";
		}
		
		String result = invocation.invoke();//放行
		
		System.out.println("拦截器执行-后");
		return result;
	}

}
