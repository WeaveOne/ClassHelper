package cn.willvi.handle;

public class FileUploadException extends Exception {

	private Integer code;

	public FileUploadException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
