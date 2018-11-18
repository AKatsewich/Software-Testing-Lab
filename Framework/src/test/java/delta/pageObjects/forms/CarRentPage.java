package delta.pageObjects.forms;

import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CarRentPage {
    private String locatorCarRent = "//*[@id=\"contentFragment\"]/div[2]/div[2]/div/div/div[1]/div/div/ul/li[3]/a/span[1]";
    private String locatorPickUpLocation = "//*[@id=\"carPickUpLocation\"]";
    private String locatorDropdown = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li[@id='ui-id-6']";
    private String locatorPickUpDate = "//*[@id=\"carPickUpDate\"]";
    private String locatorDropOffDate = "//*[@id=\"carDropOffDate\"]";
    private String location = "LAS VEGAS";
    private String pickupDate = "12/12/2018";
    private String dropoffDate = "12/13/2018";
    private String locatorCarSubmit = "//*[@id=\"btnSubmit\"]";
    private String locatorSearchResult = "//table[@class='carResultContainer_EHI']/tr[@id='carListDetailsSection_1']";
    private String locatorCookieCross = "//button[@class='cookie-close-icon float-right circle-outline']";

    public boolean searchCars() {
        if (Label.isFound(locatorCookieCross)) {
            Button btnCookie = new Button(By.xpath(locatorCookieCross));
            btnCookie.click();
        }
        Button btnCarRent = new Button(By.xpath(locatorCarRent));
        btnCarRent.click();
        Input inputLocation = new Input(By.xpath(locatorPickUpLocation));
        inputLocation.sendKeys(location);
        Button btnDropdown = new Button(By.xpath(locatorDropdown));
        btnDropdown.click();
        Input inputPickup = new Input(By.xpath(locatorPickUpDate));
        inputPickup.sendKeys(pickupDate);
        Input inputDropoff = new Input(By.xpath(locatorDropOffDate));
        inputDropoff.sendKeys(dropoffDate);
        Button btnCarSubmit = new Button(By.xpath(locatorCarSubmit));
        btnCarSubmit.click();

        Label lblResult = new Label(By.xpath(locatorSearchResult));
        return lblResult.isEnabled();
    }
}
