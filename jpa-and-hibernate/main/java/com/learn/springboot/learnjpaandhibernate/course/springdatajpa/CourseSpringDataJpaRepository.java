package com.learn.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.springboot.learnjpaandhibernate.course.Course;
//Spring Data JPA Repository-least code
@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long>{
	List<Course> findByAuthor(String author);
}
