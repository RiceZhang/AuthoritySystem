/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zrx.authority.service.system;

import com.zrx.authority.domain.entity.Page;
import com.zrx.authority.util.PageData;
import java.util.List;

/**
 *
 * @author 张日雄 <your.name at your.org>
 */
public interface IDictionariesService {
    public void save(PageData pd) throws Exception ;
    public void edit(PageData pd) throws Exception ;
    public PageData findById(PageData pd) throws Exception ;
    public PageData findCount(PageData pd) throws Exception  ;
    public PageData findBmCount(PageData pd) throws Exception ;
    public List<PageData> dictlistPage(Page page) throws Exception ;
    public void delete(PageData pd) throws Exception ;
}
