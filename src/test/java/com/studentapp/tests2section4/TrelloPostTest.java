package com.studentapp.tests2section4;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TrelloPostTest extends BaseTrelloTest {

    @DisplayName("Trello Parameters")
    @Test
    void addPostTrelloTest() {
        Map<String, String > params = new HashMap<>();
        params.put("name", "RestAssured 14ggfdgfd.11.2023");
        params.put("key", KEY);
        params.put("token", TOKEN);

        given()
                .contentType(ContentType.XML) // wszystko łyka
                .queryParams(params)
                .log()
                .all()
                .post()
                .then()
                .statusCode(200);
    }
}