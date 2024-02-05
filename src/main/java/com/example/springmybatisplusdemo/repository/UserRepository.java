package com.example.springmybatisplusdemo.repository;

import com.example.springmybatisplusdemo.dto.response.UserResponse;
import com.example.springmybatisplusdemo.entities.Address;
import com.example.springmybatisplusdemo.entities.Post;
import com.example.springmybatisplusdemo.repository.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserRepository {

    @SelectProvider(value = UserProvider.class,method = "selectUser")
    @Results({
            @Result(column = "address_id",property = "address",one = @One(select="selectAddressById")),
            @Result(column = "id",property = "posts",many = @Many(select = "selectPostByUserId")),
            @Result(column = "id",property = "id")
    })
    List<UserResponse> selectUserAddressAndPost();

    @SelectProvider(value = UserProvider.class,method = "selectAddressById")
    Address selectAddressById(int address_id);

    @SelectProvider(value = UserProvider.class,method = "selectPostByUserId")
    @Results({
            @Result(column = "user_id",property = "user_id"),
            @Result(column = "publishedDate",property = "published_date")
    })
    Post selectPostByUserId(int userId);
}
