package AssertJ_Assertions.Serialization_Deserialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateBookingAPI {

    @Test
    public void Serialization_DeSerialization(){

       /* String payload="{\n" +
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
*/
        // Convert payload into POJO

        Booking booking=new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        Bookingdates bookingdate=new Bookingdates();
        bookingdate.setCheckin("2018-01-01");
        bookingdate.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdate);
        booking.setAdditionalneeds("Breakfast");

        // Convert Java Object to Json String(Serialization)
        Gson gson=new Gson();
        String jsonString=gson.toJson(booking);

        // 1. given()
        RequestSpecification request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("/booking");
        request.body(jsonString);
        request.contentType(ContentType.JSON);


        // 2. when()
        Response response = request.log().all().when().post();
        String jsonResponseString= response.asString();

        // 3. then()
        ValidatableResponse vr =response.then().log().all().statusCode(200);

        // Case 4 Deserialization Extraction--> Recommended
        ResponseBody responsebody=gson.fromJson(jsonResponseString,ResponseBody.class);
        System.out.println(responsebody.getBookingid());
        System.out.println(responsebody.getBooking().getFirstname());
        System.out.println(responsebody.getBooking().getLastname());

        //5 Assertions by using Deserialization-->Recommended
        assertThat(responsebody.getBookingid()).isNotNull();
        assertThat(responsebody.getBooking().getFirstname()).isEqualTo("Jim");
        assertThat(responsebody.getBooking().getLastname()).isEqualTo("Brown");


    }


}
