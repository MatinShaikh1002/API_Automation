package API_TestNGExample;

import org.testng.annotations.Test;

public class GroupTest {

    @Test(groups = "Sanity")
    public void test1(){

        System.out.println("Sanity");
    }

    @Test(groups = "Sanity")
    public void test2(){

        System.out.println("Sanity");
    }

    @Test(groups = "Regression")
    public void test3(){

        System.out.println("Regression");
    }

    @Test(groups = "Regression")
    public void test4(){

        System.out.println("Regression");
    }



}
