package cn.willvi.service.file;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.willvi.entity.Files;
import cn.willvi.util.PageData;

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
	/**
	 * 上传文件
	 * @param pd
	 * @return
	 */
	public Object uploadFile(PageData pd) throws Exception;
	
	public List<Files> getFileList(PageData pd) throws Exception;
}
