package com.studentapp.tests2section4;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StudentListTest extends BaseLoginSpringTest1 {

    @DisplayName("Get all students")
    @Test
    void getAllStudentsTest() {
        RestAssured.given()
                .sessionId(filter.getSessionId())
                .get("/list")
                .then()
                .log()
                .all();
    }
}