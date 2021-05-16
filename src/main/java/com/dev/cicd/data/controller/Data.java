package com.dev.cicd.data.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController("/")
public class Data {


    @GetMapping("/health")
    public String health() {
        return "HEALTH CHECK OK!";
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.0";
    }


    @GetMapping("/nations")
    public JsonNode getRandomNations() {
        ObjectMapper objectMapper = new ObjectMapper();
        Faker faker = new Faker(new Locale("en-US"));
        ArrayNode nations = objectMapper.createArrayNode();
        for (int i = 0; i < 10; i++) {
            nations.add(objectMapper.createObjectNode()
                    .put("nationality", faker.nation().nationality())
                    .put("capitalCity", faker.nation().capitalCity())
                    .put("flag", faker.nation().flag())
                    .put("language", faker.nation().language()));
        }
        return nations;
    }

    @GetMapping("/foods")
    public JsonNode getRandomFoods() {
        ObjectMapper objectMapper = new ObjectMapper();
        Faker faker = new Faker(new Locale("en-US"));
        ArrayNode foods = objectMapper.createArrayNode();
        for (int i = 0; i < 20; i++) {
            foods.add(objectMapper.createObjectNode()
                    .put("ingredients", faker.food().ingredient())
                    .put("spices", faker.food().spice())
                    .put("measurements", faker.food().measurement()));
        }
        return foods;
    }

}
