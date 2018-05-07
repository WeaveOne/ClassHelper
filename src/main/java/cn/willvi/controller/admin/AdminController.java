package cn.willvi.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.willvi.controller.BaseController;
import cn.willvi.service.admin.AdminManager;
import cn.willvi.util.PageData;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	@Resource(name = "adminService")
	AdminManager adminManager;

	@RequestMapping("/login")
	public String login() {
		return "admin/signin";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "admin/signin";
	}

	@RequestMapping("/check")
	public String check() {
		return "redirect:/admin/index";
	}

	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/index");
		mv.addObject("cnts", adminManager.getCnt());
		mv.addObject("data", adminManager.getData());
		return mv;
	}
	
	@RequestMapping("/teacher")
	public ModelAndView teacher() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/teacher");
		mv.addObject("data", adminManager.getTeacher());
		return mv;
	}
	@RequestMapping("/student/{page}")
	public ModelAndView student(@PathVariable int page) throws Exception {
		int first = (page-1)*10;
		PageData pd = new PageData();
		pd.put("first", first);
		PageData cnt = adminManager.getStudentCnt(pd);
		cnt.put("page", page);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/student");
		mv.addObject("data", adminManager.getStudent(pd));
		mv.addObject("cnt", cnt);
		return mv;
	}
	
	@RequestMapping("/file/{page}")
	public ModelAndView file(@PathVariable int page) throws Exception {
		int first = (page-1)*10;
		PageData pd = new PageData();
		pd.put("first", first);
		PageData cnt = adminManager.getFilesCnt(pd);
		cnt.put("page", page);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/file");
		mv.addObject("data", adminManager.getFiles(pd));
		mv.addObject("cnt", cnt);
		return mv;
	}
	
	@RequestMapping("/addTeacher")
	public String addTeacher() throws Exception {
		return "admin/add-teacher";
	}
	
	@RequestMapping("/teacherAdd")
	public String teacherAdd() throws Exception {
		PageData pd = getPageData();
		adminManager.addTeacher(pd);
		return "redirect:/admin/teacher";
	}
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher() throws Exception {
		PageData pd = getPageData();
		adminManager.deleteTeacher(pd);
		return "redirect:/admin/teacher";
	}
	@RequestMapping("/deleteStudent")
	public String deleteStudent() throws Exception {
		PageData pd = getPageData();
		adminManager.deleteStudent(pd);
		return "redirect:/admin/student/1";
	}
	@RequestMapping("/deleteFile")
	public String deleteFile() throws Exception {
		PageData pd = getPageData();
		adminManager.deleteFile(pd);
		return "redirect:/admin/file/1";
	}
}
