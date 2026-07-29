package org.example.BaseTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class APIData extends BaseAPITests {

    Random r = new Random();


    private String userName =  generateString(8);
    private String password = generateString(15);
    private String firstName = generateString(5);
    private String lastName = generateString(5);
    private String email = generateEmail(9);
    private String phone = generateNumber(10);
    private int userStatus = r.nextInt(2);
    private int idOfuser =  generateId();

    public HashMap UserData(){
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("id", idOfuser);
        hm.put("username", userName);
        hm.put("firstName", firstName);
        hm.put("lastName", lastName);
        hm.put("email", email);
        hm.put("password", password);
        hm.put("phone", phone);
        hm.put("userStatus", userStatus);

        for(Map.Entry<String,Object> m : hm.entrySet()){
            System.out.println(m.getKey() + ":" + m.getValue());
        }

        return hm;
    }

    public HashMap updatedUserData(){

        email = generateEmail(10);
        phone = generateString(8);

        HashMap<String,Object> hm = new HashMap<>();
        hm.put("id", idOfuser);
        hm.put("username", userName);
        hm.put("firstName", firstName);
        hm.put("lastName", lastName);
        hm.put("email", email);
        hm.put("password", password);
        hm.put("phone", phone);
        hm.put("userStatus", userStatus);

        for(Map.Entry<String,Object> m : hm.entrySet()){
            System.out.println(m.getKey() + ":" + m.getValue());
        }

        return hm;
    }
}
