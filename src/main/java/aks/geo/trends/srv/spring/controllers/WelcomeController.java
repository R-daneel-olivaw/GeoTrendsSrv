package aks.geo.trends.srv.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class WelcomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcomeScreen()
	{
		ModelAndView mv = new ModelAndView("test");
		
		return mv;
		
	}

}
