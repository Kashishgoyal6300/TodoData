package com.tododata.todoData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tododata.todoData.entity.TodoEntity;
import com.tododata.todoData.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository repo;
	public List<TodoEntity> addTodo(TodoEntity entry) {
		repo.save(entry);
		return repo.findAll();
		
	}

	public List<TodoEntity> getTodo() {
		return repo.findAll();
		
	}

	public TodoEntity getById(Long getId) {
		return repo.findById(getId).orElse(null);
	}

	public TodoEntity deleteById(Long getId) {
		
		TodoEntity existing=repo.findById(getId).orElse(null);
		if(existing!=null) {
			repo.delete(existing);
		}
		return existing;
	}

	public TodoEntity updateById(Long getId, TodoEntity entry) {
		TodoEntity existing=repo.findById(getId).orElse(null);
		if(existing==null) return null;
		existing.setContent(entry.getContent());
		existing.setTitle(entry.getTitle());
		return repo.save(existing);
	}

}
