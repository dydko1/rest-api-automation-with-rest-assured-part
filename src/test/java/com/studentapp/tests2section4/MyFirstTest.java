package com.studentapp.tests2section4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

    @DisplayName("Getting all the student from the databases")
    @Test
    public void getAllStudents() {
        RequestSpecification requestSpec = RestAssured.given();
        Response response = requestSpec.get("http://127.0.0.1:8080/student/list");
        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        RestAssured.given()
                .when()
                .get("http://127.0.0.1:8080/student/list")
                .then()
                .statusCode(200);
    }
}