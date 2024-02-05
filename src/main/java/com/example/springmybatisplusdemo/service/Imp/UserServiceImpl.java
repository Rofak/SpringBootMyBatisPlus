package com.example.springmybatisplusdemo.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springmybatisplusdemo.dto.response.UserResponse;
import com.example.springmybatisplusdemo.entities.User;
import com.example.springmybatisplusdemo.mapper.UserMapper;
import com.example.springmybatisplusdemo.repository.UserRepository;
import com.example.springmybatisplusdemo.service.UserService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends MPJBaseServiceImpl<UserMapper, User> implements UserService {
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
    }
    @Override
    public List<UserResponse> selectByProvider() {
        return repository.selectUserAddressAndPost();
    }
}
