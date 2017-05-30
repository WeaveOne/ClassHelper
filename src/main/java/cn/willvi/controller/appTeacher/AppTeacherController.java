package cn.willvi.controller.appTeacher;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.willvi.controller.BaseController;
import cn.willvi.service.appTeacher.AppTeacherManager;
import cn.willvi.util.PageData;

@Controller
@RequestMapping("/app/teacher")
public class AppTeacherController extends BaseController{
	@Resource(name = "appTeacherService")
	private AppTeacherManager appTeacherManager;
	
	/*
	 * 教师登录
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login() throws Exception{
		PageData pd = this.getPageData();
		if(!pd.isEmpty() && pd.containsKey("t_id") && pd.containsKey("t_name")) {
			String t_id = pd.getString("t_id");
			if(t_id.length()<5 || t_id.length()>15 || !t_id.matches("[0-9]+")) {
				return "Login Failed";
			} else {
				return appTeacherManager.login(pd);
			}
		} else {
			return "Login Failed";
		}
	}
	
	/*
	 * 教师发布二维码
	 */
	@RequestMapping(value = "/publishQrc")
	@ResponseBody
	public String publishQrc() throws Exception{
		PageData pd = this.getPageData();
		return appTeacherManager.publishQrc(pd);
	}
}
