package com.example.mysql.mysqlcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MysqlCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlCrudApplication.class, args);
    }

}
