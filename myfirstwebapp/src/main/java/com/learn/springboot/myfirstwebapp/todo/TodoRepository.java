package com.learn.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	//JpaRepository is particularly a JPA specific extension for Repository. It has full API CrudRepository 
	//and PagingAndSortingRepository. So, basically, Jpa Repository contains the APIs for basic CRUD operations, 
	//the APIS for pagination, and the APIs for sorting.
	public List<Todo> findByUsername(String username);
}