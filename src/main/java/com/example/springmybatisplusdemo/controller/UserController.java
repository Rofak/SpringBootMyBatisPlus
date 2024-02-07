package com.example.springmybatisplusdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springmybatisplusdemo.dto.response.UserResponse;
import com.example.springmybatisplusdemo.dto.user.CreateUserDto;
import com.example.springmybatisplusdemo.dto.user.UpdateUserDto;
import com.example.springmybatisplusdemo.entities.Post;
import com.example.springmybatisplusdemo.entities.User;
import com.example.springmybatisplusdemo.service.UserService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "User Controller")
@RestController()
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService,ModelMapper modelMapper){
        this.userService=userService;
        this.modelMapper=modelMapper;
    }

    @GetMapping
    public Map<String,Object> getAllUsers(@RequestParam int pageNum, @RequestParam int pageSize) {
        MPJLambdaWrapper<User> lambdaWrapper=new MPJLambdaWrapper<User>()
                .selectAll(User.class)
                .selectCollection(Post.class,UserResponse::getPosts)
                .leftJoin(Post.class,Post::getUser_id,User::getId);
        IPage<UserResponse> page=userService.selectJoinListPage(new Page<>(pageNum,pageSize), UserResponse.class,lambdaWrapper);
        Map<String,Object> pagination=new HashMap<>();
        pagination.put("count",page.getTotal());
        pagination.put("current",page.getCurrent());
        pagination.put("data",page.getRecords());
        pagination.put("totalPage",page.getPages());
        return pagination;
    }

    @Cacheable(value = "user",key = "#id")
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable int id){
        MPJLambdaWrapper<User> lambdaWrapper=new MPJLambdaWrapper<User>()
                .selectAll(User.class)
                .selectCollection(Post.class,UserResponse::getPosts)
                .leftJoin(Post.class,Post::getUser_id,User::getId)
                .eq(User::getId,id);
        UserResponse user=userService.selectJoinOne(UserResponse.class,lambdaWrapper);
        return user;
    }

    @PostMapping()
    public boolean save(@Valid @RequestBody CreateUserDto createUserDto){
        User user= modelMapper.map(createUserDto,User.class);
       return userService.save(user);
    }

    @CachePut(value = "user",key = "#updateUserDto.id")
    @PutMapping()
    public UserResponse update(@RequestBody UpdateUserDto updateUserDto) throws NotFoundException {
        User user=modelMapper.map(updateUserDto,User.class);
        boolean isUpdate=userService.updateById(user);
        if(!isUpdate){
            throw new NotFoundException("User Not Found");
        }
        user=userService.getById(user.getId());
        UserResponse userResponse=modelMapper.map(user,UserResponse.class);
        return userResponse;
    }

    @CacheEvict(value = "user",allEntries = true)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return userService.removeById(id);
    }

    @GetMapping("/provider")
    public List<UserResponse> selectUserByProvider(){
        return userService.selectByProvider();
    }

    @GetMapping("/mapper-xml")
    public User getUserByXml(){
        return this.userService.selectByMapperXml();
    }
}
