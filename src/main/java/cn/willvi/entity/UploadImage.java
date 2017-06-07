package cn.willvi.entity;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片实体类
 * 
 * @author 维
 *
 */
public class UploadImage {

	/** 上传文件 **/
	@NotNull(message="文件不能为空")
	private MultipartFile file;
	/** 教师id **/
	@NotNull(message="教师id不能为空")
	private Integer id;
	/** 加密key **/
	@NotNull(message="加密key不能为空")
	private String key;
	/** 加密参数 **/
	@NotNull(message="加密参数不能为空")
	private String encryptionParameter;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getEncryptionParameter() {
		return encryptionParameter;
	}

	public void setEncryptionParameter(String encryptionParameter) {
		this.encryptionParameter = encryptionParameter;
	}

}
