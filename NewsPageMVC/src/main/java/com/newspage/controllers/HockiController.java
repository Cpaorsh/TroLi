package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Hocki;
import com.newspage.dao.DrlDao;
import com.newspage.dao.HockiDao;

@Controller
public class HockiController {

	@Autowired
	HockiDao hockiDao;
	@Autowired
	DrlDao drlDao;
	
//	@RequestMapping(value="hocki/list", method = RequestMethod.GET)    
//    public String hockilist(Model m){    
//        List<Hocki> list = hockiDao.getHks();    
//        m.addAttribute("list",list);  
//        return "manage";    
//    }
	
	@RequestMapping(value="hocki/new")    
    public String addHockidt(){  
		Hocki hocki = hockiDao.getLastHk();
		String str= hocki.getTenhk();
    	hockiDao.addHk(str);
    	drlDao.newHk();
    	return "redirect:/manage";     
    }
	
    @RequestMapping(value="hocki/delete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
    	hockiDao.deleteHk(id);    
        return "redirect:/hocki/list";    
    }
//	<div class="dropdown-content">
//		<c:forEach items="${list}" var="hocki">
//			<a class="" href="/kltnlist/${hocki.id}">${hocki.tenhk}</a>
//		</c:forEach>	  
//	</div>

}
