package com.dev.cicd.data.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DataTest {

    @Autowired
    Data data;

    @Test
    void health() {
        assertEquals(data.health(), "HEALTH CHECK OK!");
    }

    @Test
    void version() {
        assertEquals(data.version(), "The actual version is 1.0.0");
    }

    @Test
    void nationsLength() {
        Integer nationsLength = data.getRandomNations().size();
        assertEquals(nationsLength, 10);
    }

    @Test
    void foodsLength() {
        Integer foodsLength = data.getRandomFoods().size();
        assertEquals(foodsLength, 20);
    }


}