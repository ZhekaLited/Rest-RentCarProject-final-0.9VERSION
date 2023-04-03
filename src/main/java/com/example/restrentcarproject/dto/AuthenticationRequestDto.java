package com.example.restrentcarproject.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AuthenticationRequestDto {
    @Id
    private Long id;
    private String login;
    private String password;
    private String role;
}
