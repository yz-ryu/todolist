package com.todolistblog.todolist_blog;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String redirectToMain() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainPage(Principal principal) {
        return "main";
    }
}