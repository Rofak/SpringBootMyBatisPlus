package com.example.springmybatisplusdemo.mapper;
import com.example.springmybatisplusdemo.entities.Post;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface PostMapper extends MPJBaseMapper<Post> {
}
