package com.springlearn.springframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//combining Configuration file and App file from last project
@ComponentScan("com.springlearn.springframework.game")//tells spring in which package to look for component
public class App03GamingSpringBeans {

	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)){
			context.getBean(GamingConsole.class).left();
			context.getBean(GameRunner.class).run();
		};
	}
}