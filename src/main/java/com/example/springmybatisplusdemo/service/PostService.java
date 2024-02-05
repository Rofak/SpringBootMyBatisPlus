package com.example.springmybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springmybatisplusdemo.entities.Post;
import com.github.yulichang.base.MPJBaseService;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PostService extends MPJBaseService<Post> {
}
