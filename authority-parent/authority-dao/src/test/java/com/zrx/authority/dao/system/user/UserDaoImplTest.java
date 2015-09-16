/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zrx.authority.dao.system.user;

import com.zrx.authority.dao.system.IUserDao;
import com.zrx.authority.domain.entity.system.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注意： 一般的CURD 没必要花时间去测试，我这里是为了学习  mock 
 * @author 张日雄 <your.name at your.org>
 */
public class UserDaoImplTest {
    
    private static ApplicationContext ac;
    
    

    
    public UserDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/spring-mybatis.xml"});
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    //通过id获取数据
    @Test
    public void testGetUserAndRoleById() throws Exception{
//        //准备数据
//        User user=new User();
//        String USER_ID = "1";
//        user.setUSER_ID(USER_ID);
//        SqlSessionTemplate sqlSessionTemplate= (SqlSessionTemplate)ac.getBean("sqlSessionTemplate");
//        
//        //调用
//        IUserDao userDao = (IUserDao) ac.getBean("userDao");
//        user = (User)userDao.findForObject(IUserDao.UserMapper_GetUserAndRoleById, USER_ID);
//        //user=(User)sqlSessionTemplate.selectOne("UserMapper.getUserInfo", user);
//        
//        //猜想
//        assertNotNull(user);
//        System.out.println("猜想："+user.getUSERNAME()+" "+user.getRole().getROLE_ID()+" " + user.getRole().getROLE_NAME());
    }
    
    @Test
    public void testGetUserInfoByUser() throws Exception {
//        //准备数据
//        User user = new User();
//        user.setUSER_ID("1");
//        //调用
//        IUserDao userDao = (IUserDao) ac.getBean("userDao");
//        user = (User)userDao.findForObject(IUserDao.UserMapper_GetUserInfoByUser, user);
//        //猜想
//        //assertNotNull(user);
    }
    

    
}
