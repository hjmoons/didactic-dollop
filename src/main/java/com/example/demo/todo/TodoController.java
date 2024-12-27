package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    public Todo create(Todo todo) {
        int result = todoService.create(todo);
        return todo;
    }

    @GetMapping("/{id}")
    public Todo getTodo(Todo todo) {
        return todoService.getTodo(todo);
    }

    @PutMapping
    public Todo update(Todo todo) {
        int result = todoService.update(todo);
        return todo;
    }
}
