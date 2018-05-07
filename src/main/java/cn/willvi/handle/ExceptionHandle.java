package cn.willvi.handle;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import ch.qos.logback.classic.Logger;
import cn.willvi.entity.Result;
import cn.willvi.util.LoggerHandler;
import cn.willvi.util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	Logger logger = (Logger) LoggerHandler.getLogger(ExceptionHandler.class);
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception ex) {
		/** 文件大小超过限制报异常 **/
		if(ex instanceof MultipartException) {
			return ResultUtil.error(100, "文件太大超过限制");
		}
		else if(ex instanceof FileUploadException) {
			return ResultUtil.error(((FileUploadException) ex).getCode(), ex.getMessage());
		}
		else if(ex instanceof MissingServletRequestParameterException) {
			return ResultUtil.error(404,"未正确传递参数");
		}
		else {
			logger.error(ex.getMessage());
			return ResultUtil.error(-1, "未知错误");
		}
		
	}
}
