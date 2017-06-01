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
	 * 前台传递过来的参数：t_id(教师工号)和t_name(教师姓名)
	 * 发送给前台的String数据：Login Successful/Login Failed
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
	 * 前台传递过来的参数：url(二维码所对应的字符串)、t_id(教师工号)、time(教师发布二维码的时间)
	 * 发送给前台的String数据：Publish Successful/Publish Failed
	 */
	@RequestMapping(value = "/publishQrc")
	@ResponseBody
	public String publishQrc() throws Exception{
		PageData pd = this.getPageData();
		if(!pd.isEmpty() && pd.containsKey("t_id") && pd.containsKey("url") && pd.containsKey("time")) {
			String t_id = pd.getString("t_id");
			if(t_id.length()<5 || t_id.length()>15 || !t_id.matches("[0-9]+")) {
				return "Publish Failed";
			} else {
				return appTeacherManager.publishQrc(pd);
			}
		} else {
			return "Publish Failed";
		}
	}
}
