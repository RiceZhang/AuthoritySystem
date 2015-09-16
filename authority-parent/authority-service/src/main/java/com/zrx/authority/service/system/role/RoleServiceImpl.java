/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system.role;

import com.zrx.authority.dao.IBaseDao;
import com.zrx.authority.domain.entity.system.Role;
import com.zrx.authority.service.system.IRoleService;
import com.zrx.authority.util.PageData;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:52:11
 * @version 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Resource(name = "baseDao")
    private IBaseDao dao;
    
    @Override
    public List<Role> listAllERRoles() throws Exception {
       return (List<Role>) dao.findForList("RoleMapper.listAllERRoles", null);
    }

    @Override
    public List<Role> listAllappERRoles() throws Exception {
      return (List<Role>) dao.findForList("RoleMapper.listAllappERRoles", null);
    }

    @Override
    public List<Role> listAllRoles() throws Exception {
       return (List<Role>) dao.findForList("RoleMapper.listAllRoles", null);
    }

    @Override  // 通过当前登录用的角色id获取管理权限数据
    public PageData findGLbyrid(PageData pd) throws Exception {
       return (PageData) dao.findForObject("RoleMapper.findGLbyrid", pd);
    }

    @Override  // 通过当前登录用的角色id获取用户权限数据
    public PageData findYHbyrid(PageData pd) throws Exception {
       return (PageData) dao.findForObject("RoleMapper.findYHbyrid", pd);
    }

    @Override  //列出此角色下的所有用户
    public List<PageData> listAllUByRid(PageData pd) throws Exception {
       return (List<PageData>) dao.findForList("RoleMapper.listAllUByRid", pd);
    }

    @Override // 列出此角色下的所有会员
    public List<PageData> listAllAppUByRid(PageData pd) throws Exception {
       return (List<PageData>) dao.findForList("RoleMapper.listAllAppUByRid", pd);
    }

    @Override // 列出此部门的所有下级
    public List<Role> listAllRolesByPId(PageData pd) throws Exception {
        return (List<Role>) dao.findForList("RoleMapper.listAllRolesByPId", pd);
    }

    @Override // //列出K权限表里的数据 
    public List<PageData> listAllkefu(PageData pd) throws Exception {
       return (List<PageData>) dao.findForList("RoleMapper.listAllkefu", pd);
    }

    @Override // //列出G权限表里的数据 
    public List<PageData> listAllGysQX(PageData pd) throws Exception {
       return (List<PageData>) dao.findForList("RoleMapper.listAllGysQX", pd);
    }

    @Override  //删除K权限表里对应的数据
    public void deleteKeFuById(String ROLE_ID) throws Exception {
        dao.delete("RoleMapper.deleteKeFuById", ROLE_ID);
    }

    @Override  // 删除G权限表里对应的数据
    public void deleteGById(String ROLE_ID) throws Exception {
        dao.delete("RoleMapper.deleteGById", ROLE_ID);
    }

    @Override
    public void deleteRoleById(String ROLE_ID) throws Exception {
       dao.delete("RoleMapper.deleteRoleById", ROLE_ID);
    }

    @Override
    public Role getRoleById(String roleId) throws Exception {
        return (Role) dao.findForObject("RoleMapper.getRoleById", roleId);
    }

    @Override
    public void updateRoleRights(Role role) throws Exception {
       dao.update("RoleMapper.updateRoleRights", role);
    }

    @Override
    public void updateQx(String msg, PageData pd) throws Exception {
        dao.update("RoleMapper." + msg, pd);
    }

    @Override
    public void updateKFQx(String msg, PageData pd) throws Exception {
        dao.update("RoleMapper." + msg, pd);
    }

    @Override
    public void gysqxc(String msg, PageData pd) throws Exception {
        dao.update("RoleMapper." + msg, pd);
    }

    @Override
    public void setAllRights(PageData pd) throws Exception {
         dao.update("RoleMapper.setAllRights", pd);
    }

    @Override
    public void add(PageData pd) throws Exception {
         dao.findForList("RoleMapper.insert", pd);
    }

    @Override
    public void saveKeFu(PageData pd) throws Exception {
        dao.findForList("RoleMapper.saveKeFu", pd);
    }

    @Override
    public void saveGYSQX(PageData pd) throws Exception {
        dao.findForList("RoleMapper.saveGYSQX", pd);
    }

    @Override
    public PageData findObjectById(PageData pd) throws Exception {
       return (PageData) dao.findForObject("RoleMapper.findObjectById", pd);
    }

    @Override
    public PageData edit(PageData pd) throws Exception {
        return (PageData) dao.findForObject("RoleMapper.edit", pd);
    }

}
