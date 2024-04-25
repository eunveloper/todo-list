package com.moais.todo.api.todo.dto;

import com.moais.todo.api.todo.domain.Status;
import com.moais.todo.api.todo.domain.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponse {

    private Long id;
    private String title;
    private String content;
    private Status status;
    private LocalDateTime doDate;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.status = todo.getStatus();
        this.doDate = todo.getDoDate();
    }

    public static TodoResponse of(Todo todo) {
        return new TodoResponse(todo);
    }

}
