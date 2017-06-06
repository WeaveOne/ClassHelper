package cn.willvi.service.file.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.willvi.service.file.FileUploadManager;
import cn.willvi.util.FileUpload;
import cn.willvi.util.FileValidation;

@Service("fileUploadService")
public class FileUploadService implements FileUploadManager {

	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;
	String path = "src/main/resources/static/";

	@Override
	public String uploadImg(MultipartFile file, String dir) {
		if (!FileValidation.isImage(file.getOriginalFilename())) {
			return "非允许的图片格式，禁止上传";
		}
		if (file.isEmpty()) {
			return "上传失败，文件为空";
		} else {
			String fileName = System.currentTimeMillis() + "";
			String filePath = path + "uploadImg/" + dir;
			try {
				String name = FileUpload.fileUp(file, filePath, fileName);
				Map<String, Object> data = new HashMap<>();
				data.put("path", "/uploadImg/"+ dir + "/" + name);
				simpMessageSendingOperations.convertAndSendToUser("1", "/image", data);
				
			} catch (IOException e) {
				return "上传失败，文件出错";
			}
			return "上传成功";
		}
	}

}
