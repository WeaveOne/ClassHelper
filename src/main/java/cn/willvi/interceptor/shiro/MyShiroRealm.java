package cn.willvi.interceptor.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.willvi.service.appTeacher.AppTeacherManager;
import cn.willvi.util.PageData;

/**
 * 身份校验核心类;
 * 
 * @version v.0.1
 */
public class MyShiroRealm extends AuthorizingRealm {

	@Resource(name = "appTeacherService")
	private AppTeacherManager appTeacherManager;

	/*
	 * 登录信息和用户验证信息验证(non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.
	 * apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String id = (String) token.getPrincipal(); // 得到用户名
		String name = new String((char[]) token.getCredentials()); // 得到密码
		PageData pd = new PageData();
		pd.put("t_id", id);
		pd.put("t_name", name);
		String result = "";
		try {
			result = appTeacherManager.login(pd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.equals("Login Failed") || result == "") {
			return null;
		}
		return new SimpleAuthenticationInfo(id, name, getName());

	}

	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("========2");
		return null;
	}

}
