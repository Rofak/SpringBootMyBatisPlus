package com.example.springmybatisplusdemo.dto.post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdatePostDto {
    @NotNull
    private int id;
    private Integer user_id;
    private String title;
    private String content;
    private LocalDateTime published_date;
}
