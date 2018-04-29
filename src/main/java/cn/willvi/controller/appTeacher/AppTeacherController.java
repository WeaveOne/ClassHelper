package cn.willvi.controller.appTeacher;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.willvi.controller.BaseController;
import cn.willvi.entity.ClassTable;
import cn.willvi.entity.Result;
import cn.willvi.entity.SignInTable;
import cn.willvi.service.appTeacher.AppTeacherManager;
import cn.willvi.util.PageData;
import cn.willvi.util.ResultUtil;

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
	
	/*
	 * 教师查看学生签到情况
	 * 前台传递过来的参数：url(老师当节课发布的二维码字符串)
	 * 发送给前台的json数据：id(学号) name(姓名) time(学生签到时间)
	 */
	@RequestMapping(value = "/check")
	@ResponseBody
	public List<SignInTable> check() throws Exception{
		PageData pd = this.getPageData();
		return appTeacherManager.check(pd);
	}
	
	/*
	 * 教师发布课程
	 * 前台传递过来的参数：url(二维码所对应的字符串)、t_id(教师工号)、time(教师发布二维码的时间),c_name（课程名称），c_address（课程地点）
	 * 发送给前台的String数据：Publish Successful/Publish Failed
	 */
	@RequestMapping(value = "/publishClass")
	@ResponseBody
	public String publishClass() throws Exception{
		PageData pd = this.getPageData();
		return appTeacherManager.publishClass(pd);
	}
	
	/*
	 * 教师查看发布课程情况
	 * 前台传递过来的参数：t_id
	 * 发送给前台的json数据：t_name(教师姓名) c_name(课程姓名) c_address(上课地点) time(发布时间)
	 */
	@RequestMapping(value = "/checkClass")
	@ResponseBody
	public List<ClassTable> checkClass() throws Exception{
		PageData pd = this.getPageData();
		return appTeacherManager.checkClass(pd);
	}
	
	/*
	 * 修改教师个人信息
	 * 前台传递过来的参数：t_id
	 * 
	 */
	@RequestMapping(value = "/updateInformation")
	@ResponseBody
	public Result updateInformation() throws Exception{
		PageData pd = this.getPageData();
		Object result = appTeacherManager.updateInformation(pd);
		if(result.equals("0")){
			return ResultUtil.error("数据异常");
		}else{
			return ResultUtil.success();
		}
	}
}
