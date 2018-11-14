package steam.pageObjects.forms;

import framework.BasePage;
import org.openqa.selenium.By;

public class SkymilesPage extends BasePage {
    private String locatorUnique = "//div[@class='container-fluid picturefill-background hero']";

    public SkymilesPage() {
        locatorPage = By.xpath(locatorUnique);
        isOpen(locatorPage);
    }
}
