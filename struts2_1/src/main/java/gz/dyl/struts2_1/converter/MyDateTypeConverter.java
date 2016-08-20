package gz.dyl.struts2_1.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 自定义日期类型转换器
 * @author DengYL
 * @version 2016年8月20日 下午1:53:17
 */
public class MyDateTypeConverter extends StrutsTypeConverter {
	
	DateFormat[] dateFormats = {new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("MM/dd/yyyy")};

	//将日期字符串转换成日期类型
	@SuppressWarnings("rawtypes") 
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(null == values || values.length == 0){
			return null;
		}
		
		if(toClass != Date.class){
			return null;
		}
		
		String val = values[0];
		for(int i = 0; i < dateFormats.length; i++){
			try {
				Date date = dateFormats[i].parse(val);
				return date;
			} catch (ParseException e) {
				continue;
			}
		}
		
		throw new RuntimeException("日期类型转换异常！");
	}

	//将日期类型转换成日期字符串
	@SuppressWarnings("rawtypes") 
	public String convertToString(Map context, Object o) {
		if(o instanceof Date){
			Date date = (Date) o;
			return dateFormats[0].format(date);
		}
		return null;
	}

}
