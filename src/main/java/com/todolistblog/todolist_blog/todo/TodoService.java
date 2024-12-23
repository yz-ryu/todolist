package com.todolistblog.todolist_blog.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void toggleStatus(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            if (todo.getStatus() == TodoStatus.COMPLETED) {
                todo.setStatus(TodoStatus.PENDING);
                todo.setCompletedDate(null);
            } else {
                todo.setStatus(TodoStatus.COMPLETED);
            }
            todoRepository.save(todo);
        }
    }
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }
}