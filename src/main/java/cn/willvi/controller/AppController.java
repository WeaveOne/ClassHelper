package cn.willvi.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.willvi.entity.Ww;
import cn.willvi.util.PageData;


@Controller
public class AppController extends BaseController{
	
	@RequestMapping(value = "/appTest") 
	@ResponseBody
	public Map<String,Object> returnApp(){  
		PageData pd = new PageData();
		pd = this.getPageData();
		System.out.println(pd);
		return pd;
	}
}
