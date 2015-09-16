/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.controller.system.user;

import com.zrx.authority.domain.entity.Page;
import com.zrx.authority.domain.entity.system.Menu;
import com.zrx.authority.domain.entity.system.Role;
import com.zrx.authority.service.system.IMenuService;
import com.zrx.authority.service.system.IRoleService;
import com.zrx.authority.service.system.IUserService;
import com.zrx.authority.util.Const;
import com.zrx.authority.util.PageData;
import com.zrx.authority.web.controller.base.BaseController;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-9-14,11:58:03
 * @version 1.0
 */

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController  {
	@Resource(name = "userService")
	private IUserService userService;
	@Resource(name = "roleService")
	private IRoleService roleService;
	@Resource(name = "menuService")
	private IMenuService menuService;
        
      	/**
	 * 显示用户列表(用户组)
	 */
	@RequestMapping(value = "/listUsers")
	public ModelAndView listUsers(Page page) throws Exception {
                ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		String USERNAME = pd.getString("USERNAME");

		if (null != USERNAME && !"".equals(USERNAME)) {
			USERNAME = USERNAME.trim();
			pd.put("USERNAME", USERNAME);
		}

		String lastLoginStart = pd.getString("lastLoginStart");
		String lastLoginEnd = pd.getString("lastLoginEnd");

		if (lastLoginStart != null && !"".equals(lastLoginStart)) {
			lastLoginStart = lastLoginStart + " 00:00:00";
			pd.put("lastLoginStart", lastLoginStart);
		}
		if (lastLoginEnd != null && !"".equals(lastLoginEnd)) {
			lastLoginEnd = lastLoginEnd + " 00:00:00";
			pd.put("lastLoginEnd", lastLoginEnd);
		}

		page.setPd(pd);
		List<PageData> userList = userService.listPdPageUser(page); //列出用户列表
		List<Role> roleList = roleService.listAllERRoles(); //列出所有二级角色

		/* 调用权限 */
		this.getHC(); //================================================================================
		/* 调用权限 */

		mv.setViewName("system/user/user_list");
		mv.addObject("userList", userList);
		mv.addObject("roleList", roleList);
		mv.addObject("pd", pd);

		return mv;
        }  
        
        
        
    /* ===============================权限================================== */
    public void getHC() {
        ModelAndView mv = this.getModelAndView();
        //shiro管理的session
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        Map<String, String> map = (Map<String, String>) session.getAttribute(Const.SESSION_QX);
        mv.addObject(Const.SESSION_QX, map); //按钮权限
        List<Menu> menuList = (List) session.getAttribute(Const.SESSION_menuList);
        mv.addObject(Const.SESSION_menuList, menuList);//菜单权限
    }
    /* ===============================权限================================== */
        
}
