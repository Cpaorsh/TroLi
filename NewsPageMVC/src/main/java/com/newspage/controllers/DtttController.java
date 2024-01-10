package com.newspage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newspage.beans.Dttt;
import com.newspage.beans.Hocki;
import com.newspage.dao.DtttDao;
import com.newspage.dao.HockiDao;

@Controller
public class DtttController {

	@Autowired
    DtttDao dtttDao;
	@Autowired
	HockiDao hockiDao;
	
    @RequestMapping(value="dttt/list/hk={id}", method = RequestMethod.GET)    
    public String dtttlist(@PathVariable int id, Model m){    
        List<Dttt> list = dtttDao.getDts(id);    
        m.addAttribute("list",list);  
        return "dtttlist";    
    }
    
    @RequestMapping(value="dttt/list", method = RequestMethod.GET)    
    public String dtttlistlast(Model m){
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Dttt> list = dtttDao.getDts(id);    
        m.addAttribute("list",list);  
        return "dtttlist";    
    }
    
    @RequestMapping(value="dttt/list/gv={mgv}", method = RequestMethod.GET)    
    public String dtttgvlist(@PathVariable String mgv, Model m){    
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
    	List<Dttt> list = dtttDao.getDtgvs(mgv, id);    
        m.addAttribute("list",list);  
        return "dtttgvlist";    
    }
    
    @RequestMapping("dttt/add")    
    public String adddttt(Model m){ 
        List<Hocki> hk = hockiDao.getHks();    
        m.addAttribute("hk",hk);
        m.addAttribute("command", new Dttt());  
        return "dtttadd";   
    }        
    @RequestMapping(value="dttt/addsave",method = RequestMethod.POST)    
    public String addsave(@ModelAttribute("dttt") Dttt dttt){    
    	dtttDao.saveDt(dttt);
    	return "redirect:/dttt/list";   
    }  
    

    @RequestMapping(value="dttt/edit/{id}")    
    public String editdttt(@PathVariable String id, Model m){    
        Dttt dttt=dtttDao.getDtById(id); 
        List<Hocki> hk = hockiDao.getHks();    
        m.addAttribute("hk",hk);
        m.addAttribute("command",dttt);  
        return "dtttedit";    
    }    
    @RequestMapping(value="dttt/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("dttt") Dttt dttt){    
    	dtttDao.updateDt(dttt);
    	return "redirect:/dttt/list";
    }    
    
    
    
    @RequestMapping(value="dttt/delete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable String id){    
    	dtttDao.deleteDt(id);    
        return "redirect:/dttt/list";    
    }
    

}
