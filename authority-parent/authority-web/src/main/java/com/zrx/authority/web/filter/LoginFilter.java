/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.filter;

import com.zrx.authority.web.controller.base.BaseController;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-8-28,23:34:44
 * @version 1.0
 */
public class LoginFilter extends BaseController implements Filter {

    @Override
    public void init(FilterConfig filterConfig) 
            throws ServletException {
        System.out.println("=== LoginFilter init === ");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req ;
        HttpServletResponse response = (HttpServletResponse) res;
        
        System.out.println("=== LoginFilter doFilter before chain === ");
        chain.doFilter(req, res); // 调用下一过滤器
        System.out.println("=== LoginFilter doFilter after chain === ");
    }

    @Override
    public void destroy() {
      System.out.println("=== LoginFilter destroy === ");
    }

}
