package NonBDDStyle_APiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Test_PUT_004 {

    // Automate update booking API

    @Test
    public void UpdateBookingAPI(){

    // URL-bookingid-tokenid-ContentType(Header)-body

        String token="7939666149794eb";
        String bookingid="720";

        String payload="{\n" +
                "    \"firstname\" : \"Matin\",\n" +
                "    \"lastname\" : \"Shaikhu\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification request= RestAssured.given();
               request.baseUri("https://restful-booker.herokuapp.com");
               request.basePath("/booking/"+bookingid);
               request.cookie("token", token);
               request.contentType(ContentType.JSON);
               request.body(payload);

               // when()
                Response response =request.when().log().all().put();

                // then()
                ValidatableResponse vr =response.then().log().all();
                vr.statusCode(200);

    }

}
