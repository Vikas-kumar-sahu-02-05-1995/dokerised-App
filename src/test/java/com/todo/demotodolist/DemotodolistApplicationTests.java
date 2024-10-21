package com.todo.demotodolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.todo.demotodolist.Repository.TodoRepository;
import com.todo.demotodolist.entity.Todo;
import com.todo.demotodolist.service.TodoService;

@SpringBootTest
public class DemotodolistApplicationTests {

    @Autowired
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    public void testGetAllTodos() {
    	List<Todo> todos = Arrays.asList(
    		    new Todo("First Todo", false),
    		    new Todo("Second Todo", true),
    		    new Todo("Third Todo", false)
    		);
        Mockito.when(todoRepository.findAll()).thenReturn(todos);
        assertEquals(3, todoService.getAllTodos().size());
    }

    @Test
    public void testCreateTodo() {
        Todo todo = new Todo("Test Todo", false);
        Mockito.when(todoRepository.save(todo)).thenReturn(todo);
        assertEquals(todo, todoService.createTodo(todo));
    }

    @Test
    public void testGetByIdTodos() {
        Long todoId = 1L;
        Todo todo = new Todo("Test Todo", false);
        Mockito.when(todoRepository.findById(todoId)).thenReturn(Optional.of(todo));
        assertEquals(todo, todoService.getTodoById(todoId));
    }
}