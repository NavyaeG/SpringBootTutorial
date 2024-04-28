package com.learn.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.springboot.learnjpaandhibernate.course.Course;

//Spring JDBC -most code
@Repository
public class CourseJdbcRepository {
	//These are a lot of queries and can cause confusion if the number of tables are high and queries are more, we use JPA
	//to solve this. allows us to map sql directly to bean
	@Autowired
	JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY=
			"""
			insert into course (id,name,author)  values (?,?,?);

			""";
	
	private static String DELETE_QUERY=
			"""
			delete from course where id=?;
			""";
	
	private static String SELECT_QUERY=
			"""
			select * from course where id=?;
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());//update method can be used to insert, update and delete queries
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);//update method can be used to insert, update and delete queries
	}
	
	public Course findById(long id) {
		//row mapper allows us to map each row in a result set to a specifc bean and in our result set, our column names
		//match to the name of the beans
		//ResultSet->Bean=> Row Mapper
		return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id);//2nd parameter is a row mapper
	}
}
