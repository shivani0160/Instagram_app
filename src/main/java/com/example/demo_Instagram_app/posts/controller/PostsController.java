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
    public List<Post> getAllPosts(){
      return repository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPostDetails(@PathVariable long id){
        Optional<Post> post = repository.findById(id);
        if (post.isPresent()){
            return new Post();}
        else {
            throw new RuntimeException("Post not found with id"+ id);

        }
    }

    @PostMapping("/posts")
    public  void createPost(@RequestBody Post post){
        repository.save(post);
     }
    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable long id, @RequestBody Post post){
        repository.save(post);
    }
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id){
        repository.deleteById(id);
    }

}
