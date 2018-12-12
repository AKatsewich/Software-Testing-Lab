package delta.pageObjects.forms;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import org.openqa.selenium.By;

public class SkymilesPage extends BasePage {
    private String locatorUnique = "//div[@class='container-fluid picturefill-background hero']";
    private String locatorSkymiles = "//a[@id='secondary-static-link-0']";
    private String locatorMenu = "//a[@class='nav-link static-link d-none d-lg-block static-link-sky-miles']";
    private String searchLocator = "//a[@class='search-text']";
    private String searchInputLocator = "//input[@class='form-control mb-2 mb-sm-0 custom-search-color']";
    private String searchResultLocator = "(//li/a/b[contains(text(),'SkyMiles')])[1]";
    private String searchInput = "Skymiles";
    private String locatorCookieCross = "//button[@class='cookie-close-icon float-right circle-outline']";

    public boolean isOpen() {
        Label uniqueElement = new Label(By.xpath(locatorUnique));
        return uniqueElement.isEnabled();
    }

    public void pageSearch() {
        if (Label.isFound(locatorCookieCross)) {
            Button btnCookie = new Button(By.xpath(locatorCookieCross));
            btnCookie.click();
        }
        Button btnSearch = new Button(By.xpath(searchLocator));
        btnSearch.click();
        Input inputSearch = new Input(By.xpath(searchInputLocator));
        inputSearch.sendKeys(searchInput);
        Button searchResBtn = new Button(By.xpath(searchResultLocator));
        searchResBtn.click();
    }

    public void  goToSkymiles() {
        Label lblMenu = new Label(By.xpath(locatorMenu));
        lblMenu.moveTo();

        Button btnSkymiles = new Button(By.xpath(locatorSkymiles));
        btnSkymiles.moveTo();
        btnSkymiles.click();
    }
}
