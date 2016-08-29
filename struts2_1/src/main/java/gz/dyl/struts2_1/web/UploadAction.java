package gz.dyl.struts2_1.web;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传
 * @author DengYL
 * @version 2016年8月21日 下午10:20:52
 */
public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 8105657301122904115L;
	
	private File photo;//上传的文件
	private String photoFileName;//上传的文件名
	private String photoContentType;//上传的文件MIME类型
	
	public String toUpload(){
		return SUCCESS;
	}
	
	public String upload(){
		ServletContext application = ServletActionContext.getServletContext();
		String realPath = application.getRealPath("/WEB-INF/file");
		File dirFile = new File(realPath);
		if(!dirFile.exists()){//若目录不存在则创建
			dirFile.mkdirs();
		}
		
		//将缓存的文件重命名到指定的文件
		System.out.println("上传的文件名称是：" + photoFileName);
		System.out.println("上传的文件MIME类型是：" + photoContentType);
		photo.renameTo(new File(dirFile, photoFileName));
		return SUCCESS;
	}

	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

}
