package cn.willvi.util;

public class KeyValidation {

	private static final String CONFUSIONCODE = "ww";
	/**
	 * 检验key是否符合规定（加密规则：加密参数+当前日期+混淆码）
	 * @param key   客户端上传的key参数
	 * @param encryptionParameter
	 * 			加密的请求参数（如：username，password等）
	 * @param confusionCode
	 * 			混淆码
	 * @return
	 */
	public static boolean isCrrect(String key, String encryptionParameter, String confusionCode) {
		String mKey = MD5.md5(encryptionParameter + DateUtil.getDay() + confusionCode);
		if(mKey.equals(key)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 检验key是否符合规定（加密规则：加密参数+当前日期+混淆码:默认ww）
	 * @param key   客户端上传的key参数
	 * @param encryptionParameter
	 * 			加密的请求参数（如：username，password等）
	 * @return
	 */
	public static boolean isCrrect(String key, String encryptionParameter) {
		String mKey = MD5.md5(encryptionParameter + DateUtil.getDay() + CONFUSIONCODE);
		if(mKey.equals(key)) {
			return true;
		}
		return false;
	}
}
