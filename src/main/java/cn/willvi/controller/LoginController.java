package cn.willvi.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.willvi.util.PageData;


@Controller
public class LoginController extends BaseController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd.put("name", "ww");
		mv.addObject("pd", pd);
		return mv;
	}
	
	
//	@RequestMapping("/hello")
//	public String hello(Map<String,Object> pd) {
//		pd.put("name", "ww");
//		return "hello";
//	}

	// 登录提交地址和applicationontext-shiro.xml配置的loginurl一致。 (配置文件方式的说法)
	@RequestMapping(value = "/login")
	public String login() throws Exception {
		
		return "login";
	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		// session.removeAttribute("user");
		return "login";
	}
}
