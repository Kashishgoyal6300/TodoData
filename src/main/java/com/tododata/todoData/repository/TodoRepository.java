package com.tododata.todoData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tododata.todoData.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
	
}
