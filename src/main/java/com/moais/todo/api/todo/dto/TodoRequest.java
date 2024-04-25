package com.moais.todo.api.todo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime doDate;

}
