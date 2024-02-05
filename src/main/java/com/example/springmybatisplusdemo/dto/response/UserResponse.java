package com.example.springmybatisplusdemo.dto.response;

import com.example.springmybatisplusdemo.entities.Address;
import com.example.springmybatisplusdemo.entities.Post;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserResponse implements Serializable {
    private int id;
    private String name;
    private Integer age;
    private String email;
    private List<Post> posts;
    private Address address;
}
