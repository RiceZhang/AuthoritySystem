/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system.user;

import com.zrx.authority.dao.IBaseDao;
import com.zrx.authority.dao.basedao.BaseDaoImpl;
import com.zrx.authority.dao.system.IUserDao;
import com.zrx.authority.domain.entity.Page;
import com.zrx.authority.domain.entity.system.User;
import com.zrx.authority.service.system.IUserService;
import com.zrx.authority.util.PageData;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:51:54
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "baseDao")
    private IBaseDao dao;
    
    @Override
    public PageData findByUiId(PageData pd) throws Exception {
         return (PageData) dao.findForObject("UserXMapper.findByUiId", pd);
    }

    @Override
    public PageData findByUId(PageData pd) throws Exception {
       return (PageData) dao.findForObject("UserXMapper.findByUId", pd);
    }

    @Override
    public PageData findByUE(PageData pd) throws Exception {
        return (PageData) dao.findForObject("UserXMapper.findByUE", pd);
    }

    @Override
    public PageData findByUN(PageData pd) throws Exception {
        return (PageData) dao.findForObject("UserXMapper.findByUN", pd);
    }

    @Override
    public void saveU(PageData pd) throws Exception {
        dao.save("UserXMapper.saveU", pd);
    }

    @Override
    public void editU(PageData pd) throws Exception {
         dao.update("UserXMapper.editU", pd);
    }

    @Override
    public void setSKIN(PageData pd) throws Exception {
         dao.update("UserXMapper.setSKIN", pd);
    }

    @Override
    public void deleteU(PageData pd) throws Exception {
         dao.delete("UserXMapper.deleteU", pd);
    }

    @Override
    public void deleteAllU(String[] USER_IDS) throws Exception {
         dao.delete("UserXMapper.deleteAllU", USER_IDS);
    }

    @Override
    public List<PageData> listPdPageUser(Page page) throws Exception {
         return (List<PageData>) dao.findForList("UserXMapper.userlistPage", page);
    }

    @Override
    public List<PageData> listAllUser(PageData pd) throws Exception {
         return (List<PageData>) dao.findForList("UserXMapper.listAllUser", pd);
    }

    @Override
    public List<PageData> listGPdPageUser(Page page) throws Exception {
         return (List<PageData>) dao.findForList("UserXMapper.userGlistPage", page);
    }

    @Override
    public void saveIP(PageData pd) throws Exception {
       dao.update("UserXMapper.saveIP", pd);
    }

    @Override
    public PageData getUserByNameAndPwd(PageData pd) throws Exception {
       return (PageData) dao.findForObject("UserXMapper.getUserInfo", pd);
    }

    @Override
    public void updateLastLogin(PageData pd) throws Exception {
        dao.update("UserXMapper.updateLastLogin", pd);
    }

    @Override
    public User getUserAndRoleById(String USER_ID) throws Exception {
	return (User) dao.findForObject("UserMapper.getUserAndRoleById", USER_ID);
    }


}
