package delta.pageObjects.forms;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class RussianMainPage extends BasePage {
    private String locatorLanguageSelector = "//a[@class='lang-select-link language-firstitem icon-Language-selector']";
    private String locatorLanguageRegion = "//li/a[contains(text(),\"Europe\")]";
    private String locatorLanguage = "//li/a[contains(text(),\"Россия\")]";
    private String locatorUnique = "//a[contains(text(),'ЗАБРОНИРОВАТЬ')]";
    private String locatorCookieCross = "//button[@class='cookie-close-icon float-right circle-outline']";

    public boolean isOpen() {
        Button btnBook = new Button(By.xpath(locatorUnique));
        return btnBook.isEnabled();
    }

    public void changeLanguage() {
        if (Label.isFound(locatorCookieCross)) {
            Button btnCookie = new Button(By.xpath(locatorCookieCross));
            btnCookie.click();
        }
        Button btnLanguageMenu = new Button(By.xpath(locatorLanguageSelector));
        btnLanguageMenu.click();
        Button btnRegion = new Button(By.xpath(locatorLanguageRegion));
        btnRegion.click();
        Button btnLanguage = new Button(By.xpath(locatorLanguage));
        btnLanguage.click();
    }
}
