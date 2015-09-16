/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zrx.authority.web.controller.system.login;

import com.zrx.authority.domain.entity.system.Menu;
import com.zrx.authority.domain.entity.system.Role;
import com.zrx.authority.domain.entity.system.User;
import com.zrx.authority.service.system.IMenuService;
import com.zrx.authority.service.system.IRoleService;
import com.zrx.authority.service.system.IUserService;
import com.zrx.authority.util.AppUtil;
import com.zrx.authority.util.Const;
import com.zrx.authority.util.DateUtil;
import com.zrx.authority.util.PageData;
import com.zrx.authority.util.RightsHelper;
import com.zrx.authority.util.Tools;
import com.zrx.authority.web.controller.base.BaseController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * Description :</p>
 * <p>
 * Title :</p>
 *
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-28,17:28:45
 * @version 1.0
 */
@Controller
public class LoginController extends BaseController {

    //@Resource 注入先按类型匹配

    @Resource(name = "userService")
    private IUserService userService;
    @Resource(name = "menuService")
    private IMenuService menuService;
    @Resource(name = "roleService")
    private IRoleService roleService;

    	/**
	 * 获取登录用户的IP
	 * 
	 * @throws Exception
	 */
	public void getRemortIP(String USERNAME) throws Exception {
		PageData pd = new PageData();
		HttpServletRequest request = this.getRequest();
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		pd.put("USERNAME", USERNAME);
		pd.put("IP", ip);
		userService.saveIP(pd);
	}
        
    /**
     * 去登录页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login_toLogin")
    public ModelAndView toLogin() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        pd.put("SYSNAME", "ACE"); //读取系统名称
        mv.setViewName("system/admin/login");
        mv.addObject("pd", pd);
        return mv;
    }

    /**
     * 请求登录，验证用户
     *
     * @throws java.lang.Exception
     */
    @RequestMapping(value = "/login_login")
    @ResponseBody
    public Object login() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        PageData pd = new PageData();
        pd = this.getPageData();
        String errInfo = "";
        String KEYDATA[] = pd.getString("KEYDATA").replaceAll("qq12345678fh", "").replaceAll("QQ98765423fh", "").split(",fh,");

        if (null != KEYDATA && KEYDATA.length == 3) {
            //shiro管理的session
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            String sessionCode = (String) session.getAttribute(Const.SESSION_SECURITY_CODE); //获取session中的验证码

            String code = KEYDATA[2];
            //后端验证
            if (null == code || "".equals(code)) {
                errInfo = "nullcode"; //验证码为空
            } else {
                String USERNAME = KEYDATA[0];
                String PASSWORD = KEYDATA[1];

                if (Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
                    String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString(); //密码加密
                    pd.put("PASSWORD", passwd);
                    pd.put("USERNAME", USERNAME);
                    pd = userService.getUserByNameAndPwd(pd);

                    if (pd != null) {
                        pd.put("LAST_LOGIN", DateUtil.getTime().toString());
                        userService.updateLastLogin(pd);
                        User user = new User();
                        user.setUSER_ID(pd.getString("USER_ID"));
                        user.setUSERNAME(pd.getString("USERNAME"));
                        user.setPASSWORD(pd.getString("PASSWORD"));
                        user.setNAME(pd.getString("NAME"));
                        user.setRIGHTS(pd.getString("RIGHTS"));
                        user.setROLE_ID(pd.getString("ROLE_ID"));
                        user.setLAST_LOGIN(pd.getString("LAST_LOGIN"));
                        user.setIP(pd.getString("IP"));
                        user.setSTATUS(pd.getString("STATUS"));

                        session.setAttribute(Const.SESSION_USER, user);
                        session.removeAttribute(Const.SESSION_SECURITY_CODE);

                        //shiro加入身份验证
                        Subject subject = SecurityUtils.getSubject();
                        UsernamePasswordToken token = new UsernamePasswordToken(USERNAME, PASSWORD);//authc
                        try {
                            subject.login(token);//授权登录
                        } catch (AuthenticationException e) {
                            errInfo = "身份验证失败！";
                        }
                    } else {
                        errInfo = "usererror";//用户名或密码有误
                    }
                } else {
                    errInfo = "codeerror"; //验证码输入有误
                }

                if (Tools.isEmpty(errInfo)) {
                    errInfo = "success"; //验证成功
                }
            }

        } else {
            errInfo = "error"; //缺少参数
        }

