/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system.menu;

import com.zrx.authority.dao.IBaseDao;
import com.zrx.authority.domain.entity.system.Menu;
import com.zrx.authority.service.system.IMenuService;
import com.zrx.authority.util.PageData;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:52:26
 * @version 1.0
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Resource(name = "baseDao")
    private IBaseDao dao;
    
    @Override
    public void deleteMenuById(String MENU_ID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PageData getMenuById(PageData pd) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PageData findMaxId(PageData pd) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Menu> listAllParentMenu() throws Exception {
        return (List<Menu>) dao.findForList("MenuMapper.listAllParentMenu", null);
    }

    @Override
    public void saveMenu(Menu menu) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Menu> listSubMenuByParentId(String parentId) throws Exception {
        return (List<Menu>) dao.findForList("MenuMapper.listSubMenuByParentId", parentId);
    }

    @Override
    public List<Menu> listAllMenu() throws Exception {
            List<Menu> rl = this.listAllParentMenu();
            for (Menu menu : rl) {
                    List<Menu> subList = this.listSubMenuByParentId(menu.getMENU_ID());
                    menu.setSubMenu(subList);
            }
            return rl;
    }

    @Override
    public List<Menu> listAllSubMenu() throws Exception {
        return (List<Menu>) dao.findForList("MenuMapper.listAllSubMenu", null);
    }

    @Override
    public PageData edit(PageData pd) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PageData editicon(PageData pd) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PageData editType(PageData pd) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
