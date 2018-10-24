package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class Browser {

    private static WebDriver driver;
    private static final String strBrowser = "browser";
    private static String pathChrome = "./src/test/resources/drivers/chromedriver.exe";

    private Browser() {}

    public static WebDriver getSingletonBrowser() {
        FileProperties fileProperties = new FileProperties();
        if (driver == null) {
            switch (fileProperties.getProperties(strBrowser)) {
                case "Chrome": {
                    try {
                        System.setProperty("webdriver.chrome.driver", new File(pathChrome).getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }
}