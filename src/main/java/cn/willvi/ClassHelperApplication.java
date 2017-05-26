package cn.willvi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"cn.willvi"}) 
@EnableTransactionManagement
public class ClassHelperApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClassHelperApplication.class, args);
	}
}
