package com.epam.task1.services;

import java.util.List;

import com.epam.task1.entities.Todo;

public interface TodoService {
	
	List<Todo> getAllTodos();
	
	Todo getTodoById(Long id);
	
	Todo createTodo(Todo todo);
	
	Todo updateTodo(Long id, Todo todoDetails);
	
	void deleteTodo(Long id);
}
