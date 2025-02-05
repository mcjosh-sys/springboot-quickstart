package com.mcjosh.database;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class DatabaseApplication {
//    private final DataSource dataSource;
//
//    public DatabaseApplication(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}
