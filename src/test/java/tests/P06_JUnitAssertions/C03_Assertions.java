package tests.day06_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertions {

    @Test
    public void test01() {

        // Let the retirement age be 65

        // Test if a person aged 70 can retire

        int age = 70;

        Assert.assertTrue(age > 65); // test passed

        int number1 = 20;
        int number2 = 30;

        // Assert.assertTrue(number1 > number2); // FAILED

        Assert.assertFalse(number1 > number2); // PASSED

        System.out.println("This line won't be executed if the assertion fails");

        String actualUrl = "https://testotomasyonu.com/";

        //  Test if the URL contains testotomasyonu

        Assert.assertTrue(actualUrl.contains("testotomasyonu")); // PASSED

        // Test if the URL does not contain wisequarter

        Assert.assertFalse(actualUrl.contains("wisequarter"));  // PASSED

        // Test if the URL is https://testotomasyonu.com/

        Assert.assertEquals("https://testotomasyonu.com/", actualUrl); // PASSED

        Assert.assertTrue("https://testotomasyonu.com/".equals(actualUrl)); // PASSED
        //'assertTrue()' can be simplified to 'assertEquals()'

        // Test if the URL is not https://www.testotomasyonu.com/

        Assert.assertNotEquals("https://www.testotomasyonu.com/", actualUrl); // PASSED

        Assert.assertFalse("https://www.testotomasyonu.com/".equals(actualUrl)); // PASSED
    }
}
