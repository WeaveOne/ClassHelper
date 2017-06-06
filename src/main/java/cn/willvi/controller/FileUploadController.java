package cn.willvi.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.willvi.util.FileUpload;
import cn.willvi.util.KeyValidation;

@Controller
public class FileUploadController extends BaseController {

	String path = "src/main/resources/static/";

	@RequestMapping("/file")
	public String file() {
		return "/file";
	}

	@RequestMapping("/uploadImg")
	@ResponseBody
	public String uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("id") String tId, String key, String encryptionParameter) {
//		if(!KeyValidation.isCrrect(key, encryptionParameter)) {
//			return "验证未通过，不允许上传文件";
//		}
		if (file.isEmpty()) {
			return "上传失败，文件为空";
		} else {
			String fileName = System.currentTimeMillis() + "";
			String filePath = path + "uploadImg/" + tId;
			try {
				FileUpload.fileUp(file, filePath, fileName);
			} catch (IOException e) {
				return "上传失败，文件出错";
			}
			return "上传成功";
		}

	}
}
