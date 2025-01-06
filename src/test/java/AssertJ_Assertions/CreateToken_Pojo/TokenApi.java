package AssertJ_Assertions.CreateToken_Pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class TokenApi {


    // Base URI:https://restful-booker.herokuapp.com
    // Base Path: /auth
    // Payload: {
    //    "username" : "admin",
    //    "password" : "password123"
    //}

    // Content-Type: application/json


    @Test
    public void createTokenWithPojo(){

        // **************Create pojo-**************************

        TokenPojo token=new TokenPojo();
        token.setUsername("admin");
        token.setPassword("password123");

        // 1. given()
        RequestSpecification request=RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/auth");
        request.contentType(ContentType.JSON);
        request.body(token); // token object goven to body

        // 2. when()
        Response response =request.log().all().when().post();

        // 3. then()
        ValidatableResponse vr =response.then().log().all().statusCode(200);

        // 4. Extract token
        String generatedToken=response.then().extract().path("token");

        // 5. Verify generated token is not null
        assertThat(generatedToken).isNotNull().isNotBlank().isNotEmpty();

    }


}
