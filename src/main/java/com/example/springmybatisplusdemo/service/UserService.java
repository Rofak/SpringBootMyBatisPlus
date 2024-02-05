package com.example.springmybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springmybatisplusdemo.dto.response.UserResponse;
import com.example.springmybatisplusdemo.entities.User;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

public interface UserService extends MPJBaseService<User> {
    List<UserResponse> selectByProvider();
}
