package com.kosign.dev.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {


     Todo findByUser_UserId(Integer userId);

    Optional<Todo> findById(Long id);

}