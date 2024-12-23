package com.todolistblog.todolist_blog.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/main/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todolist")
    public String getTodoList(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "todolist";
    }

    @PostMapping("/todos")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/main/todos/todolist";
    }

    @PostMapping("/todolist/{id}/toggle")
    public String toggleStatus(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        todoService.toggleStatus(id);
        redirectAttributes.addAttribute("message", "완료로 변경되었습니다.");
        return "redirect:/main/todos/todolist";
    }

    @PostMapping("/todolist/{id}/delete")
    public String deleteTodo(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        todoService.deleteTodoById(id);
        redirectAttributes.addAttribute("message", "삭제되었습니다.");
        return "redirect:/main/todos/todolist";
    }
}