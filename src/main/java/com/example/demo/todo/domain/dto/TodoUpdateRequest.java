package com.example.demo.todo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdateRequest {
    private String title;
    private Boolean completed;
}
