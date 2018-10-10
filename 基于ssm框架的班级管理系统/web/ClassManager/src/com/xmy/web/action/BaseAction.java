package com.xmy.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 非CRUD需求的父类
 *
 */
public abstract class BaseAction extends ActionSupport {
	// 重定向的视图名称
	public static final String RELOAD = "reload";
	
	// org.slf4j.Logger 面向接口编程，选择实现（选择都使用这个）
	protected Logger logger = LoggerFactory.getLogger(getClass());

	// 添加到map栈
	protected void putContext(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

}
