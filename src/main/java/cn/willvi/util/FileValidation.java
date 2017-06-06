package cn.willvi.util;

/**
 * 文件校验类
 * @author 维
 *
 */
public class FileValidation {

	public static boolean isImage(String imgName) {
		String[] types = new String[] { ".jpg", ".png", ".jpeg", ".bmp" };
		String suffix = imgName.substring(imgName.indexOf("."));
		if (!suffix.isEmpty()) {
			for (int i = 0; i < types.length; i++) {
				String type = types[i];
				if (type.equalsIgnoreCase(suffix)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
}
