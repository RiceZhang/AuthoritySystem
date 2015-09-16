/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.filter;

import com.zrx.authority.web.controller.base.BaseController;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-28,23:35:01
 * @version 1.0
 */
public class StartFilter extends BaseController implements Filter {

    @Override
    public void init(FilterConfig filterConfig) 
            throws ServletException {
        System.out.println("=== StartFilter init  ===");
    }

    //计时器
    public void timer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9); // 控制时
        calendar.set(Calendar.MINUTE, 0); // 控制分
        calendar.set(Calendar.SECOND, 0); // 控制秒

        Date time = calendar.getTime(); // 得出执行任务的时间

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

				//PersonService personService = (PersonService)ApplicationContext.getBean("personService");
                //System.out.println("-------设定要指定任务--------");
            }
        }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
    }
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
       System.out.println("=== StartFilter doFilter  ===");
    }

    @Override
    public void destroy() {
       System.out.println("=== StartFilter destroy  ===");
    }

}
