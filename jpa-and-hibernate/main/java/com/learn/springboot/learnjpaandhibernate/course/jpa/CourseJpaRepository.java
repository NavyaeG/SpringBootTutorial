package com.learn.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.learn.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

//Spring JPA Repository-meduim amount of code
@Repository
@Transactional//Required when we want to run queries with jpa
public class CourseJpaRepository {
	
	//@Autowired -even this will work
	@PersistenceContext//Expresses a dependency on a container-managed EntityManager and itsassociated persistence context.
	private EntityManager entityManager;//used to manage entities we created
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course= entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
}
