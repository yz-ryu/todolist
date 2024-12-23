package com.todolistblog.todolist_blog.blog;

import com.todolistblog.todolist_blog.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByAuthor(User author);
}
