package cn.willvi.service.appUser.impl;

import java.util.Date;

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

	/*
	 * 学生扫码登录并自动完成签到
	 */
	public String login(PageData pd) throws Exception {
		/*
		 * 判断该学生扫的二维码是不是当日当节课老师发布的二维码
		 * 是：完成签到并返回登陆成功信息
		 * 否：未完成签到并返回登陆失败信息
		 */
		if(appUserDao.findByUrl("appQrcMapper.findByUrl", pd) == null) {
			return "Login Failed";
		} else {
			try {
				Date time = new Date();
				pd.put("time", time);
				appUserDao.createSignIn("appSignInMapper.addSignIn", pd);
				return "Login Successful";
			} catch(Exception e) {
				return "Login Failed";
			}
		}
	}
}
