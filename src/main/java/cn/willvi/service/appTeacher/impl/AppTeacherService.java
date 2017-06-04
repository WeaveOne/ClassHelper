package cn.willvi.service.appTeacher.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.willvi.dao.appTeacher.AppTeacherDao;
import cn.willvi.entity.SignInTable;
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
		pd = (PageData) appTeacherDao.findByTIdTname("appTeacherMapper.findByTIdTname", pd);
		if(pd == null) {
			return "Login Failed";
		} else {
			return "Login Successful";
		}
	}
	
	/*
	 * 教师发布二维码
	 */
	public String publishQrc(PageData pd) throws Exception {
		try { 
			appTeacherDao.createQrc("appQrcMapper.addQrc", pd);
			appTeacherDao.createSignIn("appSignInMapper.addTSignIn", pd);
			return "Publish Successful";
		} catch(Exception e) {
			return "Publish Failed";
		}
	}
	
	/*
	 * 教师查看学生签到情况
	 */
	public List<SignInTable> check(PageData pd) throws Exception {
		return appTeacherDao.findByUrl("appTeacherMapper.findByUrl", pd);
	}
}
