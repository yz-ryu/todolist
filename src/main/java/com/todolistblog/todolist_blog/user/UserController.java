package com.todolistblog.todolist_blog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String name, @RequestParam String password, @RequestParam String role) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setName(name);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setRole(role);
            userService.save(user);
            System.out.println("회원가입성공");
            System.out.println("로그인페이지로 이동");
            return "redirect:/login";

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원가입실패");
            return "register";
        }
    }
}