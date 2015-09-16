/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.dao.basedao;

import com.zrx.authority.dao.IBaseDao;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-27,13:04:21
 * @version 1.0
 */
@Repository("baseDao")
public class BaseDaoImpl implements IBaseDao{
    
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Object save(String str, Object obj) throws Exception {
        return sqlSessionTemplate.insert(str, obj);
    }

    @Override
    public Object update(String str, Object obj) throws Exception {
        return sqlSessionTemplate.update(str, obj);
    }

    @Override
    public Object delete(String str, Object obj) throws Exception {
         return sqlSessionTemplate.delete(str, obj);
    }

    @Override
    public Object findForObject(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    @Override
    public Object findForList(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectList(str, obj);
    }

    @Override
    public Object findForMap(String sql, Object obj, String key, String value) throws Exception {
         return sqlSessionTemplate.selectMap(sql, obj, key);
    }
    
    
}
