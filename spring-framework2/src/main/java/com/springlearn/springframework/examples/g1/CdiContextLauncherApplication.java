package com.springlearn.springframework.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;


//CDI(Contexts and Dependency Injection) annotations are alternatives to Spring annotation

//Inject(~Autowired in Spring)
//Named(~Component in Spring)
//Qualifier
//Scope
//Singleton


//@Component
@Named
class BusinessService{
	DataService dataService;

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("setter injection performed");
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}

}

//@Component
@Named
class DataService{
	
}

@Configuration//combining Configuration file and App file from last project
@ComponentScan//tells spring in which package to look for component
public class CdiContextLauncherApplication{

	
	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessService.class).getDataService());
		};
	}
}