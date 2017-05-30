package cn.willvi.service.appUser;

import cn.willvi.util.PageData;

public interface AppUserManager {
	/*
	 * 学生用户注册
	 */
	public String Regist(PageData pd) throws Exception;
	
	/*
	 * 学生用户查询
	 */
	public PageData findBySId(PageData pd) throws Exception;
	
	/*
	 * 学生扫码登录并自动完成签到
	 */
	public String login(PageData pd) throws Exception;
}
