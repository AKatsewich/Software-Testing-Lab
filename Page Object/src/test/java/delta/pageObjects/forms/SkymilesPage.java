package delta.pageObjects.forms;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class SkymilesPage extends BasePage {
    private String locatorUnique = "//div[@class='container-fluid picturefill-background hero']";

    public SkymilesPage() {
        locatorPage = By.xpath(locatorUnique);
        isOpen(locatorPage);
    }

    public boolean isOpen() {
        Label uniqueElement = new Label(By.xpath(locatorUnique));
        return uniqueElement.isEnabled();
    }
}
