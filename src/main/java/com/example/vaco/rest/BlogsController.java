package com.example.vaco.rest;

import com.example.vaco.Model.PostRequestModel;
import com.example.vaco.database.BlogEntity;
import com.example.vaco.database.CategoryEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blogs")
public interface BlogsController {

    @GetMapping("/posts")
    public List<BlogEntity> viewAllPosts();

    @GetMapping("/posts/{id}")
    public ResponseEntity<BlogEntity> viewPostById(@PathVariable Integer id);

    @GetMapping("categories")
    public List<CategoryEntity> viewAllCategories();

    @PostMapping("/posts")
    public BlogEntity createPost(@RequestBody PostRequestModel postRequestModel);

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> updatePostById(@PathVariable Integer id, @RequestBody PostRequestModel postRequestModel);

    @DeleteMapping("/posts")
    public void deleteAllPosts();

    @DeleteMapping("/posts/{id}")
    public void deletePostById(@PathVariable Integer id);


}
