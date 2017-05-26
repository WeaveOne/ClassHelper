package cn.willvi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志处理
 * @author 维
 *
 */
public class LoggerHandler {

	private   Logger logger;
	
	/**
	 * 构造方法，初始化slf4j的日志对象
	 */
	private LoggerHandler(Logger slf4jLogger) {
		logger = slf4jLogger;
	}
	
	/**
	 * 获取构造器根据类名初始化Logger对象
	 * @param classObject
	 * @return
	 */
	public static Logger getLogger(Class classObject){
		return LoggerFactory.getLogger(classObject);
	}
	
	public void debug(String str){
		logger.debug(str);
	}
	
	public void debug(String str, Throwable e){
		logger.debug(str, e);
	}
	
	public void info(String str) {
		logger.info(str);
	}

	public void info(String str, Throwable e) {
		logger.info(str, e);
	}

	public void warn(String str) {
		logger.warn(str);
	}

	public void warn(String str, Throwable e) {
		logger.warn(str, e);
	}

	public void error(String str) {
		logger.error(str);
	}

	public void error(String str, Throwable e) {
		logger.error(str, e);
	}


	public String getName() {
		return logger.getName();
	}

	public Logger getLogger() {
		return logger;
	}

	
	
}
