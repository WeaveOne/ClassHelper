package cn.willvi.dao.appTeacher;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("appTeacherDaoSupport")
public class AppTeacherDaoSupport implements AppTeacherDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	/*
	 * 根据t_id查询教师
	 */
	public Object findByTIdTname(String statement, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(statement, obj);
	}
	
	/*
	 * 创建二维码表
	 */
	public void createQrc(String statement, Object obj) throws Exception {
		sqlSessionTemplate.insert(statement, obj);
	}
	
	/*
	 * 创建签到表
	 */
	public void createSignIn(String statement, Object obj) throws Exception {
		sqlSessionTemplate.insert(statement, obj);
	}
}
