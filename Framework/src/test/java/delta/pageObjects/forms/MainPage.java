package delta.pageObjects.forms;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private String locatorUnique="//form[@class='ng-untouched ng-pristine ng-invalid']";

    private String locatorMyTrips = "//a[@class='nav-link app-link nav-link-mytrips']";
    private String locatorConfNumber = "//input[@class='form-control mb-2 mb-sm-0 input-mobile-tab-class ng-untouched ng-pristine ng-invalid']";
    private String confNumber = "SFTORB";
    private String locatorTripFName = "//input[@class='form-control mb-2 mb-sm-0 text-capitalize input-mobile-tab-class ng-untouched ng-pristine ng-invalid'][@id='firstName']";
    private String locatorTripLName = "//input[@class='form-control mb-2 mb-sm-0 text-capitalize input-mobile-tab-class ng-untouched ng-pristine ng-invalid'][@id='lastName']";
    private String firstName = "Alex";
    private String lastName = "Hutchinson";
    private String locatorSubmit = "//button[@class='btn btn-danger rounded-circle btn-right-arrow icon-submitarrow circle-outline']";
    private String locatorTripError = "//*[@id=\"myTripsConfError\"]";

    private String btnFromCountry = "//span[@class='airport-code d-block'][1]";
    private String btnToCountry = "//*[@id=\"toAirportName\"]/span[1]";
    private String inptSubmit = "//input[@id='search_input']";
    private String cross = "//button[@class='search-flyout-close float-right d-none d-lg-block circle-outline icon-moreoptionsclose']";
    private String find = "//*[@id=\"btn-book-submit\"]";
    private String to="RIX";
    private String from = "SAN";
    private String locatorError = "//div/div/p[contains(text(),'Departure and return dates cannot be empty')]";

    private String locatorSkyteam = "//a[@class='mr-0 float-left ng-star-inserted']";
    private String locatorPopup = "//ngc-externalsite";

    public boolean searchTrips() {
        Button btnTrips = new Button(By.xpath(locatorMyTrips));
        btnTrips.click();
        Input inputNumber = new Input(By.xpath(locatorConfNumber));
        inputNumber.sendKeys(confNumber);
        Input inputFName = new Input(By.xpath(locatorTripFName));
        inputFName.sendKeys(firstName);
        Input inputLName = new Input(By.xpath(locatorTripLName));
        inputLName.sendKeys(lastName);
        Button btnSubmit = new Button(By.xpath(locatorSubmit));
        btnSubmit.click();
        Label lblError = new Label(By.xpath(locatorTripError));
        return lblError.isEnabled();
    }

    public boolean flightSearch() {
        Button webElement = new Button(By.xpath(btnFromCountry));
        webElement.click();
        Input webElement1 = new Input(By.xpath(inptSubmit));
        webElement1.sendKeys(to);
        Button crossEl = new Button(By.xpath(cross));
        crossEl.click();

        Button webElement2 = new Button(By.xpath(btnToCountry));
        webElement2.click();
        Input webElement3 = new Input(By.xpath(inptSubmit));
        webElement3.sendKeys(from);
        Button crossEl2 = new Button(By.xpath(cross));
        crossEl2.click();

        Button findEl = new Button(By.xpath(find));
        findEl.click();
        Label lblError = new Label(By.xpath(locatorError));
        return lblError.isEnabled();
    }

    public boolean popup() {
        Button btnSkyteam = new Button(By.xpath(locatorSkyteam));
        btnSkyteam.click();
        Label lblPopup = new Label(By.xpath(locatorPopup));
        return lblPopup.isEnabled();
    }
    public MainPage() {
        locatorPage = By.xpath(locatorUnique);
        isOpen(locatorPage);
    }
}
