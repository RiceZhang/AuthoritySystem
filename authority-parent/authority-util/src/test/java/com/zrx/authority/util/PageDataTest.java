/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zrx.authority.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 张日雄 <your.name at your.org>
 */
public class PageDataTest {
    
    public PageDataTest() {
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

    /**
     * Test of get method, of class PageData.
     */
    @Test
    public void testGet() {
//        System.out.println("get");
//        HttpServletRequest request=null;
//        //request.setAttribute("tm", "1111223467");        ;
//        Object key = "tm";
//        PageData instance = new PageData(request);
//        Object expResult = "tm";
//        Object result = instance.get(key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
        
        Map properties = new HashMap();;
        properties.put("tm", "134790533133");
 
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        
        Map.Entry entry;
        String name = "";
        String value = "";
        System.out.println("输出1："+value.length());
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                System.out.println("输出2："+value.length());
                value = value.substring(0, value.length());
            } else {
                System.out.println("输出3："+value.length());
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        //assertEquals(entry, value);
        System.out.println("输出result"+returnMap.get("tm"));
    }


}
