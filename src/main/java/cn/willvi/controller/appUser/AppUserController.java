package cn.willvi.controller.appUser;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.willvi.controller.BaseController;
import cn.willvi.service.appUser.AppUserManager;
import cn.willvi.util.PageData;

@Controller
@RequestMapping(value = "/app")
public class AppUserController extends BaseController{
	@Resource(name = "appUserService")
	private AppUserManager appUserManager;

	/*
	 * 用户注册
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/regist")
	@ResponseBody
	public Map<String, Object> regist() throws Exception{
		PageData pd = this.getPageData();
		if(!pd.isEmpty() && pd.containsKey("s_id") && pd.containsKey("s_name")) {
			String s_id = pd.getString("s_id");
			if(s_id.length()<8 || s_id.length()>15) {
				pd.put("status", "Illegal student id!");
				return pd;
			} else {
				appUserManager.Regist(pd);
				return pd;
			}
		} else {
			pd.put("status", "Parameter is not complete!");
			return pd;
		}
	}
}
