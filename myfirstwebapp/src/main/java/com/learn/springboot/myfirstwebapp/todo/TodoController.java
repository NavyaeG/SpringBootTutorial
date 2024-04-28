package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	private TodoService todoService;

	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username=getLoggedInUsername(model);
		List<Todo> todos=todoService.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listTodos";
	}
	
	//Two way binding: 
	
	//Two way data binding in spring allows user inputs to be dynamically bound to the beans. 
	//It is two-way in a sense that it can get the inputs from the beans and it can post the user inputs 
	//to the beans using GET and POST api. Here it is done from the form to the bean and vice versa
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"Default value",LocalDate.now().plusYears(1),false);//This is the default value that will be shown in the form when the add todo page loads
		//"Default value" is shown in the text box
		model.put("todo", todo);
		return "todo";
	}


//	@RequestMapping(value="add-todo",method=RequestMethod.POST)
//	public String addNewTodo(@RequestParam String description, ModelMap model) {
//		String username=(String)model.get("name");
//		todoService.addTodo(username,description,LocalDate.now().plusYears(1),false);
//		return "redirect:list-todos";
//	}
	
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {//here we are binding data we get to the todo bean itself, instead of binding it to a variable and then using that
		//this makes it easier, as if there are more fields writing a @RequestParams for each field would be tedious 
		
		//@Valid Todo todo: valid here makes sure bean is validated before the binding happens
		
		//Todo todo here is a FORM BACKING OBJECT
		
		//BindingResult: holds the result of a validation and binding and contains errors that may have occurred. 
		//The BindingResult must come right after the model object that is validated or else Spring fails to validate the object and throws an exception.
		
		//in the below line we are using the result, if it has errors it will just go back to that page
		if(result.hasErrors()) {
			return "todo";
		}
		String username=getLoggedInUsername(model);
		todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),false);
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo =todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String username=getLoggedInUsername(model);
		todoService.updateTodo(todo,username);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//getAuthentication->Obtains the currently authenticated principal, or an authentication request token
		return authentication.getName();
	}
}