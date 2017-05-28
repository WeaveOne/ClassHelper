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
	 * 学生用户查询
	 */
	public PageData findBySId(PageData pd) throws Exception {
		return (PageData) appUserDao.findBySId("appUserMapper.findBySId", pd);
	}
	/*
	 * 学生用户注册
	 */
	public String Regist(PageData pd) throws Exception {
		PageData stu = (PageData) appUserDao.findBySId("appUserMapper.findBySId", pd);
		if(stu == null) {
			appUserDao.addStu("appUserMapper.addStu", pd);
			return "Registration Successful";
		} else {
			return "Registration Failed";
		}
	}
}
