package com.example.springmybatisplusdemo.dto.user;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserDto {
    @NotEmpty
    private String name;
    private int age;
    @Email
    private String email;
}
