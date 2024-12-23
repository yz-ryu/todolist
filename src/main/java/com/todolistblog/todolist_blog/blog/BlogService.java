package com.todolistblog.todolist_blog.blog;

import com.todolistblog.todolist_blog.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public List<Blog> getBlogsByUser(User user) {
        return blogRepository.findByAuthor(user);
    }

    public Blog createBlog(String title, String content, User author) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(author);
        return blogRepository.save(blog);
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public void updateBlog(Long id, String title, String content, User user) {
        Blog blog = blogRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid blog Id:" + id));
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUpdatedAt(LocalDateTime.now());
        blog.setAuthor(user);
        blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
