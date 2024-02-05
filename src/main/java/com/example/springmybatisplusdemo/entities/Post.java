package com.example.springmybatisplusdemo.entities;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "post",autoResultMap = true)
@NoArgsConstructor
public class Post implements Serializable {
    @TableId
    private int id;
    private Integer user_id;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("publishedDate")
    private LocalDateTime published_date;
}
