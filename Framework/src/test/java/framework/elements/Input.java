package framework.elements;

import framework.BaseElement;
import org.openqa.selenium.By;

public class Input extends BaseElement {
    public Input(By locatorElement) {
        super(locatorElement);
    }

    public void sendKeys(String str){
        webElement.sendKeys(str);
    }

}
