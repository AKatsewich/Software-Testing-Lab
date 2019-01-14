package delta.pageObjects.forms;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private String locatorUnique="//form[@class='ng-untouched ng-pristine ng-invalid']";
    private String locatorSkymiles = "//a[@id='secondary-static-link-0']";
    private String locatorMenu = "//a[@class='nav-link static-link d-none d-lg-block static-link-sky-miles']";

    public void  goToSkymiles() {
        Label lblMenu = new Label(By.xpath(locatorMenu));
        lblMenu.moveTo();

        Button btnSkymiles = new Button(By.xpath(locatorSkymiles));
        btnSkymiles.moveTo();
        btnSkymiles.click();
    }

    public MainPage() {
        locatorPage = By.xpath(locatorUnique);
        isOpen(locatorPage);
    }
}
