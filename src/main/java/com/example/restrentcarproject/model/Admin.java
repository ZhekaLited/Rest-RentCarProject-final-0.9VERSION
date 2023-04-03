package com.example.restrentcarproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    public Long id;
    public String login;
    public String password;
    public String role;
}
