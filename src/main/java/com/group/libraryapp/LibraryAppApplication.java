package com.group.libraryapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryAppApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load(); // 환경 변수 로드
        SpringApplication.run(LibraryAppApplication.class, args);
    }

}
