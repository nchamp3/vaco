package com.example.vaco.database;

import com.example.vaco.Model.PostRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<BlogEntity> viewAllPosts() {
        return blogRepository.findAll();
    }
    public ResponseEntity<BlogEntity> viewPostById(Integer Id) {
        Optional<BlogEntity> blogEntityById = blogRepository.findById(Id);
        if(blogEntityById.isPresent()) {
            return ResponseEntity.ok(blogEntityById.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<CategoryEntity> viewAllCategories() {
        return categoryRepository.findAll();
    }

    public BlogEntity createPost(PostRequestModel postRequestModel) {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle(postRequestModel.getTitle());
        blogEntity.setContents(postRequestModel.getContents());
        blogEntity.setTimestamp(LocalDate.now());
        blogEntity.setCategoryId(postRequestModel.getCategoryid());
        return blogRepository.save(blogEntity);
    }

    public ResponseEntity<?> updatePostById(Integer Id, PostRequestModel postRequestModel) {
        Optional<BlogEntity> blogEntityById = blogRepository.findById(Id);
        if(blogEntityById.isPresent()) {
            BlogEntity blogEntity = blogEntityById.get();
            blogEntity.setId(Id);
            blogEntity.setTitle(postRequestModel.getTitle());
            blogEntity.setContents(postRequestModel.getContents());
            blogEntity.setCategoryId(postRequestModel.getCategoryid());
            return ResponseEntity.ok(blogRepository.save(blogEntity));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void deleteAllPosts() {
        blogRepository.deleteAll();
    }

    public void deletePostById(Integer id) {
        blogRepository.deleteById(id);
    }
}
