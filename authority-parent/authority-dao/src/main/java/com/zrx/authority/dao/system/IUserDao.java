/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.dao.system;

import com.zrx.authority.dao.IBaseDao;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,16:11:43
 * @version 1.0
 */
public interface IUserDao extends IBaseDao{
    public final String UserMapper_GetUserAndRoleById = "UserMapper.getUserAndRoleById";
    public final String UserMapper_GetUserInfoByUser = "UserMapper.getUserInfo";
    
}
