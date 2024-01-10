package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Hocki;
import com.newspage.beans.Dtkl;
import com.newspage.beans.Kltn;
import com.newspage.dao.HockiDao;
import com.newspage.dao.KltnDao;
import com.newspage.dao.DtklDao;

@Controller
public class KltnController {


	@Autowired
    KltnDao kltnDao;
	@Autowired
	HockiDao hockiDao;
	@Autowired
	DtklDao dtklDao;
	
	
    @RequestMapping("/kltn/list")    
    public String kltnlist(Model m){ 
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Kltn> list = kltnDao.getKltns(id);    
        m.addAttribute("list",list);  
        return "kltnlist";    
    }
    @RequestMapping("/kltn/list/gv={mgv}")    
    public String kltnlist(Model m, @PathVariable String mgv){ 
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Kltn> list = kltnDao.getKltnsbyGv(id, mgv);    
        m.addAttribute("list",list);  
        return "kltnlist";    
    }
    @RequestMapping("/kltn/listcd")    
    public String kltnunlist(Model m){    
        List<Kltn> list = kltnDao.getKltnCd();    
        m.addAttribute("list",list);  
        return "kltnunlist";    
    }
    @RequestMapping("/kltn/listkd")    
    public String kltnun(Model m){    
        List<Kltn> list = kltnDao.getKltnKd();    
        m.addAttribute("list",list);  
        return "kltnunlist";    
    }
    
    @RequestMapping("/kltn/list/hk={id}")    
    public String kltnlist(@PathVariable int id, Model m){    
        List<Kltn> list = kltnDao.getKltns(id);    
        m.addAttribute("list",list);  
        return "kltnlist";    
    }
    

    

    
    
    @RequestMapping("kltn/add/{msv}")    
    public String addkltn(@PathVariable String msv, Model m, Kltn kltn){    
    	//Kltn kltn= null;
    	//Kltn kltn=kltnDao.getKltnById(msv);
    	//if (kltn == null) {
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
    	kltn.setIdhk(id);
    	kltn.setMsv(msv);
    	kltnDao.addKltn(kltn);
    	return "redirect:/kltn/listcd";  
    }   
    
    
    @RequestMapping(value="kltn/duyet/{id}")    
    public String duyetkltn(@PathVariable String id, Model m){    
        Kltn kltn=kltnDao.getKltnById(id);    
        m.addAttribute("command",kltn);  
        return "kltnduyet";    
    }    
    @RequestMapping(value="kltn/duyetsave",method = RequestMethod.POST)    
    public String duyetsave(@ModelAttribute("kltn") Kltn kltn){    
    	kltnDao.duyetKltn(kltn);
    		return "redirect:/kltn/list";
    } 
    


    @RequestMapping(value="kltn/edit/{id}")    
    public String editkltn(@PathVariable String id, Model m){    
    	Hocki hocki = hockiDao.getLastHk();
    	int idhk =  hocki.getId();
    	List<Dtkl> dt = dtklDao.getDtcdks(idhk);    
        m.addAttribute("dt",dt);
    	Kltn kltn=kltnDao.getKltnById(id);    
        m.addAttribute("command",kltn);  
        return "kltnedit";    
    }    
    @RequestMapping(value="kltn/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("kltn") Kltn kltn){    
    	kltnDao.updateKltn(kltn);
    	return "redirect:/kltn/list";
    }    
    
    
    
    @RequestMapping(value="kltn/delete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable String id){
    	kltnDao.deleteKltn(id);
        return "redirect:/kltn/list";    
    }
}