package com.todo.demotodolist.service;


import java.util.List;

import com.todo.demotodolist.Repository.TodoRepository;
import com.todo.demotodolist.entity.Todo;
import com.todo.demotodolist.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoService {



    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("No Detail found with id: "+ id));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setDescription(updatedTodo.getDescription());
                    todo.setCompleted(updatedTodo.isCompleted());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found "+id));
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

}

