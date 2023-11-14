package com.studentapp.tests2section4;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class FilterExampleTest extends BaseTest1 {

    @DisplayName("PostParameters")
    @Test
    void getStudent() {
        String response = RestAssured.given()
                .when()
                .get("/list")
                .asString();

        System.out.println(response);
    }
}