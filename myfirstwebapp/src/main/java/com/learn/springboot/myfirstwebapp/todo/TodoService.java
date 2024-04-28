package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos =new ArrayList<>();
	private static int todosCount=0;

	static {
		todos.add(new Todo(++todosCount,"in28min","Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"in28min","Learn devOps",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"in28min","Learn CyberSecurity",LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		Todo todo =new Todo(++todosCount,username,description, targetDate,isDone);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		//todo -> todo.getId()==id // this is a lambda function
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;// for every todo check if its id matches the id we have given
		todos.removeIf(predicate);//removing the todo if the todo has a matching id
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;// for every todo check if its id matches the id we have given
		Todo todo=todos.stream().filter(predicate).findFirst().get();//from all the todos we get, we are creating a stream and matching by the condition in the predicate
		//the above line of code can also be done using a for loop but here we are using functional programming
		return todo;
	}

	public void updateTodo(@Valid Todo todo, String username) {
		deleteById((int)todo.getId());
		addTodo(username,todo.getDescription(),todo.getTargetDate(),false);
		//todos.add(todo);
	}
	
}