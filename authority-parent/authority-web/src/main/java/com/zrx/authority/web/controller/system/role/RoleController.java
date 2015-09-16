/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.controller.system.role;

import com.zrx.authority.domain.entity.Page;
import com.zrx.authority.domain.entity.system.Menu;
import com.zrx.authority.domain.entity.system.Role;
import com.zrx.authority.service.system.IMenuService;
import com.zrx.authority.service.system.IRoleService;
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
 * @data 2015-9-5,21:52:41
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {
    
   @Resource(name = "menuService")
   private IMenuService menuService;
   @Resource(name = "roleService")
   private IRoleService roleService;
   
    /**
     * 列表
     */
    @RequestMapping
    public ModelAndView list(Page page) throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();

        String roleId = pd.getString("ROLE_ID");
        if (roleId == null || "".equals(roleId)) {
            pd.put("ROLE_ID", "1");
        }
        List<Role> roleList = roleService.listAllRoles(); //列出所有部门
        List<Role> roleList_z = roleService.listAllRolesByPId(pd); //列出此部门的所有下级

        List<PageData> kefuqxlist = roleService.listAllkefu(pd); //管理权限列表
        List<PageData> gysqxlist = roleService.listAllGysQX(pd); //用户权限列表

        /* 调用权限 */
        this.getHC(); //================================================================================
		/* 调用权限 */

        pd = roleService.findObjectById(pd); //取得点击部门

        mv.addObject("pd", pd);
        mv.addObject("kefuqxlist", kefuqxlist);
        mv.addObject("gysqxlist", gysqxlist);
        mv.addObject("roleList", roleList);
        mv.addObject("roleList_z", roleList_z);
        mv.setViewName("system/role/role_list");

        return mv;
    }
   
    
    /* ===============================权限================================== */
    public void getHC() {
        ModelAndView mv = this.getModelAndView();
        //shiro管理的session
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute(Const.SESSION_QX);
        mv.addObject(Const.SESSION_QX, map); //按钮权限
        List<Menu> menuList = (List) session.getAttribute(Const.SESSION_menuList);
        mv.addObject(Const.SESSION_menuList, menuList);//菜单权限
    }
    /* ===============================权限================================== */
}
