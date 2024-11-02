package com.capg.ram.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/login.spring")
	public ModelAndView loginValid(HttpServletRequest request, 
			 HttpServletResponse response,ModelMap map){
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			System.out.println("login.spring ---Hello Login ");
		ModelAndView mav = new ModelAndView();
			if(user.equals("ram"))
				mav.setViewName("/Success.jsp");
			else
				mav.setViewName("/Failed.jsp");
			return mav;
	}	
	
	@RequestMapping("/user.spring")
	public ModelAndView userValid(HttpServletRequest request, 
			 HttpServletResponse response,ModelMap map){
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			System.out.println("user.spring --User  Login");
		ModelAndView mav = new ModelAndView();
			if(user.equals("ram"))
				mav.setViewName("/Success.jsp");
			else
				mav.setViewName("/Failed.jsp");
			return mav;
	}	
	
	
}
