package API_TestNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PUT_Api {

    @BeforeTest
    public void createToken(){

        System.out.println("Token Created");
    }

    @BeforeTest
    public void createBooking(){

        System.out.println("Booking ID Created");
    }

    @Test
    public void testCase_Put(){

        System.out.println("Put Test case executed");
    }

    @AfterTest
    public void closeTest(){

        System.out.println("Test closed");
    }



}
