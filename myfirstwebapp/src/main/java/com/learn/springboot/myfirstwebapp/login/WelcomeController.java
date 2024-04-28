package com.learn.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")//using name as session attribute //when we want to retain values across different requests we can use sessions
public class WelcomeController {

//	private Logger logger=LoggerFactory.getLogger(getClass());
//	@RequestMapping(value="login",method=RequestMethod.GET)//GET method
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {//Annotation which indicates that a method parameter should be bound to a web request parameter.
//		//whenever we want anything from controller to be available to the view, we put it in the ModelMap
//		model.put("name",name);
////		logger.debug("Request param is {}",name);//at debug level
////		logger.info("Request param is {}!!",name);//at info level
//		//System.out.println("Request param is "+ name);//bad way to do things so we should make use of a logger
//		return "login";
//	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//getAuthentication->Obtains the currently authenticated principal, or an authentication request token
		return authentication.getName();
	}
}
