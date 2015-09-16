/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system.appuser;

import com.zrx.authority.dao.IBaseDao;
import com.zrx.authority.domain.entity.Page;
import com.zrx.authority.service.system.IAppuserService;
import com.zrx.authority.util.PageData;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:36:47
 * @version 1.0
 */
@Service("appuserService")
public class AppuserServiceImpl implements IAppuserService{

    @Resource(name = "baseDao")
    private IBaseDao dao;
    
    @Override
    public PageData findByUiId(PageData pd) throws Exception {
       return (PageData) dao.findForObject("AppuserMapper.findByUiId", pd);
    }

    @Override
    public PageData findByUId(PageData pd) throws Exception {
        return (PageData) dao.findForObject("AppuserMapper.findByUId", pd);
    }

    @Override
    public PageData findByUE(PageData pd) throws Exception {
       return (PageData) dao.findForObject("AppuserMapper.findByUE", pd);
    }

    @Override
    public PageData findByUN(PageData pd) throws Exception {
       return (PageData) dao.findForObject("AppuserMapper.findByUN", pd);
    }

    @Override
    public void saveU(PageData pd) throws Exception {
        dao.save("AppuserMapper.saveU", pd);
    }

    @Override
    public void editU(PageData pd) throws Exception {
       dao.update("AppuserMapper.editU", pd);
    }

    @Override
    public void deleteU(PageData pd) throws Exception {
        dao.delete("AppuserMapper.deleteU", pd);
    }

    @Override
    public void deleteAllU(String[] USER_IDS) throws Exception {
       dao.delete("AppuserMapper.deleteAllU", USER_IDS);
    }

    @Override
    public List<PageData> listAllUser(PageData pd) throws Exception {
       return (List<PageData>) dao.findForList("AppuserMapper.listAllUser", pd);
    }

    @Override
    public List<PageData> listPdPageUser(Page page) throws Exception {
       return (List<PageData>) dao.findForList("AppuserMapper.userlistPage", page);
    }

    @Override
    public void saveIP(PageData pd) throws Exception {
        dao.update("AppuserMapper.saveIP", pd);
    }

    @Override
    public PageData getUserByNameAndPwd(PageData pd) throws Exception {
       return (PageData) dao.findForObject("AppuserMapper.getUserInfo", pd);
    }

    @Override
    public void updateLastLogin(PageData pd) throws Exception {
        dao.update("AppuserMapper.updateLastLogin", pd);
    }

}
