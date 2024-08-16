package com.kosign.dev.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    Todo findByUser_UserId(Integer userId);

    Optional<Todo> findById(Long id);
}