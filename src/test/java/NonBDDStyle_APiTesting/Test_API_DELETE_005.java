package NonBDDStyle_APiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test_API_DELETE_005
{

    @Test
    public void deleteApi(){

        String bookingid="3242";
        String token="2a0221fa6c7e349";

        RequestSpecification request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/"+bookingid);
        request.cookie("token",token);
        request.contentType(ContentType.JSON);

        Response response =request.log().all().when().delete();
        response.then().log().all().statusCode(201);


    }


}
