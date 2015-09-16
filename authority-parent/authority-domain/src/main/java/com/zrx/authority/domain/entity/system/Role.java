/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.domain.entity.system;

import java.io.Serializable;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,13:39:48
 * @version 1.0
 */
public class Role implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String ROLE_ID;//角色Id标识
    private String ROLE_NAME;//角色名
    private String RIGHTS;//权限
    private String PARENT_ID;//上层角色Id
    private String ADD_QX;//拥有  增  权限的标识
    private String DEL_QX;//拥有  删  权限的标识
    private String EDIT_QX;//拥有 改  权限的标识
    private String CHA_QX;//拥有  查  权限的标识
    private String QX_ID;//拥有    权限的标识

    public String getROLE_ID() {
        return ROLE_ID;
    }

    public void setROLE_ID(String ROLE_ID) {
        this.ROLE_ID = ROLE_ID;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }

    public String getRIGHTS() {
        return RIGHTS;
    }

    public void setRIGHTS(String RIGHTS) {
        this.RIGHTS = RIGHTS;
    }

    public String getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(String PARENT_ID) {
        this.PARENT_ID = PARENT_ID;
    }

    public String getADD_QX() {
        return ADD_QX;
    }

    public void setADD_QX(String ADD_QX) {
        this.ADD_QX = ADD_QX;
    }

    public String getDEL_QX() {
        return DEL_QX;
    }

    public void setDEL_QX(String DEL_QX) {
        this.DEL_QX = DEL_QX;
    }

    public String getEDIT_QX() {
        return EDIT_QX;
    }

    public void setEDIT_QX(String EDIT_QX) {
        this.EDIT_QX = EDIT_QX;
    }

    public String getCHA_QX() {
        return CHA_QX;
    }

    public void setCHA_QX(String CHA_QX) {
        this.CHA_QX = CHA_QX;
    }

    public String getQX_ID() {
        return QX_ID;
    }

    public void setQX_ID(String QX_ID) {
        this.QX_ID = QX_ID;
    }
      
      
      
}
