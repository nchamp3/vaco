package com.example.vaco.database;

import com.example.vaco.model.BlogPost;
import com.example.vaco.model.PostRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BlogDao {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<BlogPost> viewAllPosts() {
        return blogRepository.findAll();
    }
    public Optional<BlogPost> viewPostById(Integer Id) {
        Optional<BlogPost> blogPostById = blogRepository.findById(Id);
        return blogPostById;
//        if(blogPostById.isPresent()) {
//            return blogPostById.get();
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<CategoryEntity> viewAllCategories() {
        return categoryRepository.findAll();
    }

    public BlogPost createPost(PostRequestModel postRequestModel) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(postRequestModel.getTitle());
        blogPost.setContents(postRequestModel.getContents());
        blogPost.setTimestamp(LocalDate.now());
        blogPost.setCategoryId(postRequestModel.getCategoryid());
        return blogRepository.save(blogPost);
    }

    public HttpStatus updatePostById(Integer Id, PostRequestModel postRequestModel) {
        Optional<BlogPost> blogPostById = blogRepository.findById(Id);
        if(blogPostById.isPresent()) {
            BlogPost blogPost = blogPostById.get();
            blogPost.setId(Id);
            blogPost.setTitle(postRequestModel.getTitle());
            blogPost.setContents(postRequestModel.getContents());
            blogPost.setCategoryId(postRequestModel.getCategoryid());
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }

    public void deleteAllPosts() {
        blogRepository.deleteAll();
    }

    public void deletePostById(Integer id) {
        blogRepository.deleteById(id);
    }
}
