package cn.willvi.service.appUser;

import cn.willvi.util.PageData;

public interface AppUserManager {
	/*
	 * 学生用户注册
	 */
	public PageData Regist(PageData pd) throws Exception;
	/*
	 * 学生用户查询
	 */
	public PageData findBySId(PageData pd) throws Exception;
}
