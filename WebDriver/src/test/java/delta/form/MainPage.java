package delta.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private By btnFromCountry = By.xpath("//span[@class='airport-code d-block'][1]");
    private By btnToCountry = By.xpath("//*[@id=\"toAirportName\"]/span[1]");
    private By inptSubmit = By.xpath("//input[@id='search_input']");
    private By cross = By.xpath("//button[@class='search-flyout-close float-right d-none d-lg-block circle-outline icon-moreoptionsclose']");
    private By find = By.xpath("//*[@id=\"btn-book-submit\"]");


    private String to="RIX";
    private String from = "SAN";
    private WebDriver driver;


    public  MainPage(WebDriver driverAuthorization){
        driver=driverAuthorization;
    }

    public void inputInvalidDate(){
        WebElement webElement = driver.findElement(btnFromCountry);
        webElement.click();
        WebElement webElement1 = driver.findElement(inptSubmit);
        webElement1.sendKeys(to);
        WebElement crossEl = driver.findElement(cross);
        crossEl.click();

        WebElement webElement2 = driver.findElement(btnToCountry);
        webElement2.click();
        WebElement webElement3 = driver.findElement(inptSubmit);
        webElement3.sendKeys(from);
        WebElement crossEl2 = driver.findElement(cross);
        crossEl2.click();

        WebElement findEl = driver.findElement(find);
        findEl.click();
    }

}
