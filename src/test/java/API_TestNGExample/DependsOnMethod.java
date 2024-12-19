package API_TestNGExample;

import org.testng.annotations.Test;

public class DependsOnMethod {

    @Test
    public void runServerOK(){

    System.out.println("Server OK");
    }

    @Test(dependsOnMethods = "runServerOK")
    public void CreateBooking(){

        System.out.println("Booking Created");
    }

    @Test(dependsOnMethods = "runServerOK")
    public void GetBooking(){

        System.out.println("Booking Details");
    }

}
