/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system;

import com.zrx.authority.domain.entity.system.Menu;
import com.zrx.authority.util.PageData;
import java.util.List;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:47:01
 * @version 1.0
 */
public interface IMenuService {
     public void deleteMenuById(String MENU_ID) throws Exception ;
     public PageData getMenuById(PageData pd) throws Exception ;
     public PageData findMaxId(PageData pd) throws Exception ;
     public List<Menu> listAllParentMenu() throws Exception ;
     public void saveMenu(Menu menu) throws Exception ;
     public List<Menu> listSubMenuByParentId(String parentId) throws Exception ;
     public List<Menu> listAllMenu() throws Exception ;
     public List<Menu> listAllSubMenu() throws Exception ;
     public PageData edit(PageData pd) throws Exception ;
     public PageData editicon(PageData pd) throws Exception ;
     public PageData editType(PageData pd) throws Exception ;
     
   
}
