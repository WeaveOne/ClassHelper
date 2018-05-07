package cn.willvi.service.file.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.willvi.dao.DaoSupport;
import cn.willvi.entity.Files;
import cn.willvi.service.file.FileUploadManager;
import cn.willvi.util.PageData;

@Service("fileUploadService")
public class FileUploadService implements FileUploadManager {


	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Override
	public String uploadImg(MultipartFile file, String dir) {
		return dir;
		
	}

	@Override
	public Object uploadFile(PageData pd) throws Exception {
		return dao.save("FileMapper.uploadFile", pd);
	}

	@Override
	public List<Files> getFileList(PageData pd) throws Exception {
		return (List<Files>) dao.findForList("FileMapper.getFileList", null);
	}

}
