package gz.dyl.struts2_1.web;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 多文件上传
 * @author DengYL
 * @version 2016年8月21日 下午11:54:17
 */
public class MultiUploadAction extends ActionSupport {

	private static final long serialVersionUID = -570889254163696200L;
	
	private File[] photo;
	private String[] photoFileName;
	private String[] photoContentType;
	
	public String toMultiUpload(){
		return SUCCESS;
	}
	
	public String multiUpload(){
		ServletContext application = ServletActionContext.getServletContext();
		String realPath = application.getRealPath("/WEB-INF/file");
		File dirFile = new File(realPath);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		
		for(int i = 0; i < photo.length; i++){
			System.out.println("上传的文件名称是：" + photoFileName[i]);
			System.out.println("上传的文件MIME类型是：" + photoContentType[i]);
			photo[i].renameTo(new File(dirFile, photoFileName[i]));
		}
		return SUCCESS;
	}
	
	
	public File[] getPhoto() {
		return photo;
	}
	public void setPhoto(File[] photo) {
		this.photo = photo;
	}
	public String[] getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String[] getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}

}
