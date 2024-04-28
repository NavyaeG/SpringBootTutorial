package com.springlearn.springframework.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//combining Configuration file and App file from last project
@ComponentScan("com.springlearn.springframework.examples.a1")//tells spring in which package to look for component
public class XmlConfigurationContextLauncherApplication{

	
	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(XmlConfigurationContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		};
	}
}