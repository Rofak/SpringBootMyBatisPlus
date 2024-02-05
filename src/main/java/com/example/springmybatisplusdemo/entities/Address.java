package com.example.springmybatisplusdemo.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("address")
@Data
public class Address {
    private Integer id;
    private String city;
    private String address1;
    private String address2;

}
