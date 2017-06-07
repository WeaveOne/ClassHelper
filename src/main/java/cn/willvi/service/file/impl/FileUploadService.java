package cn.willvi.service.file.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.willvi.service.file.FileUploadManager;

@Service("fileUploadService")
public class FileUploadService implements FileUploadManager {

	

	@Override
	public String uploadImg(MultipartFile file, String dir) {
		return dir;
		
	}

}
