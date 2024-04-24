package com.moais.todo.api.todo.repository;

import com.moais.todo.api.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
