package com.learn.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

//While we were using JDBC
//@Component
//public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//	//CommandLineRunner: Interface used to indicate that a bean should run when it is contained within a
//	//SpringApplication. Multiple CommandLineRunner beans can be defined within the same application context 
//	//and can be ordered using the Ordered interface or @Order annotation. 
//	
//	Using JDBC
//	@Autowired
//	private CourseJdbcRepository repository;
//
//	Using Spring JPA
//	@Autowired
//	private CourseJpaRepository repository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		repository.insert(new Course(1,"Learn AWS now!","in28min"));
//		repository.insert(new Course(2,"Learn Azure now!","in28min"));
//		repository.deleteById(1);
//		System.out.println(repository.findById(2));
//	}
//	
//}


//While Using SpringDataJPA
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	//CommandLineRunner: Interface used to indicate that a bean should run when it is contained within a
	//SpringApplication. Multiple CommandLineRunner beans can be defined within the same application context 
	//and can be ordered using the Ordered interface or @Order annotation. 
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"Learn AWS now!","in28min"));//save instead of insert
		repository.save(new Course(2,"Learn Azure now!","in28min"));
		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findByAuthor("in28min"));
	}
	
}