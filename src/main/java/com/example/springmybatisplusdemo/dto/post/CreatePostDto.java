package com.example.springmybatisplusdemo.dto.post;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CreatePostDto {
    @NotNull
    private int user_id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotNull
    private LocalDateTime published_date;
}
