package com.springlearn.springframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//YourBusinessClass
@Component//Component is an instance of class will be managed by spring framework
class YourBusinessClass{
	//Field Injection
	//@Autowired//as soon as you put autowired on a field spring would do field injection
	Dependency1 dependency1;//setting dependency
	//@Autowired
	Dependency2 dependency2;//setting dependency
	
	
	//Constructor Injection-recommended to be used
	@Autowired//in constructor injection using autowired is optional, because spring would automatically use constructor to create object
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("constructor injection YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}


	//Setter Injection
//	@Autowired//autowired is not on the fields but on the setters
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("setter injection-setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("setter injection-setDependency2");
//		this.dependency2 = dependency2;
//	}
	
	
	public String toString() {
		return "Using"+dependency1+"and"+dependency2;
	}
}

//Dependency1
@Component
class Dependency1{
	
}

//Dependency2
@Component
class Dependency2{
	
}

@Configuration//combining Configuration file and App file from last project
@ComponentScan//tells spring in which package to look for component
public class DepInjectionLauncherApplication {
	//Dependency Injection: Identify beans, their dependencies and wire them together
	//3 different types of DI: fied, constructor, setter

	
	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBusinessClass.class));
		};
	}
}