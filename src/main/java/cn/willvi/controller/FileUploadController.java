package cn.willvi.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.willvi.entity.Result;
import cn.willvi.entity.UploadImage;
import cn.willvi.handle.FileUploadException;
import cn.willvi.service.file.FileUploadManager;
import cn.willvi.util.FileUpload;
import cn.willvi.util.FileValidation;
import cn.willvi.util.PathUtils;
import cn.willvi.util.ResultUtil;

@Controller
public class FileUploadController extends BaseController {

	@Resource(name = "fileUploadService")
	FileUploadManager fileUploadManager;
	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;

	public static final String ROOT = "src/main/resources/static/uploadImg";

	private final ResourceLoader resourceLoader;

	@Autowired
	public FileUploadController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@RequestMapping("/file")
	public String file() {
		return "/file";
	}

	@PostMapping("/uploadImg")
	@ResponseBody
	/**
	 * @Valid用于验证是否满足该类的一些条件
	 **/
	public Result uploadImg(@Valid UploadImage image, BindingResult bindingResult) throws Exception {

		/** 不满足返回 **/
		if (bindingResult.hasErrors()) {
			throw new FileUploadException(1, bindingResult.getFieldError().getDefaultMessage());
		}
		// if (!KeyValidation.isCrrect(key, encryptionParameter)) {
		// return "验证未通过，不允许上传文件";
		// }
		MultipartFile file = image.getFile();
		Integer tId = image.getId();
		if (!FileValidation.isImage(file.getOriginalFilename())) {
			throw new FileUploadException(1, "非图片文件，禁止上传");
		}
		if (file.isEmpty()) {
			throw new FileUploadException(1, "上传失败，文件为空");
		} else {
			String fileName = System.currentTimeMillis() + "";
			String filePath = PathUtils.getPath(ROOT, tId + "");
			String name = null;
			try {
				name = FileUpload.fileUp(file, filePath, fileName);
			} catch (IOException e) {
				throw new FileUploadException(1, "上传失败，文件出错");
			}
			Map<String, Object> data = new HashMap<>();
			data.put("path", PathUtils.getPath(tId + "", name));
			simpMessageSendingOperations.convertAndSendToUser("1", "/image", data);

			return ResultUtil.success("上传成功");
		}
	}

	// 显示图片的方法关键 匹配路径像 localhost:8080/b7c76eb3-5a67-4d41-ae5c-1642af3f8746.png
	/// {dir:[0-9]+}意思为dir路径为1到对个数字
	// 当使用@RequestMapping URI template 样式映射时， 即 someUrl/{paramId}, 这时的paramId可通过
	// @Pathvariable注解绑定它传过来的值到方法的参数上
	@RequestMapping(method = RequestMethod.GET, value = "/{dir:[0-9]+}/{filename:.+}")
	@ResponseBody
	public ResponseEntity<?> getFile(@PathVariable String filename, @PathVariable String dir) {

		try {
			return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, dir, filename).toString()));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
