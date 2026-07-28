package org.example.BaseTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class BaseAPITests {

    Properties prop;
    @BeforeClass
    public void setup(){

        try {
            FileInputStream fs = new FileInputStream("./properties/configProperties");
            prop = new Properties();
            prop.load(fs);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = prop.getProperty("APIURI");
    }

    public String generateString(int length){

        String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder rs = new StringBuilder();
        Random random = new Random();
        for(int i =0; i <length ; i++){
            int index = random.nextInt(Characters.length());
            rs.append(Characters.charAt(index));
        }

        return rs.toString();
    }

    public String generateEmail(int length){

        String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder rs = new StringBuilder();
        Random random = new Random();
        for(int i =0; i <length ; i++){
            int index = random.nextInt(Characters.length());
            rs.append(Characters.charAt(index));
        }

        return rs.toString()+"@gmail.com";
    }

    public String generateNumber(int length){

        String Characters = "0123456789";
        StringBuilder rs = new StringBuilder();
        Random random = new Random();
        for(int i =0; i <length ; i++){
            int index = random.nextInt(Characters.length());
            rs.append(Characters.charAt(index));
        }

        return rs.toString();
    }

    public int generateId(){
        Random randomInt = new Random();
        return randomInt.nextInt(90)+10;
    }
}
