package cn.willvi.service.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传管理类
 * @author 维
 *
 */
public interface FileUploadManager {

	/**
	 * 上传图片
	 * @param file
	 * 		文件
	 * @param dir
	 * 		文件夹
	 * @return
	 */
	public String uploadImg(MultipartFile file, String dir);
}
