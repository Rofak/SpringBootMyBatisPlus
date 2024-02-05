package com.example.springmybatisplusdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springmybatisplusdemo.dto.post.CreatePostDto;
import com.example.springmybatisplusdemo.dto.post.UpdatePostDto;
import com.example.springmybatisplusdemo.dto.response.PostResponse;
import com.example.springmybatisplusdemo.entities.Post;
import com.example.springmybatisplusdemo.entities.User;
import com.example.springmybatisplusdemo.service.PostService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "Post Controller")
@RequestMapping("/api/post")
public class PostController {
    private PostService postService;
    private ModelMapper modelMapper;
    public PostController(PostService postService,ModelMapper modelMapper){
        this.postService=postService;
        this.modelMapper=modelMapper;
    }

    @GetMapping
    public Map<String,Object> list(@RequestParam int pageNum,@RequestParam int pageSize){
        Map<String,Object> pagination=new HashMap<>();
        MPJLambdaWrapper<Post> wrapper = new MPJLambdaWrapper<Post>()
                .selectAll(Post.class)
                .selectAssociation(User.class, PostResponse::getUser)
                .leftJoin(User.class, User::getId, Post::getUser_id);
        IPage<PostResponse>postResponsePage=postService.selectJoinListPage(new Page<>(pageNum,pageSize),PostResponse.class, wrapper);
        pagination.put("count",postResponsePage.getTotal());
        pagination.put("current",postResponsePage.getCurrent());
        pagination.put("data",postResponsePage.getRecords());
        pagination.put("totalPage",postResponsePage.getPages());
        return pagination;
    }
    @PostMapping
    public boolean save(@Valid @RequestBody CreatePostDto createPostDto){
        Post post=modelMapper.map(createPostDto,Post.class);
       return postService.save(post);
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable int id){
        MPJLambdaWrapper<Post> wrapper=new MPJLambdaWrapper<Post>()
                .selectAll(Post.class)
                .selectAssociation(User.class,PostResponse::getUser)
                .leftJoin(User.class,User::getId,Post::getUser_id)
                .eq(Post::getId,id);
       return postService.selectJoinOne(PostResponse.class,wrapper);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return  postService.removeById(id);
    }

    @PutMapping()
    public boolean update(@RequestBody UpdatePostDto updatePostDto){
        Post post= modelMapper.map(updatePostDto,Post.class);
        return postService.updateById(post);
    }
}
