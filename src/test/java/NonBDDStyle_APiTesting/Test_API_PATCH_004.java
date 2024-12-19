package NonBDDStyle_APiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test_API_PATCH_004 {


@Test
    public void PatchRequest(){

    String bookingid="601";
    String token="9ce7c63c07f28b9";

    String payload="{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Shaikh\"\n" +
            "}";

    RequestSpecification request= RestAssured.given();
    request.baseUri("https://restful-booker.herokuapp.com");
    request.basePath("/booking/"+bookingid);
    request.cookie("token",token);
    request.contentType(ContentType.JSON);
    request.body(payload);

    // when()
    Response response =request.log().all().when().patch();

    // then()
    ValidatableResponse vr =response.then().log().all().statusCode(200);

}


}
