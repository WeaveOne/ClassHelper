package cn.willvi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 设置首页
 * 
 * @author 维
 *
 */
@Configuration
public class MyAdapter extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/barrage/index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// 多个拦截器组成一个拦截器链
//		// addPathPatterns 用于添加拦截规则
//		// excludePathPatterns 用户排除拦截
//		registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**");
//		super.addInterceptors(registry);
//	}
}
