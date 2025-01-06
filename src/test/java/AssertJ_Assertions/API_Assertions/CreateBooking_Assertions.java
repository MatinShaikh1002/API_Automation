package AssertJ_Assertions.API_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class CreateBooking_Assertions {

@Test
public void CreateBookingAPI(){

    String paylod=

            "{\n" +
                    "    \"firstname\" : \"Jim\",\n" +
                    "    \"lastname\" : \"Brown\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";

    // Given()
    RequestSpecification request= RestAssured.given();
    request.baseUri("https://restful-booker.herokuapp.com/");
    request.basePath("/booking");
    request.contentType(ContentType.JSON);
    request.body(paylod).log().all();

    // when()
    Response response =request.log().all().when().post();

    //then()
    ValidatableResponse vr =response.then().log().all().statusCode(200);

    // Extract response using AssertJ
    Integer bookingid=response.then().extract().path("bookingid");
    String firstname=response.then().extract().path("booking.firstname");
    String lastname=response.then().extract().path("booking.lastname");

    // Apply AssertJ

    assertThat(bookingid).isNotNull();
    assertThat(firstname).isEqualTo("Jim").isNotNull();
    assertThat(lastname).isEqualTo("Brown").isNotNull();





}



}