        map.put("result", errInfo);
        System.out.println("输出...." + errInfo);
        return AppUtil.returnObject(new PageData(), map);//直接返回 map
        //return map;
    }

    /**
     * 访问系统首页
     */
    @RequestMapping(value = "/login_index")
    public ModelAndView login_index() {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try {
            //shiro管理的session
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();

            User user = (User) session.getAttribute(Const.SESSION_USER);

            if (user != null) {
                User userr = (User) session.getAttribute(Const.SESSION_USERROL);
                if (null == userr) {
                    user = userService.getUserAndRoleById(user.getUSER_ID());//更具ID获取用户角色
                    session.setAttribute(Const.SESSION_USERROL, user);
                } else {
                    user = userr;
                }
                Role role = user.getRole();
                String roleRights = role != null ? role.getRIGHTS() : "";
                //避免每次拦截用户操作时查询数据库，以下将用户所属角色权限、用户权限限都存入session
                session.setAttribute(Const.SESSION_ROLE_RIGHTS, roleRights); //将角色权限存入session
                session.setAttribute(Const.SESSION_USERNAME, user.getUSERNAME()); //放入用户名

                List<Menu> allmenuList = new ArrayList<Menu>();
                if (null == session.getAttribute(Const.SESSION_allmenuList)) {
                    allmenuList = menuService.listAllMenu();//向业务层，要全部菜单信息
                    if (Tools.notEmpty(roleRights)) {
                        for (Menu menu : allmenuList) {
                            menu.setHasMenu(RightsHelper.testRights(roleRights, menu.getMENU_ID()));//权限分配算法
                            if (menu.isHasMenu()) {
                                List<Menu> subMenuList = menu.getSubMenu();
                                for (Menu sub : subMenuList) {
                                    sub.setHasMenu(RightsHelper.testRights(roleRights, sub.getMENU_ID()));
                                }
                            }
                        }
                    }
                    session.setAttribute(Const.SESSION_allmenuList, allmenuList); //菜单权限放入session中

                } else {
                    allmenuList = (List<Menu>) session.getAttribute(Const.SESSION_allmenuList);
                }
                //切换菜单=====
                List<Menu> menuList = new ArrayList<Menu>();
                if (null == session.getAttribute(Const.SESSION_menuList) || ("yes".equals(pd.getString("changeMenu")))) {
                    List<Menu> menuList1 = new ArrayList<Menu>();
                    List<Menu> menuList2 = new ArrayList<Menu>();
                    
                    //拆分菜单
                    for (int i = 0; i < allmenuList.size(); i++) {
                      Menu menu = allmenuList.get(i);
                        if ("2".equals(menu.getMENU_TYPE())) {
                           menuList1.add(menu);
                        } else {
                            menuList2.add(menu);
                        }
                    }
                    
                    session.removeAttribute(Const.SESSION_menuList);
                    if ("1".equals(session.getAttribute("changeMenu"))) {
                        session.setAttribute(Const.SESSION_menuList, menuList1);
                        session.removeAttribute("changeMenu");
                        session.setAttribute("changeMenu", "2");
                        menuList = menuList1;
                    } else {
                        session.setAttribute(Const.SESSION_menuList, menuList2);
                        session.removeAttribute("changeMenu");
                        session.setAttribute("changeMenu", "2");
                        menuList = menuList2;
                    }
                } else {
                    menuList = (List<Menu>) session.getAttribute(Const.SESSION_menuList);
                }
                
                //切换菜单=====
                if (null == session.getAttribute(Const.SESSION_QX)) {
                    session.setAttribute(Const.SESSION_QX, this.getUQX(session)); //按钮权限放到session中
                }
                
                
                mv.setViewName("system/admin/index");
                mv.addObject("user", user);
                mv.addObject("menuList", menuList);//将在左栏菜单中实现展示；
            } else {
                System.out.println("=== login_index  user=null  登陆过滤  ===");
                mv.setViewName("system/admin/login");//session失效后跳转登录页面
            }

        } catch (Exception e) {
            mv.setViewName("system/admin/login");
            logger.error(e.getMessage(), e);
        }

        System.out.println("===  login_index ===");

        pd.put("SYSNAME", "FH"); //读取系统名称
        mv.addObject("pd", pd);
        return mv;
    }

    /**
     * 进入tab标签
     *
     * @return
     */
    @RequestMapping(value = "/tab")
    public String tab() {
        return "system/admin/tab";
    }

    @RequestMapping(value = "/login_default")
    public String defaultPage() {
        return "system/admin/default";
    }

    /**
     * 获取用户权限
     */
    public Map<String, String> getUQX(Session session) {
        PageData pd = new PageData();
        Map<String, String> map = new HashMap<String, String>();
        try {
            String USERNAME = session.getAttribute(Const.SESSION_USERNAME).toString();
            pd.put(Const.SESSION_USERNAME, USERNAME);
            String ROLE_ID = userService.findByUId(pd).get("ROLE_ID").toString();

            pd.put("ROLE_ID", ROLE_ID);

            PageData pd2 = new PageData();
            pd2.put(Const.SESSION_USERNAME, USERNAME);
            pd2.put("ROLE_ID", ROLE_ID);

            pd = roleService.findObjectById(pd);

            pd2 = roleService.findGLbyrid(pd2);
            if (null != pd2) {
                map.put("FX_QX", pd2.get("FX_QX").toString());
                map.put("FW_QX", pd2.get("FW_QX").toString());
                map.put("QX1", pd2.get("QX1").toString());
                map.put("QX2", pd2.get("QX2").toString());
                map.put("QX3", pd2.get("QX3").toString());
                map.put("QX4", pd2.get("QX4").toString());

                pd2.put("ROLE_ID", ROLE_ID);
                pd2 = roleService.findYHbyrid(pd2);
                map.put("C1", pd2.get("C1").toString());
                map.put("C2", pd2.get("C2").toString());
                map.put("C3", pd2.get("C3").toString());
                map.put("C4", pd2.get("C4").toString());
                map.put("Q1", pd2.get("Q1").toString());
                map.put("Q2", pd2.get("Q2").toString());
                map.put("Q3", pd2.get("Q3").toString());
                map.put("Q4", pd2.get("Q4").toString());
            }

            map.put("adds", pd.getString("ADD_QX"));
            map.put("dels", pd.getString("DEL_QX"));
            map.put("edits", pd.getString("EDIT_QX"));
            map.put("chas", pd.getString("CHA_QX"));

			//System.out.println(map);
            this.getRemortIP(USERNAME);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return map;
    }
    
}
