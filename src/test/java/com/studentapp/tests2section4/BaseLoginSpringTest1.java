package com.studentapp.tests2section4;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.List;

public class BaseLoginSpringTest1 {

    protected static SessionFilter filter;

    @BeforeAll
    protected static void init() {
        filter = new SessionFilter();
        RestAssured.baseURI = "http://127.0.0.1:8080";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
        RestAssured.given()
                .auth()
                .form("user", "user", new FormAuthConfig("/login", "uname", "pwd"))
                .filter(filter)
                .get();
    }
}
