package cn.willvi.util;

/**
 * 路径处理工具类
 * 
 * @author 维
 *
 */
public class PathUtils {

	/**
	 * 处理路径 如：PathUtils.getPath("dir","abc")将返回 dir/abc/
	 * 
	 * @param first
	 *            必传参数
	 * @param args
	 *            可选参数
	 * @return
	 */
	public static String getPath(String first, String... args) {
		StringBuilder sb = new StringBuilder(first);
		for (String s : args) {
			sb.append("/");
			sb.append(s);
		}
		sb.append("/");
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getPath("dir", "test", "test"));
	}
}
