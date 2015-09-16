/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.util;

import org.springframework.context.ApplicationContext;

/**
 * <p>Description : 定义系统常量 </p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,13:09:03
 * @version 1.0
 */
public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";

	public static final String SESSION_menuList = "menuList"; //当前菜单
	public static final String SESSION_allmenuList = "allmenuList"; //全部菜单

	public static final String SESSION_QX = "QX";
	public static final String SESSION_userpds = "userpds";

	public static final String SESSION_USERROL = "USERROL"; //用户对象
	public static final String SESSION_USERNAME = "USERNAME"; //用户名

	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/login_toLogin.do"; //登录地址

	public static final String SYSNAME = "admin/config/SYSNAME.txt"; //系统名称路径
	public static final String PAGE = "admin/config/PAGE.txt"; //分页条数配置路径
	public static final String EMAIL = "admin/config/EMAIL.txt"; //邮箱服务器配置路径
	public static final String SMS1 = "admin/config/SMS1.txt"; //短信账户配置路径1
	public static final String SMS2 = "admin/config/SMS2.txt"; //短信账户配置路径2

	public static final String FILEPATHIMG = "uploadFiles/uploadImgs/"; //图片上传路径
	public static final String FILEPATHFILE = "uploadFiles/file/"; //文件上传路径

	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(websocket)).*"; //不对匹配该值的访问路径拦截（正则）
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化

	/**
	 * APP Constants
	 */
	//app注册接口_请求协议参数)
	public static final String[] APP_REGISTERED_PARAM_ARRAY = new String[] { "countries", "uname", "passwd", "title", "full_name", "company_name", "countries_code", "area_code", "telephone", "mobile" };
	public static final String[] APP_REGISTERED_VALUE_ARRAY = new String[] { "国籍", "邮箱帐号", "密码", "称谓", "名称", "公司名称", "国家编号", "区号", "电话", "手机号" };

	//app登录接口_请求协议中的参数
	public static final String[] APP_LOGIN_PARAM_ARRAY = new String[] { "uname", "passwd" };
	public static final String[] APP_LOGIN_VALUE_ARRAY = new String[] { "邮箱账号", "密码" };

	//app登录状态接口_请求协议中的参数
	public static final String[] APP_LOGINSTATUS_PARAM_ARRAY = new String[] { "app_id", "status" };
	public static final String[] APP_LOGINSTATUS_VALUE_ARRAY = new String[] { "app登录用户ID", "登录状态" };

	//忘记密码,查找用户账户是否存在接口_请求协议中的参数
	public static final String[] APP_FORGOTPASSWORD_PARAM_ARRAY = new String[] { "uname" };
	public static final String[] APP_FORGOTPASSWORD_VALUE_ARRAY = new String[] { "邮箱账号" };
     
}
