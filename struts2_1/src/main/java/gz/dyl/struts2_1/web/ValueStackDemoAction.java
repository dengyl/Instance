package gz.dyl.struts2_1.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import gz.dyl.struts2_1.entity.Student;

/**
 * @author DengYL
 * @version 2016年8月31日 下午9:56:38
 */
public class ValueStackDemoAction extends ActionSupport {

	private static final long serialVersionUID = 8634000181946924965L;
	
	private String name = "haha";
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		//获取ValueStack对象
		//方式一：
		ActionContext context = ActionContext.getContext();
		Map<String, Object> requestMap = (Map<String, Object>) context.get("request");
		ValueStack stack1 = (ValueStack) requestMap.get("struts.valueStack");
		System.out.println(stack1);
		//方式二：
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack stack2 = (ValueStack) request.getAttribute("struts.valueStack");
		System.out.println(stack2);
		//方式三：
		ValueStack stack = context.getValueStack();
		System.out.println(stack);
		
		//压栈
		stack.push(new Student("Jack", 21));
		//setValue
		//第一个参数有#表示存入ActionContext中，没有#表示存入ValueStack中
		stack.setValue("#name", "Rose");
		stack.setValue("#request.name", "Mike");
		stack.setValue("#username", "heihei");
		stack.setValue("name", "Lily");//替换值栈中第一个name属性的值，若值栈中没有name属性或没有一个name属性有setter方法则报错
		//set
		//若栈顶是一个map则将key为s，值为student的键值对存入map中，若栈顶不是map，则创建map后将key为s，值为student的键值对存入map中
		stack.set("s1", new Student("Tom", 23));
		stack.set("s2", new Student("Kit", 24));
		
		stack.push(new Student("Nice", 12));
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
