/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system;

import com.zrx.authority.domain.entity.system.Role;
import com.zrx.authority.util.PageData;
import java.util.List;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:47:20
 * @version 1.0
 */
public interface IRoleService {
   public List<Role> listAllERRoles() throws Exception ;
   public List<Role> listAllappERRoles() throws Exception ;
   public List<Role> listAllRoles() throws Exception ;
   public PageData findGLbyrid(PageData pd) throws Exception ;
   public PageData findYHbyrid(PageData pd) throws Exception ;
   public List<PageData> listAllUByRid(PageData pd) throws Exception ;
   public List<PageData> listAllAppUByRid(PageData pd) throws Exception ;
   public List<Role> listAllRolesByPId(PageData pd) throws Exception ;
   public List<PageData> listAllkefu(PageData pd) throws Exception ;
   public List<PageData> listAllGysQX(PageData pd) throws Exception ;
   public void deleteKeFuById(String ROLE_ID) throws Exception ;
   public void deleteGById(String ROLE_ID) throws Exception ;
   public void deleteRoleById(String ROLE_ID) throws Exception ;
   public Role getRoleById(String roleId) throws Exception ;
   public void updateRoleRights(Role role) throws Exception ;
   public void updateQx(String msg, PageData pd) throws Exception ;
   public void updateKFQx(String msg, PageData pd) throws Exception ;
   public void gysqxc(String msg, PageData pd) throws Exception  ;
   public void setAllRights(PageData pd) throws Exception ;
   public void add(PageData pd) throws Exception ;
   public void saveKeFu(PageData pd) throws Exception ;
   public void saveGYSQX(PageData pd) throws Exception ;
   public PageData findObjectById(PageData pd) throws Exception ;
   public PageData edit(PageData pd) throws Exception ;
   
   
}
