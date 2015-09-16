/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.spring;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author 张日雄 <your.name at your.org>
 */
public class TestSpring {
    
    public TestSpring() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void helloSpring() {
        System.out.println("==============开始测试==================");
        ApplicationContext ac
                = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/spring-mybatis.xml"});
        System.out.println("输出："+ac.getBean("sqlSessionTemplate"));
    }
}
