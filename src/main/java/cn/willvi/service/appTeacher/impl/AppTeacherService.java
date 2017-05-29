package cn.willvi.service.appTeacher.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.willvi.dao.appTeacher.AppTeacherDao;
import cn.willvi.service.appTeacher.AppTeacherManager;
import cn.willvi.util.PageData;

@Service("appTeacherService")
public class AppTeacherService implements AppTeacherManager {
	@Resource(name = "appTeacherDaoSupport")
	private AppTeacherDao appTeacherDao;
	/*
	 * 教师登录
	 */
	public String login(PageData pd) throws Exception {
		pd = (PageData) appTeacherDao.findByTIdPwd("appTeacherMapper.findByTIdPwd", pd);
		if(pd == null) {
			return "Login Failed";
		} else {
			return "Login Successful";
		}
	}

}
