package com.moais.todo.api.user.repository;

import com.moais.todo.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
