package cn.willvi.service.appUser.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.willvi.dao.appUser.AppUserDao;
import cn.willvi.service.appUser.AppUserManager;
import cn.willvi.util.PageData;

@Service("appUserService")
public class AppUserService implements AppUserManager {
	@Resource(name = "appUserDaoSupport")
	private AppUserDao appUserDao;

	/*
	 * 学生用户注册
	 */
	public PageData Regist(PageData pd) throws Exception {
		PageData stu = (PageData) appUserDao.findBySId("appUserMapper.findBySId", pd);
		if(stu.isEmpty()) {
			appUserDao.addStu("appUserMapper.addStu", pd);
			pd.clear();
			pd.put("status", "Registered Successfully!");
			return pd;
		} else {
			pd.clear();
			pd.put("status", "The user is registered!");
			return pd;
		}
	}
}
