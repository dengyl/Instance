package gz.dyl.struts2_1.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件下载
 * @author DengYL
 * @version 2016年8月29日 下午10:39:59
 */
public class DownloadAction extends ActionSupport {

	private static final long serialVersionUID = 8482520673130703099L;
	
	private InputStream inputStream;
	private String filename;
	
	
	public String download() throws Exception {
		String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/file");
		File file = new File(realPath, "key.txt");
		this.inputStream = new FileInputStream(file);
		this.filename = "笔记.txt";
		return SUCCESS;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
