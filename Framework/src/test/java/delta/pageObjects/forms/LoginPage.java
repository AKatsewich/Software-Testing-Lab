package delta.pageObjects.forms;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private String locatorLogin = "//button[@class='login-btn btn btn-danger']";
    private String locatorUserId = "//input[@class='form-control textField ng-untouched ng-pristine ng-invalid']";
    private String locatorPassword = "//*[@id=\"password\"]";
    private String SkyMilesNumber = "9082373276";
    private String locatorLoginConf = "//button[@class='btn btn-danger loginButton']";
    private String locatorLoggedIn = "//div[@class='logged-in-container miles-available ng-star-inserted']";

    public boolean login(String pass) {
        Button btnLogin = new Button(By.xpath(locatorLogin));
        btnLogin.click();
        Input inputUserID = new Input(By.xpath(locatorUserId));
        inputUserID.sendKeys(SkyMilesNumber);
        Input inputPassword = new Input(By.xpath(locatorPassword));
        inputPassword.sendKeys(pass);
        Button btnLoginConf = new Button(By.xpath(locatorLoginConf));
        btnLoginConf.click();
        return Label.isFound(locatorLoggedIn);
    }
}
