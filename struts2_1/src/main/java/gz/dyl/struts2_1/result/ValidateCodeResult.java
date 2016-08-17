package gz.dyl.struts2_1.result;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import gz.dyl.struts2_1.util.ValidateCode;

/**
 * 自定义结果视图：验证码图片
 * @author DengYL
 * @version 2016年8月17日 下午8:53:42
 */
public class ValidateCodeResult extends StrutsResultSupport {

	private static final long serialVersionUID = 3086977485415175644L;

	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession();
		ServletOutputStream out = response.getOutputStream();
		
		response.setContentType("image/jpeg");
	    
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0L);
	    
	    ValidateCode code = new ValidateCode(120, 30, 4, 100);
	    session.setAttribute("code", code.getCode());
	    code.write(out);
	}

}
