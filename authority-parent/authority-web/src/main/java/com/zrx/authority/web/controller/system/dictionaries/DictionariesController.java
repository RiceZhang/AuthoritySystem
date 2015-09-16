/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.web.controller.system.dictionaries;

import com.zrx.authority.service.system.IDictionariesService;
import com.zrx.authority.service.system.IMenuService;
import com.zrx.authority.web.controller.base.BaseController;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-9-16,13:03:02
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/dictionaries")
public class DictionariesController extends BaseController {
	@Resource(name = "menuService")
	private IMenuService menuService;
	@Resource(name = "dictionariesService")
	private IDictionariesService dictionariesService;
        
        
        
}
