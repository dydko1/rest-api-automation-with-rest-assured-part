package com.studentapp.tests2section4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class MyFirst2Test extends BaseTest1 {

    @DisplayName("Getting all the student from the databases")
    @Test
    public void getAllStudents() {
        given()
                .when()
                .get("http://127.0.0.1:8080/student/list")
                .then()
                .statusCode(200);
    }

    @DisplayName("Getting all the student from the databases")
    @Test
    public void getSingleStudent() {

        Map<String, Object> params = new HashMap<>();
        params.put("programme", "Computer Science");
        params.put("limit", "1");

        Response response =
                given()
                        .queryParams(params)
                        .when()
                        //.queryParam("programme", "Computer Science")
                        //.queryParam("programme", "Computer Science", "limit", "1")
                        .get("http://127.0.0.1:8080/student/list");
        //.then()
        //.statusCode(200);
        response.prettyPrint();
    }

    @DisplayName("PathParameters")
    @Test
    void getTheFirstStudent() {
        Response response = given()
                .pathParam("id", 4)
                .when()
                .get("http://127.0.0.1:8080/student/{id}");
        response.prettyPrint();
    }

    @DisplayName("PathParamteters")
    @Test
    void getTheFirstStudent2() {
        Response response = given()
                .pathParam("id", 5)
                .when()
                .get("/{id}");
        response.prettyPrint();
        RestAssured.reset();
    }
}