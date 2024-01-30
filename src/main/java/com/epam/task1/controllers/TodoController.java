package com.epam.task1.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epam.task1.entities.Todo;
import com.epam.task1.services.TodoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;
	
    @GetMapping("/todos")
    public List<Todo> getAllTodos() {return todoService.getAllTodos();}

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {return todoService.createTodo(todo);}

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable(value = "id") Long todoId) {return todoService.getTodoById(todoId);}

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable(value = "id") Long todoId, @Valid @RequestBody Todo todoDetails) {return todoService.updateTodo(todoId, todoDetails);}

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(value = "id") Long todoId) {
         todoService.deleteTodo(todoId);
         return ResponseEntity.ok().build();
    }

}
