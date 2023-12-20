package tests.day06_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertions {

    @Test
    public void test01(){

        // Let the retirement age be 65

        // Test if a person aged 70 can retire

        int age = 70;

        Assert.assertTrue(age > 65); // test passed

        int number1 = 20 ;
        int number2 = 30 ;

        // Assert.assertTrue(number1 > number2); // FAILED

        Assert.assertFalse(number1 > number2); // PASSED

        System.out.println("This line won't be executed if the assertion fails");

        String actualUrl = "https://testotomasyonu.com/";

        //  Test if the URL contains testotomasyonu

        Assert.assertTrue(actualUrl.contains("testotomasyonu")); // PASSED

    }
}
