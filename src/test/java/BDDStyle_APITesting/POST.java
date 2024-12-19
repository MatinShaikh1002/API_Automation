package BDDStyle_APITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class POST {

    @Test
    public void BDDStyle_POST_Request(){

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(payload)

                .when().log().all().post()

                .then().log().all().statusCode(200);

    }



}




