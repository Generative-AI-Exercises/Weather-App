package com.epam.task1.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.task1.entities.Todo;
import com.epam.task1.exceptions.ResourceNotFoundException;
import com.epam.task1.repositories.TodoRepository;
import com.epam.task1.services.TodoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

	private final TodoRepository todoRepository;
	
	@Override
	public List<Todo> getAllTodos() {
        return todoRepository.findAll();
	}

	@Override
	public Todo getTodoById(Long id) {
		return todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("todo", "id", id));
	}

	@Override
	public Todo createTodo(Todo todo) {
		 return todoRepository.save(todo);
	}

	@Override
	public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id);
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        return todoRepository.save(todo);
	}

	@Override
	public void deleteTodo(Long id) {
		todoRepository.delete(getTodoById(id));		
	}

}
