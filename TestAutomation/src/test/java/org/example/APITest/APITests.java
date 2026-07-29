package org.example.APITest;

import org.example.BaseTest.APIData;
import org.example.BaseTest.BaseAPITests;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class APITests extends BaseAPITests {

    APIData data = new APIData();

    HashMap<String,Object> requestAPIBody = data.UserData();

    @Test(enabled = true, priority = 1)
    public void createUser(){

        given()
                .contentType("application/json")
                .body(requestAPIBody)
                .when()
                .post(baseURI + "/user")
                .then()
                .statusCode(200)
                .body("code",equalTo(200))
                .body("message", equalTo(String.valueOf(requestAPIBody.get("id"))))
                .log().all();

    }

     @Test(enabled = true, priority = 2)
    public void getUser() {
        given().
                when()
                .get(baseURI + "/user/" + requestAPIBody.get("username"))
                .then()
                .statusCode(200)
                .body("id",equalTo(requestAPIBody.get("id")))
                .body("firstName", equalTo(requestAPIBody.get("firstName")))
                .body("userStatus", equalTo(requestAPIBody.get("userStatus")))
                .log().all();
    }

    @Test(enabled = true, priority = 3)
    public void updateUser() {

        HashMap updatedRequestBody = data.updatedUserData();

        given()
                .contentType("application/json")
                .body(updatedRequestBody)
                .when()
                .put(baseURI + "/user/" + requestAPIBody.get("username"))
                .then()
                .statusCode(200)
                .body("message",equalTo(String.valueOf(requestAPIBody.get("id"))))
                .log().all();

        getUser();
    }

    @Test(enabled = true, priority = 4)
    public void DeleteUser() {

        given()
                .when()
                .delete(baseURI + "/user/" + requestAPIBody.get("username"))
                .then()
                .statusCode(200)
                .body("message",equalTo(requestAPIBody.get("username")))
                .log().all();
    }

    @Test(enabled = true, priority = 5)
    public void getDeletedUser() {
        given().
                when()
                .get(baseURI + "/user/" + requestAPIBody.get("username"))
                .then()
                .statusCode(404)
                .body("message",equalTo("User not found"))
                .log().all();
    }

}
