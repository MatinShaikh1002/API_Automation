package API_TestNGExample;

import org.testng.annotations.Test;

public class InvocationCount {

    @Test(invocationCount = 3)
    public void login(){
        System.out.println("Login");
    }
}
