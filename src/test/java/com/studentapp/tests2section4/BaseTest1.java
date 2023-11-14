package com.studentapp.tests2section4;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.List;

public class BaseTest1 {

    protected static final Faker FAKER = new Faker();
    protected List<String> courses = Arrays.asList(FAKER.job().keySkills(), FAKER.job().title());
    protected StudentPojo1 studentData = new StudentPojo1()
            .setFirstName(FAKER.name().firstName())
            .setLastName(FAKER.name().lastName())
            .setEmail(FAKER.internet().emailAddress())
            .setProgramme(FAKER.job().title())
            .setCourses(courses);

    @BeforeAll
    protected static void init() {
        RestAssured.baseURI = "http://127.0.0.1:8080";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";


    }
}
