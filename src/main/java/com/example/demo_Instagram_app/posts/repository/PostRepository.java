package com.example.demo_Instagram_app.posts.repository;

import com.example.demo_Instagram_app.posts.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
