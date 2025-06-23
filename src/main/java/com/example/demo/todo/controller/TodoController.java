package com.example.demo.todo.controller;

import com.example.demo.todo.domain.dto.TodoCreateRequest;
import com.example.demo.todo.domain.dto.TodoUpdateRequest;
import com.example.demo.todo.domain.entity.Todo;
import com.example.demo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody TodoCreateRequest todoCreateRequest) {
        Todo todo = todoService.createTodo(todoCreateRequest);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getList() {
        return ResponseEntity.ok(todoService.getTodoList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> get(@PathVariable Long id) {
        return todoService.getTodo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody TodoUpdateRequest todoUpdateRequest) {
        Todo todo = todoService.updateTodo(id, todoUpdateRequest);
        return ResponseEntity.ok(todo);
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Todo> updateToggle(@PathVariable Long id) {
        Todo todo = todoService.updateToggleTodo(id);
        return ResponseEntity.ok(todo);
    }
}
