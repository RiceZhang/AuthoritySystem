/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system;

import com.zrx.authority.dao.IBaseDao;
import com.zrx.authority.domain.entity.Page;
import com.zrx.authority.domain.entity.system.User;
import com.zrx.authority.util.PageData;
import java.util.List;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:47:40
 * @version 1.0
 */
public interface IUserService {
     public PageData findByUiId(PageData pd) throws Exception ;
     public PageData findByUId(PageData pd) throws Exception ;
     public PageData findByUE(PageData pd) throws Exception ;
     public PageData findByUN(PageData pd) throws Exception;
     public void saveU(PageData pd) throws Exception;
     public void editU(PageData pd) throws Exception ;
     public void setSKIN(PageData pd) throws Exception;
     public void deleteU(PageData pd) throws Exception ;
     public void deleteAllU(String[] USER_IDS) throws Exception ;
     public List<PageData> listPdPageUser(Page page) throws Exception ;
     public List<PageData> listAllUser(PageData pd) throws Exception ;
     public List<PageData> listGPdPageUser(Page page) throws Exception ;
     public void saveIP(PageData pd) throws Exception ;
     public PageData getUserByNameAndPwd(PageData pd) throws Exception ;
     public void updateLastLogin(PageData pd) throws Exception;
     public User getUserAndRoleById(String USER_ID) throws Exception ;
     
}
