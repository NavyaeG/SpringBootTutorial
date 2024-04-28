package com.springlearn.springframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

//Default initialization for spring beans is eager
@Component
@Lazy//prevents initialization of bean at startup, it is done when someone uses bean
//not recommended as errors in configuration can't be discovered immediately
class ClassB{
	
	ClassA classA;
	
	public ClassB(ClassA classA) {
		super();
		System.out.println("some initialization logic");
		this.classA=classA;
	}
	
	public void doSomething() {
		System.out.println("did something");
	}
}


@Configuration//combining Configuration file and app file from last project
@ComponentScan//tells spring in which package to look for component
public class LazyInitializationLauncherApplication{

	
	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("initialization of context is complete");
			context.getBean(ClassB.class).doSomething();
		};
	}
}