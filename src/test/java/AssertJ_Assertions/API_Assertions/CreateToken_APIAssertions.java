package AssertJ_Assertions.API_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class CreateToken_APIAssertions {

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

        // Extract each response key:value
         Integer bookingid=response.then().extract().path("bookingid");
         String firstname=response.then().extract().path("booking.firstname");
         String lastname=response.then().extract().path("booking.lastname");
         String checkin=response.then().extract().path("booking.bookingdates.checkin");

         // Apply Assertions on extracted response value
        assertThat(bookingid).isNotNull();
        assertThat(firstname).isEqualTo("Jim").isNotNull();
        assertThat(lastname).isEqualTo("Brown").isNotNull();
        assertThat(checkin).isEqualTo("2018-01-01").isNotNull();
}

}






