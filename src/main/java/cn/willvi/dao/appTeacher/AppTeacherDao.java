package cn.willvi.dao.appTeacher;


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
}
