package BDDStyle_APITesting;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GET {

    @Test
    public void Test_GET_Request_POSITIVE() {

        String pincode = "560016";
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

    }

    @Test
    public void Test_GET_Request_NEGATIVE() {

        String pincode = "-1";
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);

    }


}
