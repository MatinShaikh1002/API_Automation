package NonBDDStyle_APiTesting;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test_API_GET_001 {

    // Instance Variables
    RequestSpecification request;
    Response response;
    ValidatableResponse vr;

    @Description("Verify Get Request by Positive Input: 560016")
    @Test
        public void Test_GET_Request_POSITIVE(){

            String pincode = "560016";

            // Given()
            RequestSpecification request = RestAssured.given();
            request.baseUri("https://api.zippopotam.us");
            request.basePath("/IN/" + pincode);

            // When()
            Response response = request.when().log().all().get();

            // the()
            ValidatableResponse vr = response.then().log().all().statusCode(200);

        }

    @Description("Verify Get Request by Negative Input: -1")
    @Test
    public void Test_GET_Request_NEGATIVE(){

        String pincode = "-1";

        // Given()
        request = RestAssured.given();
        request.baseUri("https://api.zippopotam.us");
        request.basePath("/IN/" + pincode);

        // When()
        response = request.when().log().all().get();

        // the()
        vr = response.then().log().all().statusCode(404);

    }



}


