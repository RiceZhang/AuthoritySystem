/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.domain.entity.system;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,13:39:27
 * @version 1.0
 */
public class Menu implements Serializable{
    
    private static final long serialVersionUID = 1L;

    
    private String MENU_ID;//菜单Id唯一标识 
    private String MENU_NAME;
    private String MENU_URL;
    private String PARENT_ID;
    private String MENU_ORDER;
    private String MENU_ICON;
    private String MENU_TYPE;
    private String target;
    
    private Menu parentMenu;
    private List<Menu> subMenu;
    private boolean hasMenu = false;

    public String getMENU_ID() {
        return MENU_ID;
    }

    public void setMENU_ID(String MENU_ID) {
        this.MENU_ID = MENU_ID;
    }

    public String getMENU_NAME() {
        return MENU_NAME;
    }

    public void setMENU_NAME(String MENU_NAME) {
        this.MENU_NAME = MENU_NAME;
    }

    public String getMENU_URL() {
        return MENU_URL;
    }

    public void setMENU_URL(String MENU_URL) {
        this.MENU_URL = MENU_URL;
    }

    public String getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(String PARENT_ID) {
        this.PARENT_ID = PARENT_ID;
    }

    public String getMENU_ORDER() {
        return MENU_ORDER;
    }

    public void setMENU_ORDER(String MENU_ORDER) {
        this.MENU_ORDER = MENU_ORDER;
    }

    public String getMENU_ICON() {
        return MENU_ICON;
    }

    public void setMENU_ICON(String MENU_ICON) {
        this.MENU_ICON = MENU_ICON;
    }

    public String getMENU_TYPE() {
        return MENU_TYPE;
    }

    public void setMENU_TYPE(String MENU_TYPE) {
        this.MENU_TYPE = MENU_TYPE;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    public boolean isHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(boolean hasMenu) {
        this.hasMenu = hasMenu;
    }
    
    
    
    
}
