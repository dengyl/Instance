package gz.dyl.struts2_1.web;

import java.util.Random;

/**
 * 简单的入门案例
 * @author DengYL
 * @version 2016年8月16日 下午11:04:31
 */
public class HelloAction {
	
	public String sayHello(){
		Random random = new Random();
		int num = random.nextInt(3) % 3;
		if(0 == num){
			System.out.println("bye gay!");
			return "error";
		}
		if(1 == num){
			System.out.println("exception gay!");
			num = 1 / 0;
		}
		System.out.println("hello gay!");
		return "success";
	}

}
