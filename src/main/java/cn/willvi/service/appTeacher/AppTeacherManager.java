package cn.willvi.service.appTeacher;

import java.util.List;

import cn.willvi.entity.ClassTable;
import cn.willvi.entity.SignInTable;
import cn.willvi.util.PageData;

public interface AppTeacherManager {
	/*
	 * 教师登录
	 */
	public String login(PageData pd) throws Exception;
	
	/*
	 * 教师发布二维码
	 */
	public String publishQrc(PageData pd) throws Exception;
	
	/*
	 * 教师查看学生签到情况
	 */
	public List<SignInTable> check(PageData pd) throws Exception;
	
	/*
	 * 教师发布课程功能
	 */
	public String publishClass(PageData pd) throws Exception;
	
	/*
	 * 教师查看发布课程情况
	 */
	public List<ClassTable> checkClass(PageData pd) throws Exception;
}
