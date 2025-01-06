package API_TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

    @Test
    public void hardAssertionTest(){

        System.out.println("Program Started");
        Assert.assertTrue(false); // Fail

        // This statement wont excute
        System.out.println("Program Ended");

    }
}
