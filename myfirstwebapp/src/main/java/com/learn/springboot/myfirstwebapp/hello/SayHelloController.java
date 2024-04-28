package com.learn.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody//returns whatever is returned by function as is to browser
	public String sayHello() {
		return "Hello, What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody//returns whatever is returned by function as is to browser
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first html page changed");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("</html>");
		return sb.toString();
	}
	
	//returning back name of jsp
	//src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")//jsp -java server pages
	public String sayHelloJsp() {
		return "sayHello";
	}
}

