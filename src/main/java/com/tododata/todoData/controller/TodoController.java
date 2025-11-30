package com.tododata.todoData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tododata.todoData.entity.TodoEntity;
import com.tododata.todoData.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/todos")           // <- base URL for all todo APIs
@CrossOrigin(origins = "http://localhost:3000")   // <- allow React app
public class TodoController {

    @Autowired
    private TodoService service;

    // CREATE – add one todo
    @PostMapping
    @Operation(summary="Post the todo")
    public List<TodoEntity> addTodo(@RequestBody TodoEntity entry) {
        return service.addTodo(entry);     // change service method to return single TodoEntity
    }

    // READ – get all todos
    @Operation(summary="Read all Todo")
    @GetMapping
    public List<TodoEntity> getTodo() {
        return service.getTodo();
    }

    // READ – get todo by id
    @Operation(summary="Get Todo By id")
    @GetMapping("/{id}")
    public TodoEntity getTodoById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE – update todo by id
    @Operation(summary="Update Todo by id")
    @PutMapping("/{id}")
    public TodoEntity updateTodoById(@RequestBody TodoEntity entry, @PathVariable Long id) {
        return service.updateById(id, entry);
    }

    // DELETE – delete todo by id
    @Operation(summary="Delete Todo by id")
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
