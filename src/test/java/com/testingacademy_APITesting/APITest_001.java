package com.testingacademy_APITesting;

import io.restassured.RestAssured;
import org.apache.http.io.SessionOutputBuffer;

public class APITest_001 {

    public static void main(String[] args) {

        System.out.println("API Automation Started--");

    // Sample API-->api.zippopotam.us/IN/110001

        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/110001")
                .when().get()
                .then().log().all().statusCode(200);

    }

}
