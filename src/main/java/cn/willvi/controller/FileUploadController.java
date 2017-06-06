package cn.willvi.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.willvi.service.file.FileUploadManager;
import cn.willvi.util.KeyValidation;

@Controller
public class FileUploadController extends BaseController {

	@Resource(name = "fileUploadService")
	FileUploadManager fileUploadManager;

	@RequestMapping("/file")
	public String file() {
		return "/file";
	}

	@RequestMapping("/uploadImg")
	@ResponseBody
	public String uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("id") String tId,
			@RequestParam("key") String key, @RequestParam("encryptionParameter") String encryptionParameter) {
		if (!KeyValidation.isCrrect(key, encryptionParameter)) {
			return "验证未通过，不允许上传文件";
		}
		return fileUploadManager.uploadImg(file, tId);
	}
}
