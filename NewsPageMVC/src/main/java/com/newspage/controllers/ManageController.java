package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newspage.beans.Hocki;
import com.newspage.beans.Slieu;
import com.newspage.dao.HockiDao;
import com.newspage.dao.ManageDao;

@Controller
public class ManageController {

	@Autowired
    ManageDao dao;
	@Autowired
	HockiDao hockiDao;
	
    @RequestMapping("/manage")
	  public String manage(Model m){
      Hocki hocki = hockiDao.getLastHk();
      int id =  hocki.getId();
      Slieu ttcn = dao.getTongtt(id);
      Slieu kltn = dao.getTongkl(id);
	  List<Slieu> list = dao.getLops();    
	  m.addAttribute("ttcn",ttcn);
	  m.addAttribute("kltn",kltn);
	  m.addAttribute("list",list);
	  return "manage";    
	}
}
