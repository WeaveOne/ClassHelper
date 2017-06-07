package cn.willvi.util;

import cn.willvi.entity.Result;

/**
 * 返回结果处理
 * 
 * @author 维
 *
 */
public class ResultUtil {

	public static Result success(String msg, Object data) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	public static Result success() {
		return success("成功", null);
	}

	public static Result success(String msg) {
		return success(msg, null);
	}

	public static Result error(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	public static Result error(String msg) {
		return error(1, msg);
	}
}
