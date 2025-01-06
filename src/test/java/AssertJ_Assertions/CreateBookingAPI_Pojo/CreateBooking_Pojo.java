package AssertJ_Assertions.CreateBookingAPI_Pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateBooking_Pojo {

    // Converting payload into Map

    @Test
    public void CreateBookingAPI(){

        // *************Create POJO-**********************************
        Booking booking=new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates); // Checkin, Checkout given to booking
        booking.setAdditionalneeds("Breakfast");

        // Given()
        RequestSpecification request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("/booking");
        request.contentType(ContentType.JSON);
        request.body(booking).log().all(); // Assigned PayloadMap Object

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
