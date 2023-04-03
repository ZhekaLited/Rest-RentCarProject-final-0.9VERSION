package com.example.restrentcarproject.service;

import com.example.restrentcarproject.model.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final CarsServiceImpl carsService;

    public CustomUserDetailsService(CarsServiceImpl carsService) {
        this.carsService = carsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = null;
        try {
            admin = carsService.findByUserAuth(username);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new org.springframework.security.core.userdetails.User(admin.getLogin(),
                admin.getPassword(), new ArrayList<>());
    }
}
