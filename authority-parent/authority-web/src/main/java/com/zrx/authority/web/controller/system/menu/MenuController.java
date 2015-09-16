/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.controller.system.menu;

import com.zrx.authority.domain.entity.system.Menu;
import com.zrx.authority.service.system.IMenuService;
import com.zrx.authority.web.controller.base.BaseController;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-9-5,21:53:11
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {
    
  	@Resource(name = "menuService")
	private IMenuService  menuService;
       
    /**
     * 显示菜单列表
     *
     * @param model
     * @return
     */
    @RequestMapping
    public ModelAndView list() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            List<Menu> menuList = menuService.listAllParentMenu();
            mv.addObject("menuList", menuList);
            mv.setViewName("system/menu/menu_list");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }

        return mv;
    }
        
}
