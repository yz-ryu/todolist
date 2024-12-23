# 프로젝트명
> 투두블로그 프로젝트

개인 연습용 프로젝트로 사용자 인증, 글쓰기 기능, 할 일 등록 기능 구현.

![](../header.png)

## 개발 환경

Intelli J 
SpringBoot
H2DataBase
Window

## 프로젝트 구조

```
com/todolistblog/todolist_blog/
│
├── blog/
│   ├── Blog.java
│   ├── BlogController.java
│   ├── BlogRepository.java
│   ├── BlogService.java
│
├── securityconfig/
│   ├── SecurityConfig.java
│
├── todo/
│   ├── Todo.java
│   ├── TodoController.java
│   ├── TodoRepository.java
│   ├── TodoService.java
│   ├── TodoStatus.java
│
├── user/
│   ├── CustomUser.java
│   ├── User.java
│   ├── UserController.java
│   ├── UserRepository.java
│   ├── UserService.java
│
├── MainController.java
├── TodolistBlogApplication.java
│
└── resources/
    └── templates/
        ├── create.html
        ├── detail.html
        ├── list.html
        ├── login.html
        ├── main.html
        ├── register.html
        ├── todolist.html
        └── update.html

```
