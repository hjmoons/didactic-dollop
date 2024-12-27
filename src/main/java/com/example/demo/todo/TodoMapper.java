package com.example.demo.todo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<Todo> findAll();
    int create(Todo todo);
    Todo findId(Todo todo);
    int update(Todo todo);
}
