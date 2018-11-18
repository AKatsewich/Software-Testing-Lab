package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BrowserFactory extends BaseEntity {

    private static String OS = System.getProperty("os.name").toLowerCase().substring(0, 4);
    private static String pathChrome = "./src/test/resources/drivers/chromedriver.exe";
    private static String downloadFilepath;

    private BrowserFactory() {
    }

    private static DesiredCapabilities getOptionChrome() {
        try {
            downloadFilepath = new File(configReader.getProperties("pathDownload")).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("safebrowsing.enabled", "true");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }

    public static WebDriver getSingletonBrowser() {
       String strBrowser=System.getProperty("browser");
        if(strBrowser==null)
            strBrowser=configReader.getProperties("browser");
        
        if (driver == null) {
            switch (strBrowser) {
                case "Chrome": {
                    try {
                        System.setProperty("webdriver.chrome.driver", new File(pathChrome).getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return driver = new ChromeDriver(getOptionChrome());
                }
            }
        }
        return driver;
    }
}
