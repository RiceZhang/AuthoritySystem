/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.controller.system.head;

import com.zrx.authority.service.system.IAppuserService;
import com.zrx.authority.service.system.IUserService;
import com.zrx.authority.util.AppUtil;
import com.zrx.authority.util.Const;
import com.zrx.authority.util.PageData;
import com.zrx.authority.web.controller.base.BaseController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-31,0:05:04
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/head")
public class HeadController extends BaseController {
   
    @Resource(name = "userService")
    private IUserService userService;
    @Resource(name = "appuserService")
    private IAppuserService appuserService;
    
    
    /**
     * 获取头部信息
     */
    @RequestMapping(value = "/getUname")
    @ResponseBody
    public Object getList() {
        PageData pd = new PageData();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            pd = this.getPageData();
            List<PageData> pdList = new ArrayList<PageData>();

            //shiro管理的session
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            
            PageData pds = new PageData();
            pds = (PageData) session.getAttribute("userpds");
            if (null == pds) {
                String USERNAME = session.getAttribute(Const.SESSION_USERNAME).toString(); //获取当前登录者loginname
                pd.put("USERNAME", USERNAME);
                pds = userService.findByUId(pd);
                session.setAttribute("userpds", pds);
            }
            pdList.add(pds);
            map.put("list", pdList);
        }catch(Exception e){
            logger.error(e.toString(), e);
        }finally {
           logAfter(logger);
        }
        return AppUtil.returnObject(pd, map);
    }
        
        
}
