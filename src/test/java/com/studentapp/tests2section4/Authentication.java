package com.studentapp.tests2section4;

import io.restassured.http.Method;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication {


    @Test
    public void authenticateUserTest() {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        RequestSpecification request = RestAssured.given();


        String credentials = "TOOLSQA-Test:Test@@123";

        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());

        String encodedCredentialsAsString = new String(encodedCredentials);

        request.header("Authorization", "Basic " + encodedCredentialsAsString);

        String payload = "{\n" +
                "  \"userId\": \"9b5f49ab-eea9-45f4-9d66-bcf56a531b85\",\n" +
                "  \"collectionOfIsbns\": {\n" +
                "    \"isbn\": \"9781449331818\"\n" +
                "  }\n" +
                "}";

        request.header("Content-Type", "application/json");

        Response response = request.body(payload).post("/BookStore/v1/Books");

        System.out.println("Response Status Code is " + response.getStatusCode());

        response.prettyPrint();
    }

    @Test
    public void bearerTokenAuthenticationTest() {


        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        RequestSpecification request = RestAssured.given();

        String payload = "{\r\n" +
                "  \"userName\": \"TOOLSQA-Test\",\r\n" +
                "  \"password\": \"Test@@123\"\r\n" +
                "}";

        request.header("Content-Type", "application/json");

        Response responseFromGenerateToken = request.body(payload).post("/Account/v1/GenerateToken");

        responseFromGenerateToken.prettyPrint();

        String jsonString = responseFromGenerateToken.getBody().asString();

        String tokenGenerated = JsonPath.from(jsonString).get("token");

        request.header("Authorization", "Bearer " + tokenGenerated)
                .header("Content-Type", "application/json");

        String addBookDetails = "{\r\n" +
                "  \"userId\": \"a178a104-e3c0-4f50-bbd5-3e4919f063e8\",\r\n" +
                "  \"collectionOfIsbns\": [\r\n" +
                "    {\r\n" +
                "      \"isbn\": \"9781449325862\"\r\n" +
                "    }\r\n" +
                "  ]\r\n" +
                "}";

        Response addBooksResponse = request.body(addBookDetails).post("/BookStore/v1/Books");

        //Assertions.assertEquals(201, addBooksResponse.getStatusCode());

        addBooksResponse.prettyPrint();


    }

    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void GetWeatherDetailsCondensed()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        // Get the RequestSpecification of the request that is to be sent
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Call RequestSpecification.get() method to get the response.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("");

        // Response.asString method will directly return the content of the body
        // as String.
        System.out.println("Response Body is =>  " + response.prettyPrint());
    }
}