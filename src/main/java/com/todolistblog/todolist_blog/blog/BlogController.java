package com.todolistblog.todolist_blog.blog;

import com.todolistblog.todolist_blog.user.CustomUser;
import com.todolistblog.todolist_blog.user.User;
import com.todolistblog.todolist_blog.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/main/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "list";
    }

    @GetMapping("/create")
    public String createBlogForm() {
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@RequestParam String title, @RequestParam String content, Principal principal, Model model) {
        CustomUser customUser = (CustomUser) userService.loadUserByUsername(principal.getName());
        User user = customUser.getUser();
        blogService.createBlog(title, content, user);
        return "redirect:/main/blogs/list";
    }

    @GetMapping("/list/detail/{id}")
    public String getBlogDetails(@PathVariable Long id, Model model) {
        Blog blog = blogService.getBlogById(id).orElseThrow(() ->
                new RuntimeException("Blog not found"));
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping("/list/detail/{id}/update")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.getBlogById(id).orElse(null);
        if (blog == null) {
            return "redirect:/main/blogs/list";
        }
        model.addAttribute("blog", blog);
        return "update";
    }

    @PostMapping("/list/detail/{id}/update")
    public String updateBlog(@PathVariable Long id, @RequestParam String title, @RequestParam String content, Principal principal) {
        CustomUser customUser = (CustomUser) userService.loadUserByUsername(principal.getName());
        User user = customUser.getUser();
        blogService.updateBlog(id, title, content, user);
        return "redirect:/main/blogs/list";
    }

    @PostMapping("/list/detail/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "redirect:/main/blogs/list";
    }
}
