package delta.tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import delta.pageObjects.forms.*;

public class TestPage extends BaseTest {
    
    @Test
    public void runTest() {
        MainPage mainPage = new MainPage();
        mainPage.goToSkymiles();
        SkymilesPage skymilespage = new SkymilesPage();
        Assert.assertTrue(skymilespage.isOpen());
    }
}
