package com.tododata.todoData.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tododata.todoData.entity.TodoEntity;
import com.tododata.todoData.service.TodoService;

@RestController
@RequestMapping("/api")
public class TodoController {
	@Autowired
	TodoService	service;
	@PostMapping
	
	public List<TodoEntity>addTodo(@RequestBody TodoEntity entry){
		return service.addTodo(entry);
	}
	
	@GetMapping
	public List<TodoEntity>getTodo(){
		return service.getTodo();
	}
	@GetMapping("/{getId}")
	public TodoEntity getTodoById(@PathVariable Long getId) {
		return service.getById(getId);
	}
	@DeleteMapping("/{getId}")
	public TodoEntity deleteTodoById(@PathVariable Long getId) {
		return service.deleteById(getId);
	}
	
	@PutMapping("/{getId}")
	public TodoEntity updateTodoById(@RequestBody TodoEntity entry,@PathVariable Long getId) {
		return service.updateById(getId,entry);
	}
	
}
