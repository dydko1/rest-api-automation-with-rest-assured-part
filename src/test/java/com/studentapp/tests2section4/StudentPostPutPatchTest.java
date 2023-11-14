package com.studentapp.tests2section4;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StudentPostPutPatchTest extends BaseTest1 {


    @DisplayName("PathParamteters")
    @Test
    void getTheFirstStudent2() {
        String payload = "{\n" +
                "\"firstName\": \"Murphy\",\n" +
                "\"lastName\": \"Holmes\",\n" +
                "\"email\": \"faucibus.orci1.luctus@Duisac.net111111\",\n" +
                "\"programme\": \"Financial Analysis\",\n" +
                "\"courses\": [\n" +
                "\"Accounting222\",\n" +
                "\"Statistics222\"\n" +
                "]\n" +
                "}";

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(payload)
                .post()
                .then()
                .statusCode(201);
    }

    @DisplayName("PostParameters")
    @Test
    void addPostSudent3() {
        List<String> courses = Arrays.asList(FAKER.job().keySkills(), FAKER.job().title());
        StudentPojo1 studentPojo1 = new StudentPojo1();

        studentPojo1
                .setFirstName(FAKER.name().firstName())
                .setLastName(FAKER.name().lastName())
                .setEmail(FAKER.internet().emailAddress())
                .setProgramme(FAKER.job().title())
                .setCourses(courses);

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(studentPojo1)
                .post()
                .then()
                .statusCode(201);

        Response response = given()
                .when()
                .get("/");
        response.prettyPrint();
    }

    @DisplayName("PostParameters")
    @Test
    void updatePutStudent3() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(studentData)
                .put("/1")
                .then()
                .statusCode(200);

        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }

    @DisplayName("PostParameters")
    @Test
    void updatePatchStudent4() {
        String id = "103";
        StudentPojo1 studentPojo2 = new StudentPojo1();
        studentPojo2
                .setEmail("Miro@wp.pmnmnl")
                .setFirstName("eeeeeeeeeeeeee");

        given().when()
                .contentType(ContentType.JSON)
                //.log()
                //.all()
                .body(studentPojo2)
                .patch(String.format(("/%s"), id))
                .then()
                .log()
                .all()
                .statusCode(200);

        Response response = given()
                .pathParam("id", id)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }

    @DisplayName("PostParameters")
    @Test
    void deletePatchStudent4() {

        given()
                .when()
                .contentType(ContentType.JSON)
                .delete("/1")
                .then()
                .statusCode(204);
    }
}