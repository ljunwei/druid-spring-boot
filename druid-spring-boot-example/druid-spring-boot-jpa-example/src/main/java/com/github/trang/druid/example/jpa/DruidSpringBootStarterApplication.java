package com.github.trang.druid.example.jpa;

import com.github.trang.druid.example.jpa.repository.CityRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DruidSpringBootStarterApplication
 *
 * @author trang
 */
@SpringBootApplication
public class DruidSpringBootStarterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.setProperty("druid.logType", "slf4j");
        SpringApplication.run(DruidSpringBootStarterApplication.class, args);
    }

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String... args) {
        Gson gson = new Gson();
        cityRepository.findAll().stream()
                .map(gson::toJson)
                .forEach(System.out::println);
    }

}