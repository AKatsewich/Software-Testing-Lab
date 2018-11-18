package delta.pageObjects.forms;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import org.openqa.selenium.By;

public class HotelPage extends BasePage {
    private String locatorHotelPage = "//span[contains(text(),'Shop Hotels')]";
    private String locatorHotelLandmark = "//*[@id=\"qf-0q-destination\"]";
    private String hotelLandmark = "Las Vegas";
    private String locatorHotelResults = "//ol[@class='listings infinite-scroll-enabled']/li";
    private String locatorCookieCross = "//button[@class='cookie-close-icon float-right circle-outline']";

    public boolean hotelBook() {
        if (Label.isFound(locatorCookieCross)) {
            Button btnCookie = new Button(By.xpath(locatorCookieCross));
            btnCookie.click();
        }
        Button btnHotelPage = new Button(By.xpath(locatorHotelPage));
        btnHotelPage.click();
        Input inputAddress = new Input(By.xpath(locatorHotelLandmark));
        inputAddress.sendKeys(hotelLandmark);
        inputAddress.clickEnter();
        Label lblResults = new Label(By.xpath(locatorHotelResults));
        return lblResults.isEnabled();
    }
}
