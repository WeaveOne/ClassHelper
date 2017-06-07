package cn.willvi.enums;


public enum ResultEnum {
	UNKONW_ERROR(-1,"未知错误"),
	FILE_UPLODE_SUCCESS(0,"成功"),
	FILE_TYPE_ERROR(1,"文件类型错误"),
	FILE_EMPTY(2,"文件为空"),
	FILE_ERROR(3,"文件处理出错")
	;
	private Integer code;
	
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
