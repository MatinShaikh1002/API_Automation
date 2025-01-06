package AssertJ_Assertions.API_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBooking_UsingMapPayload {

    // Converting payload into Map

    @Test
    public void CreateBookingAPI(){

       /* // Normal Payload
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
                        "}";*/

        // ************* Convert payload into Map-***************************

        Map<String,Object> payloadMap=new LinkedHashMap<>();
        payloadMap.put("firstname","Jim");
        payloadMap.put("lastname","Brown");
        payloadMap.put("totalprice",111);
        payloadMap.put("depositpaid",true);

        // Bookingdates is also has two dates-Checkin and Checkout
        Map<String,Object> bookingDatesMap=new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        // put bookingDatesMap into payloadMap
        payloadMap.put("bookingdates",bookingDatesMap);
        payloadMap.put("additionalneeds","Breakfast");


        // Given()
        RequestSpecification request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("/booking");
        request.contentType(ContentType.JSON);
        request.body(payloadMap).log().all(); // Assigned PayloadMap Object

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
