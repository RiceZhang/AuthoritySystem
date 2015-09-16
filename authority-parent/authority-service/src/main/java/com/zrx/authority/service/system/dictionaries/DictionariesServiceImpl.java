/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.service.system.dictionaries;

import com.zrx.authority.dao.IBaseDao;
import com.zrx.authority.domain.entity.Page;
import com.zrx.authority.service.system.IDictionariesService;
import com.zrx.authority.util.PageData;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,12:49:43
 * @version 1.0
 */
@Service("dictionariesService")
public class DictionariesServiceImpl implements IDictionariesService{
    
    @Resource(name = "baseDao")
    private IBaseDao dao;

    @Override
    public void save(PageData pd) throws Exception {
       dao.save("DictionariesMapper.save", pd);
    }

    @Override
    public void edit(PageData pd) throws Exception {
        dao.update("DictionariesMapper.edit", pd);
    }

    @Override
    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("DictionariesMapper.findById", pd);
    }

    @Override
    public PageData findCount(PageData pd) throws Exception {
       return (PageData) dao.findForObject("DictionariesMapper.findCount", pd);
    }

    @Override
    public PageData findBmCount(PageData pd) throws Exception {
        return (PageData) dao.findForObject("DictionariesMapper.findBmCount", pd);
    }

    @Override
    public List<PageData> dictlistPage(Page page) throws Exception {
        return (List<PageData>) dao.findForList("DictionariesMapper.dictlistPage", page);
    }

    @Override
    public void delete(PageData pd) throws Exception {
        dao.delete("DictionariesMapper.delete", pd);
    }
    
}
