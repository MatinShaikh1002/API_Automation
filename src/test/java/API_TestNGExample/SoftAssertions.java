package API_TestNGExample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

    @Test
    public void softAssertionTest(){


        SoftAssert sa=new SoftAssert();
        System.out.println("Program started");

        sa.assertTrue(false);
        sa.assertEquals("Matin", "Matin");

        System.out.println("Program ended");

        sa.assertAll(); // collect all errors

    }



}
