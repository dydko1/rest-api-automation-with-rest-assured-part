package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateStudentStringPayloadTest extends TestBase {

	@DisplayName("Create a new student by sending payload as String")
	@Test
	void createNewStudent() {
		
		String payload = "{\"firstName\":\"Miro1\",\"lastName\":\"User1\",\"email\":\"test5@gmail1.com\",\"programme\":\"ComputerScience\",\"courses\":[\"C++\",\"JAVA\"]}";
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(payload)
		.post()
		.then()
		.statusCode(201);
	}
}
