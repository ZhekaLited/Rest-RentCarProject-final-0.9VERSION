package com.example.restrentcarproject;

import com.example.restrentcarproject.imageStorage.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        FileStorageProperties.class
})
@SpringBootApplication
public class RestRentCarProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestRentCarProjectApplication.class, args);
    }
}
