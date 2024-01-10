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
import com.newspage.beans.Dttt;
import com.newspage.beans.Ttcn;
import com.newspage.dao.HockiDao;
import com.newspage.dao.TtcnDao;
import com.newspage.dao.DtttDao;

@Controller
public class TtcnController {


	@Autowired
    TtcnDao ttcnDao;
	@Autowired
	HockiDao hockiDao;
	@Autowired
	DtttDao dtttDao;
	
	
    @RequestMapping("/ttcn/list")    
    public String ttcnlist(Model m){ 
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Ttcn> list = ttcnDao.getTtcns(id);    
        m.addAttribute("list",list);  
        return "ttcnlist";    
    }
    @RequestMapping("/ttcn/list/gv={mgv}")    
    public String ttcngvlist(Model m, @PathVariable String mgv){ 
    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
        List<Ttcn> list = ttcnDao.getTtcnsbyGv(id, mgv);    
        m.addAttribute("list",list);  
        return "ttcnlist";    
    }
    @RequestMapping("/ttcn/listcd")    
    public String ttcnunlist(Model m){    
        List<Ttcn> list = ttcnDao.getTtcnCd();    
        m.addAttribute("list",list);  
        return "ttcnunlist";    
    }
    @RequestMapping("/ttcn/listkd")    
    public String ttcnun(Model m){    
        List<Ttcn> list = ttcnDao.getTtcnKd();    
        m.addAttribute("list",list);  
        return "ttcnunlist";    
    }
    
    @RequestMapping("/ttcn/list/hk={id}")    
    public String ttcnlist(@PathVariable int id, Model m){    
        List<Ttcn> list = ttcnDao.getTtcns(id);    
        m.addAttribute("list",list);  
        return "ttcnlist";    
    }
    

    

    
    
    @RequestMapping("ttcn/add/{msv}")    
    public String addttcn(@PathVariable String msv, Model m, Ttcn ttcn){    

    	Hocki hocki = hockiDao.getLastHk();
    	int id =  hocki.getId();
    	ttcn.setIdhk(id);
    	ttcn.setMsv(msv);
    	ttcnDao.addTtcn(ttcn);

    	return "redirect:/ttcn/listcd";  
    }   
    
    
    @RequestMapping(value="ttcn/duyet/{id}")    
    public String duyetttcn(@PathVariable String id, Model m){    
        Ttcn ttcn=ttcnDao.getTtcnById(id);    
        m.addAttribute("command",ttcn);  
        return "ttcnduyet";    
    }    
    @RequestMapping(value="ttcn/duyetsave",method = RequestMethod.POST)    
    public String duyetsave(@ModelAttribute("ttcn") Ttcn ttcn){    
    	ttcnDao.duyetTtcn(ttcn);
    		return "redirect:/ttcn/list";
    } 
    


    @RequestMapping(value="ttcn/edit/{id}")    
    public String editttcn(@PathVariable String id, Model m){    
    	Hocki hocki = hockiDao.getLastHk();
    	int idhk =  hocki.getId();
    	List<Dttt> dt = dtttDao.getDtcs(idhk);    
        m.addAttribute("dt",dt);
    	Ttcn ttcn=ttcnDao.getTtcnById(id);    
        m.addAttribute("command",ttcn);  
        return "ttcnedit";    
    }    
    @RequestMapping(value="ttcn/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("ttcn") Ttcn ttcn){    
    	ttcnDao.updateTtcn(ttcn);
    	return "redirect:/ttcn/list";
    }    
    
    
    
    @RequestMapping(value="ttcn/delete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable String id){
    	ttcnDao.deleteTtcn(id);
        return "redirect:/ttcn/list";    
    }
}