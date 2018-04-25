package cn.willvi.dao.appTeacher;

import java.util.List;

import cn.willvi.entity.ClassTable;
import cn.willvi.entity.SignInTable;

public interface AppTeacherDao {
	/*
	 * 根据t_id查询教师
	 */
	public Object findByTIdTname(String statement, Object obj) throws Exception;
	
	/*
	 * 创建二维码表
	 */
	public void createQrc(String statement, Object obj) throws Exception;
	
	/*
	 * 创建签到表
	 */
	public void createSignIn(String statement, Object obj) throws Exception;
	
	/*
	 * 通过url查找学生签到情况
	 */
	public List<SignInTable> findByUrl(String statement, Object obj) throws Exception;
	
	/*
	 * 通过t_id查找教师发布课程情况
	 */
	public List<ClassTable> findByT_id(String statement, Object obj) throws Exception;
	
	/*
	 * 插入课程表
	 */
	public void createClass(String statement, Object obj) throws Exception;
	
}
