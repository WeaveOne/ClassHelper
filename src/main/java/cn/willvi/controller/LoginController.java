package cn.willvi.controller;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.willvi.util.PageData;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd.put("name", "ww");
		mv.addObject("pd", pd);
		return mv;
	}

	// @RequestMapping("/hello")
	// public String hello(Map<String,Object> pd) {
	// pd.put("name", "ww");
	// return "hello";
	// }

	// 登录提交地址和applicationontext-shiro.xml配置的loginurl一致。 (配置文件方式的说法)
	@RequestMapping(value = "/index")
	public String index() throws Exception {

		return "login";
	}

	@RequestMapping(value = "/check")
	public String check(@RequestParam String t_id, @RequestParam String t_name,HttpSession session) throws Exception {
		UsernamePasswordToken token = new UsernamePasswordToken(t_id, t_name);
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			session.setAttribute("tId", t_id);
		} catch (Exception e) {
			return "login";
		}
		return "barrage";
	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		// session.removeAttribute("user");
		return "login";
	}
}
