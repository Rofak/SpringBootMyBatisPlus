package com.example.springmybatisplusdemo.dto.response;

import com.example.springmybatisplusdemo.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private LocalDateTime published_date;
    private User user;
}
