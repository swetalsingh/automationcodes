package org.example.APITest;

import org.example.BaseTest.BaseAPITests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class APITests extends BaseAPITests {

    private int idOfUser = generateNumber(9);
    private String userName = generateString(7);
    private String Password = generateString(15);
    private String firstName = generateString(5);
    private String lastName = generateString(5);
    private String emailaddress = generateEmail(7);
    private String phoneNumber = String.valueOf(generateNumber(10));


    @Test(enabled = true, priority = 1)
    public void createUser(){
        String requestAPIBody =
        "{"
        + "\"id\" : " +idOfUser + ","
        + "\"username\" :\"" + userName  + "\","
        + "\"firstName\" : \"" + firstName+ "\","
        + "\"lastName\" : \"" +  lastName+ "\","
        + "\"email\" :\"" + emailaddress+ "\","
        + "\"password\" : \"" + Password+ "\","
        + "\"phone\" :\"" + phoneNumber+ "\","
        + "\"userStatus\" :" + 0
        +"}" ;

        System.out.println(requestAPIBody);
        given()
                .contentType("application/json")
                .body(requestAPIBody)
                .when()
                .post(baseURI + "/user")
                .then()
                .statusCode(200)
                .body("code",equalTo(200))
                .body("message", equalTo(String.valueOf(idOfUser)))
                .log().all();

    }

    @Test(enabled = true, priority = 2)
    public void getUser() {
        given().
                when()
                .get(baseURI + "/user/" + userName)
                .then()
                .statusCode(200)
                .body("id",equalTo(idOfUser))
                .body("firstName", equalTo(firstName))
                .body("phone", equalTo(phoneNumber))
                .log().all();
    }

    @Test(enabled = true, priority = 3)
    public void updateUser() {

        emailaddress = generateEmail(10);
        phoneNumber = String.valueOf(generateNumber(8));

        String requestAPIBody =
                         "{"
                        + "\"id\" : " +idOfUser + ","
                        + "\"username\" :\"" + userName  + "\","
                        + "\"firstName\" : \"" + firstName+ "\","
                        + "\"lastName\" : \"" +  lastName+ "\","
                        + "\"email\" :\"" + emailaddress+ "\","
                        + "\"password\" : \"" + Password+ "\","
                        + "\"phone\" :\"" + phoneNumber+ "\","
                        + "\"userStatus\" :" + 0
                        +"}" ;

        System.out.println(requestAPIBody);

        given()
                .contentType("application/json")
                .body(requestAPIBody)
                .when()
                .put(baseURI + "/user/" + userName)
                .then()
                .statusCode(200)
                .body("message",equalTo(String.valueOf(idOfUser)))
                .log().all();

        System.out.println(requestAPIBody);
        getUser();
    }

    @Test(enabled = true, priority = 4)
    public void DeleteUser() {

        given()
                .when()
                .delete(baseURI + "/user/" + userName)
                .then()
                .statusCode(200)
                .body("message",equalTo(userName))
                .log().all();
    }

}
