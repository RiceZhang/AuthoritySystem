/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.listener;

import com.zrx.authority.util.Const;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-28,23:39:57
 * @version 1.0
 */
public class WebAppContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=== WebAppContextListener  contextInitialized ===");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       System.out.println("=== WebAppContextListener contextDestroyed ===");
       
       Const.WEB_APP_CONTEXT = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
       
    }

}
