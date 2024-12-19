package NonBDDStyle_APiTesting;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test_API_POST_002 {

    @Test
    public void NonBDD_Post_Request(){

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // given()
        RequestSpecification request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/auth");
        request.contentType(ContentType.JSON);
        request.body(payload);

        // when()
        Response response=request.log().all().when().post();

        // then()
        ValidatableResponse vr=response.then().log().all().statusCode(200);


}

}






