package com.codingdojo.firstproject2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class FirstprojectApplicationt {
        public static void main(String[] args) {
                SpringApplication.run(FirstprojectApplicationt.class, args);
        }
}