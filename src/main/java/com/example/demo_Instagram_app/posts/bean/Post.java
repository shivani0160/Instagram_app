package com.example.demo_Instagram_app.posts.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String message;

    public Post() {
    }

    public Post (long id, String message) {
        this.id = id;
        this.message = message;

    }


    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", message='" + message + '\'' + '}';
    }
}
