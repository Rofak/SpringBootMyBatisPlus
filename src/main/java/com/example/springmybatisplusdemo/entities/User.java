package com.example.springmybatisplusdemo.entities;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    private int id;
    private Integer address_id;
    private String name;
    private Integer age;
    private String email;
}
