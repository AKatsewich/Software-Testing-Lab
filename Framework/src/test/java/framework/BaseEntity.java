package framework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseEntity {

    private static final String strUrl = "url";
    private static final String strTimeOut = "timeout";
    protected static ConfigReader configReader;
    protected static WebDriver driver;

    @BeforeTest
    public void before() {
        configReader = new ConfigReader("config");
        driver = BrowserFactory.getSingletonBrowser();
        driver.get(configReader.getProperties(strUrl));
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(configReader.getProperties(strTimeOut)), TimeUnit.SECONDS);
    }

    @AfterTest
    public void after() {
        //driver.quit();
    }
}
