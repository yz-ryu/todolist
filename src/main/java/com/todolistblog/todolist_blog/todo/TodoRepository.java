package com.todolistblog.todolist_blog.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(TodoStatus status);
    List<Todo> findByDueDateBefore(LocalDate dueDate);
}