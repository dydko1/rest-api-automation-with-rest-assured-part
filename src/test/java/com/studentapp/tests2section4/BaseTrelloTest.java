package com.studentapp.tests2section4;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTrelloTest {
    protected static final String KEY = "6f04eeee897329faa9261fe2bca35a0b";
    protected static final String TOKEN = "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83";

    @BeforeAll
    protected static void init() {
        RestAssured.baseURI = "https://api.trello.com";
        RestAssured.basePath = "/1/boards";
    }
}
