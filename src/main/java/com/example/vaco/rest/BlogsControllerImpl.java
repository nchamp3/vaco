package com.example.vaco.rest;

import com.example.vaco.Model.PostRequestModel;
import com.example.vaco.database.BlogEntity;
import com.example.vaco.database.BlogService;
import com.example.vaco.database.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogsControllerImpl implements BlogsController {

    @Autowired
    BlogService blogService;

    @Override
    public List<BlogEntity> viewAllPosts() {
        return blogService.viewAllPosts();
    }

    @Override
    public ResponseEntity<BlogEntity> viewPostById(Integer id) {
        return blogService.viewPostById(id);
    }

    @Override
    public List<CategoryEntity> viewAllCategories() {
        return blogService.viewAllCategories();
    }

    @Override
    public BlogEntity createPost(PostRequestModel postRequestModel) {
        return blogService.createPost(postRequestModel);
    }

    @Override
    public ResponseEntity<?> updatePostById(Integer id, PostRequestModel postRequestModel) {
        return blogService.updatePostById(id, postRequestModel);
    }

    @Override
    public void deleteAllPosts() {
        blogService.deleteAllPosts();
    }

    @Override
    public void deletePostById(Integer id) {
        blogService.deletePostById(id);
    }
}
