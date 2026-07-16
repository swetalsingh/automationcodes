package org.example;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.containsString;

public class APITests {

    @Test
    public void getToken(){
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

    @Test
    public void getBookingids() {
        given().when().get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .body(containsString("bookingid"))
                .log().all();


    }

}
