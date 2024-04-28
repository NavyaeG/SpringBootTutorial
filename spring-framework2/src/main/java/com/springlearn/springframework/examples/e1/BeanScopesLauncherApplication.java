package com.springlearn.springframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{//Singleton Scope -Only one object instance per Spring IoC container
	
}

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)//Prototype Scope-Possibly many object instances per Spring IoC container
class PrototypeClass{
	
}

@Configuration//combining Configuration file and App file from last project
@ComponentScan//tells spring in which package to look for component
public class BeanScopesLauncherApplication{

	
	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			
//			stdout
//			com.springlearn.springframework.examples.e1.NormalClass@17d919b6 //same instance of specific bean returned
//			com.springlearn.springframework.examples.e1.NormalClass@17d919b6
//			com.springlearn.springframework.examples.e1.PrototypeClass@53f3bdbd //different instance of bean created every time
//			com.springlearn.springframework.examples.e1.PrototypeClass@34129c78
//			com.springlearn.springframework.examples.e1.PrototypeClass@7d61eb55
			
			//Java Singleton(GOF) vs Spring Singleton
//			Spring Singleton: One object instance per Spring Ioc Container
//			Java Singleton: One object instance per JVM
		};
	}
}