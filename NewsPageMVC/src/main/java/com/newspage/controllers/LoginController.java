package com.newspage.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.newspage.beans.Doc;
import com.newspage.beans.Dtkl;
import com.newspage.beans.Hocki;
import com.newspage.beans.Kltn;
import com.newspage.beans.Login;
import com.newspage.beans.User;
import com.newspage.service.UserService;

@Controller
public class LoginController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public String loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login, Model m) {
    ModelAndView mav = null;
    User user = userService.validateUser(login);

    if (null != user) {
      HttpSession session = request.getSession(true); 
      session.setAttribute("max", user.getMax());
      session.setAttribute("username", user.getUsername());
      session.setAttribute("name", user.getHoten());
      session.setAttribute("role", user.getChucvu());
      session.setAttribute("lop", user.getLop());
      session.setAttribute("duyettt", user.getDuyettt());
      session.setAttribute("duyetkl", user.getDuyetkl());
      return "redirect:/";
    } else {
      //mav = new ModelAndView("login");
      //mav.addObject("message", "Tên đăng nhập hoặc mật khẩu không chính xác!!");
      m.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không chính xác!!");  
      return "login"; 
    }
    
  }
  
  
//  @RequestMapping(value="user/pass")    
//  public String goedit(Model m){      
//      return "userpassword";    
//  } 
//  @RequestMapping(value="user/pass/edit")    
//  public String editpass(HttpServletRequest request, @ModelAttribute("user") User usernew, Model m){    
//	  HttpSession session = request.getSession(true);
//	  String max = (String) session.getAttribute("max");
//	  User userold=userService.getUserById(max);
//	  if (userold.getPassword() == usernew.getPassword()) {
//		  userService.changePassword(usernew);
//	  } 
//      return "index";    
//  }    

  
//	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
//	public ModelAndView showChange(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession(true);
//		String max = (String) session.getAttribute("max");
//		User user=userService.getUserById(max);
//		ModelAndView mav = new ModelAndView("userpassword");
//		mav.addObject("user", user);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/changeProcess", method = RequestMethod.POST)
//	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
//	    @ModelAttribute("user") User user) {
//		userService.changePassword(user);
//		return new ModelAndView("usercurrent", "name", user.getUsername());
//	}

}
