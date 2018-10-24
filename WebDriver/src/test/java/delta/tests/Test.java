package delta.tests;
import framework.Browser;

import framework.FileProperties;
import delta.form.MainPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Test {
    public static WebDriver driver;

    private static final String strUrl = "url";
    private static final String strTimeOut = "timeout";
    private static String titleMainPage="Airline Tickets & Flights: Book Direct with Delta Air Lines - Official Site";
    private static FileProperties fileProperties;


    /*
     *  It opens site and fills 'From' and 'To' fields, but not the Date field.
     *  In that case test should fail.
     */
    @BeforeTest
    public void testBefore() {
        driver = Browser.getSingletonBrowser();
        fileProperties = new FileProperties();
        driver.get(fileProperties.getProperties(strUrl));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(fileProperties.getProperties(strTimeOut)), TimeUnit.SECONDS);
    }


    @org.testng.annotations.Test
    public void testWork() {
        MainPage pageMain = new MainPage(driver);
        Assert.assertEquals(driver.getTitle(),titleMainPage);
        pageMain.inputInvalidDate();
        Assert.assertEquals(driver.getTitle(),titleMainPage);
    }

    @AfterTest
    public void testAfter() {
        //driver.quit();
    }
}

