package cn.willvi.dao.appUser;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("appUserDaoSupport")
public class AppUserDaoSupport implements AppUserDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	/*
	 * 根据s_id查找对应学生
	 */
	public Object findBySId(String statement, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(statement, obj);
	}
	/*
	 * 添加学生用户
	 */
	public void addStu(String statement, Object obj) throws Exception {
		sqlSessionTemplate.insert(statement, obj);
	}

	/*
	 * 根据url和time查询二维码表
	 */
	public Object findByUrlTime(String statement, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(statement, obj);
	}
	
	/*
	 * 创建签到表
	 */
	public void createSignIn(String statement, Object obj) throws Exception {
		sqlSessionTemplate.insert(statement, obj);
	}
}
