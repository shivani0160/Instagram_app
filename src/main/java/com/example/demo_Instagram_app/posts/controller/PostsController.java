package com.example.demo_Instagram_app.posts.controller;

import com.example.demo_Instagram_app.posts.bean.Post;
import com.example.demo_Instagram_app.posts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostsController {
    @Autowired
    private PostRepository repository;

    //http://localhost:8080/posts
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPostDetails(@PathVariable String id) {
        Long ID = 0L;
        try {
            ID = Long.parseLong(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Optional<Post> post = repository.findById(ID);
        if (ID <= 0) {
            throw new RuntimeException("Invalid address, please enter positive id");
        }
        else if (post.isPresent()) {
            return  post.get();
        } else {
            throw new RuntimeException("Post not found with id" + id);
        }
    }

    @PostMapping("/posts")
    public void createPost(@RequestBody Post post) {

        repository.save(post);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable String id, @RequestBody Post post) {
        Long ID = 0L;
        try {
            ID = Long.parseLong(id);
        } catch (Exception e) {
            throw new RuntimeException("Invalid input, added value is a string please enter positive integer");
        }
        post.setId(ID);
        if (ID <= 0)
            throw new RuntimeException("Invalid address, please enter positive id");

        else if (getPostDetails(id) == null)
            throw new RuntimeException("Post not found with id " + id);
        else
            repository.save(post);

    }


    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable String id) {
        Long ID = 0L;
        try {
            ID = Long.parseLong(id);
        } catch (Exception e) {
            throw new RuntimeException("Invalid input, added value is a string please enter positive integer");
        }
        if (getPostDetails(id) == null)
            throw new RuntimeException(" Post not found with id " + id);
        else
            repository.deleteById(ID);
    }

}


