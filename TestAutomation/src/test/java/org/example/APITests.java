package org.example;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class APITests {

    @Test
    public void createUser(){
        String m = "{ \"username\": \"admin\", \"password\": \"password123\" }";

        given()
                .contentType("application/json")
                .body(m)
                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .statusCode(200)
                .log().all();

    }

}
