package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newspage.beans.Hocki;
import com.newspage.dao.HockiDao;

@Controller
public class HomeController {

	@Autowired
    HockiDao dao;
	
    @RequestMapping("/")
	  public String hockis(Model m){    
	  List<Hocki> liss = dao.getHks();    
	  m.addAttribute("liss",liss);  
	  return "index";    
	}
    


    
    
}
