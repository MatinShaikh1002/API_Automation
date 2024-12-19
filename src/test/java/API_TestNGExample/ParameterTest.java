package API_TestNGExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Parameters("browser")
    @Test
    public void loginTest(String br){

        if(br.equalsIgnoreCase("chrome")){
            System.out.println("Test case execution in chrome");
        }

        else if (br.equalsIgnoreCase("firefox")) {
            System.out.println("Test case execution in firefox");
        }

    }
}
