package com.example.springmybatisplusdemo.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springmybatisplusdemo.entities.Post;
import com.example.springmybatisplusdemo.mapper.PostMapper;
import com.example.springmybatisplusdemo.service.PostService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl extends MPJBaseServiceImpl<PostMapper, Post> implements PostService {
}
