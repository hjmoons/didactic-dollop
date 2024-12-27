package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoMapper todoMapper;

    public List<Todo> getTodos() {
        return todoMapper.findAll();
    }
    public int create(Todo todo) {
        return todoMapper.create(todo);
    }
    public Todo getTodo(Todo todo) {
        return todoMapper.findId(todo);
    }

    public int update(Todo todo) {
        return todoMapper.update(todo);
    }
}
