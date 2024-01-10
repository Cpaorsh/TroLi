package com.newspage.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newspage.beans.Drl;
import com.newspage.beans.Hocki;
import com.newspage.beans.Sinhvien;
import com.newspage.dao.DrlDao;
import com.newspage.dao.SinhvienDao;

@Controller
public class DrlController {

	@Autowired
    DrlDao drlDao;
	@Autowired
    SinhvienDao svDao;
	
	
    @RequestMapping(value={"drl/list", "drl/list/ten="})    
    public String drllist(Model m){    
        List<Drl> list = drlDao.getDrls();    
        m.addAttribute("list",list);  
        return "drllist";    
    }   
    @RequestMapping(value={"drl/list/lop={lop}"})    
    public String drllist(@PathVariable String lop, Model m){    
        List<Drl> list = drlDao.getDrlbyLop(lop);    
        m.addAttribute("list",list);  
        return "drllist";    
    }
    @RequestMapping(value="drl/list/ten={ten}")    
    public String drlmana(@PathVariable String ten,Model m){    
        List<Drl> list = drlDao.findDrls(ten);    
        m.addAttribute("list",list);  
        return "drllist";    
    }
    
    @RequestMapping(value="drl/list/{pa}")    
    public String pagination(@PathVariable int pa, Model m){  
    	int totalRecord = 9;
    	if(pa==1){}    
        else{    
            pa=(pa-1)*totalRecord+1;    
        }
    	int total = drlDao.getTotal();
    	
    	int numberpage = (int) Math.round(total/totalRecord +0.5);
    	m.addAttribute("numberpage", numberpage);
    	
    	List<Drl> list = drlDao.getbyPagination(pa, totalRecord); 
    	m.addAttribute("list", list);
        return "drllist";    
    }
    
    
    @RequestMapping(value="drl/edit/{msv}")    
    public String edit(@PathVariable int msv, Model m){    
        Drl drl=drlDao.getDrlByMsv(msv);    
        m.addAttribute("command",drl);  
        return "drledit";    
    }    
    
    @RequestMapping(value="drl/savesv",method = RequestMethod.POST)    
    public String saveDrlSv(@ModelAttribute("drl") Drl drl){    
    	if(drl.getLttongdiem() == 0) {
    		drlDao.updateAv(drl);
    	}else {
    		drlDao.updateSv(drl); 
    	}
    	int id = drl.getMsv();
    	return "redirect:/drl/edit/"+id+"";
        //return "redirect:/drl/drllist";    
    }
    
    @RequestMapping(value="drl/savelt",method = RequestMethod.POST)    
    public String saveDrlLt(@ModelAttribute("drl") Drl drl){    
    	drlDao.updateLt(drl);  
    	int id = drl.getMsv();
    	Sinhvien sv = svDao.getSinhvienById(id);
    	String lop = sv.getLop();
    	return "redirect:/drl/list/lop="+lop+"";        
    	//return "redirect:/drl/drllist";    
    }
    
    @RequestMapping(value="drl/savegv",method = RequestMethod.POST)    
    public String saveDrlGv(@ModelAttribute("drl") Drl drl){    
    	drlDao.updateGv(drl);    
    	int id = drl.getMsv();
    	Sinhvien sv = svDao.getSinhvienById(id);
    	String lop = sv.getLop();
    	return "redirect:/drl/list/lop="+lop+""; 
    	//return "redirect:/drl/drllist";    
    }
}
