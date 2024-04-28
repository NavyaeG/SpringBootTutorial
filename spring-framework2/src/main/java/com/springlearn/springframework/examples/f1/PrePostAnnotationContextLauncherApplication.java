package com.springlearn.springframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency=someDependency;
		System.out.println("all dependencies are ready");
	}
	
	@PostConstruct//when we want to execute some logic as soon as dependencies are wired in. eg: setting up database connection
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy//when we want to do a cleanup right before bean is removed from application context. eg: terminating database connection
	public void cleanup() {
		System.out.println("cleanup");
	}
}

@Component
class SomeDependency{
	public void getReady() {
		System.out.println("Some logic using SomeDependency");
	}
}
@Configuration//combining Configuration file and App file from last project
@ComponentScan//tells spring in which package to look for component
public class PrePostAnnotationContextLauncherApplication{

	
	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		};
	}
}