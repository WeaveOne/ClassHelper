package cn.willvi.dao.appUser;


public interface AppUserDao {
	/*
	 * 通过s_id查找对应学生
	 */
	public Object findBySId(String statement, Object obj) throws Exception;
	
	/*
	 * 添加学生用户
	 */
	public void addStu(String statement, Object obj) throws Exception;
	
	/*
	 * 根据url和time查询二维码表
	 */
	public Object findByUrlTime(String statement, Object obj) throws Exception;
	
	/*
	 * 创建签到表
	 */
	public void createSignIn(String statement, Object obj) throws Exception;
}
