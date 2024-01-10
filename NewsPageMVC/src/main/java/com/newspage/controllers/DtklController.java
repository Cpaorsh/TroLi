package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Dtkl;
import com.newspage.beans.Hocki;
import com.newspage.dao.DtklDao;
import com.newspage.dao.HockiDao;

@Controller
public class DtklController {

	@Autowired
    DtklDao dtklDao;
	@Autowired
	HockiDao hockiDao;
	
    @RequestMapping(value="dtkl/list/hk={id}", method = RequestMethod.GET)    
    public String dtkllist(@PathVariable int id, Model m){    
        List<Dtkl> list = dtklDao.getDts(id);    
        m.addAttribute("list",list);  
        return "dtkllist";    
    }
    
    @RequestMapping(value="dtkl/list", method = RequestMethod.GET)    
    public String dtkllistlast(Model m){
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Dtkl> list = dtklDao.getDts(id);    
        m.addAttribute("list",list);  
        return "dtkllist";    
    }
    
    @RequestMapping(value="dtkl/list/gv={mgv}", method = RequestMethod.GET)    
    public String dtklgvlist(@PathVariable String mgv, Model m){    
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
    	List<Dtkl> list = dtklDao.getDtgvs(mgv, id);    
        m.addAttribute("list",list);  
        return "dtklgvlist";    
    }
    
    @RequestMapping("dtkl/add")    
    public String adddtkl(Model m){ 
        List<Hocki> hk = hockiDao.getHks();    
        m.addAttribute("hk",hk);
        m.addAttribute("command", new Dtkl());  
        return "dtkladd";   
    }        
    @RequestMapping(value="dtkl/addsave",method = RequestMethod.POST)    
    public String addsave(@ModelAttribute("dtkl") Dtkl dtkl){    
    	dtklDao.saveDt(dtkl);
    	return "redirect:/dtkl/list";   
    }  
    

    @RequestMapping(value="dtkl/edit/{id}")    
    public String editdtkl(@PathVariable String id, Model m){    
        Dtkl dtkl=dtklDao.getDtById(id); 
        List<Hocki> hk = hockiDao.getHks();    
        m.addAttribute("hk",hk);
        m.addAttribute("command",dtkl);  
        return "dtkledit";    
    }    
    @RequestMapping(value="dtkl/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("dtkl") Dtkl dtkl){    
    	dtklDao.updateDt(dtkl);
    	return "redirect:/dtkl/list";
    }    
    
    
    
    @RequestMapping(value="dtkl/delete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable String id){    
    	dtklDao.deleteDt(id);    
        return "redirect:/dtkl/list";    
    }
    

}
