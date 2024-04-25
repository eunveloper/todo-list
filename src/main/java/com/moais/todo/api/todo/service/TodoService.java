package com.moais.todo.api.todo.service;


import com.moais.todo.api.todo.domain.Status;
import com.moais.todo.api.todo.domain.Todo;
import com.moais.todo.api.todo.dto.TodoRequest;
import com.moais.todo.api.todo.dto.TodoResponse;
import com.moais.todo.api.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void create(TodoRequest todoRequest) {
        todoRepository.save(new Todo(todoRequest));
    }

    public List<TodoResponse> reads() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream()
                .map(TodoResponse::of)
                .collect(Collectors.toList());
    }

    public TodoResponse readLast() {
        Todo todo = todoRepository.findFirstByOrderByIdDesc();
        return TodoResponse.of(todo);
    }

    public void update(Long id, TodoRequest todoRequest) {
        Todo todo = todoRepository.findById(id).orElseThrow(RuntimeException::new);
        todo.update(todoRequest);
    }

    public void updateStatus(Long id, Status status) {
        Todo todo = todoRepository.findById(id).orElseThrow(RuntimeException::new);
        todo.updateStatus(status);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

}
