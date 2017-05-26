package cn.willvi.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.willvi.ClassHelperApplication;
import cn.willvi.dao.DaoSupport;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ClassHelperApplication.class})
public class ClassHelperApplicationTests {

	@Test
	public void contextLoads() {
	}
//
//	@Autowired
//	private WwMapper wwMapper;
//	@Test
//	public void testfindAll(){
//		wwMapper.findAll();
//	}
//	@Autowired
//	private DaoSupport daoSupport;
//	@Test
//	public void testfindAll() throws Exception{
//		daoSupport.save("WwMapper.findAll", "");
//	}
	
//	@Resource(name="userService")
//	UserService userService;
//	
//	@Test
//	public void testUserService(){
//		System.out.println(userService.test());
//	}
}
