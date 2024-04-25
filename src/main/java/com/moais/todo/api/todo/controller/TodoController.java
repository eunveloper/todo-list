package com.moais.todo.api.todo.controller;

import com.moais.todo.api.todo.domain.Status;
import com.moais.todo.api.todo.dto.TodoRequest;
import com.moais.todo.api.todo.dto.TodoResponse;
import com.moais.todo.api.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity create(@RequestBody TodoRequest todoRequest) {
        todoService.create(todoRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> reads() {
        return ResponseEntity.ok(todoService.reads());
    }

    @GetMapping("/last")
    public ResponseEntity<TodoResponse> readLast() {
        return ResponseEntity.ok(todoService.readLast());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        todoService.update(id, todoRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/status/{id}")
    public ResponseEntity updateStatus(@PathVariable Long id, @RequestParam Status status) {
        todoService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
