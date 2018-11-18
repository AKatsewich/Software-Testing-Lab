package delta.tests;

import framework.BasePage;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import delta.pageObjects.forms.*;

public class TestPage extends BaseTest {
    /*
     *  It clicks on language selector and chooses Russian language.
     *  Expected result - all text changed to russian.
     */
    @Test
    public void languageTest() {
        before();
        RussianMainPage russianPage = new RussianMainPage();
        russianPage.changeLanguage();
        Assert.assertTrue(russianPage.isOpen());
        BasePage.cleanup();
    }

    /*
     *  It clicks on search field and prints "Skymiles".
     *  Expected result - Skymiles related pages appear as a search result.
     */
    @Test
    public void searchTest() {
        before();
        SkymilesPage skymilesPage = new SkymilesPage();
        skymilesPage.pageSearch();
        Assert.assertTrue(skymilesPage.isOpen());
        BasePage.cleanup();
    }

    /*
     *  It clicks on skymiles page link and checks redirecting on Delta's Skymiles page.
     *  Expected result - Delta's Skymiles page opens.
     */
    @Test
    public void redirectTest() {
        before();
        SkymilesPage skymilesPage = new SkymilesPage();
        skymilesPage.goToSkymiles();
        Assert.assertTrue(skymilesPage.isOpen());
        BasePage.cleanup();
    }

    /*
     *  It searches booked trip with wrong confirmation number.
     *  Expected result - search fails.
     */
    @Test
    public void checkTripTest() {
        before();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.searchTrips());
        BasePage.cleanup();
    }

    /*
     *  It opens up login popup and enters invalid data.
     *  Expected result - login fails.
     */
    @Test
    public void loginFailTest() {
        before();
        LoginPage loginPage = new LoginPage();
        Assert.assertFalse(loginPage.login("reallyWrong"));
        BasePage.cleanup();
    }

    /*
     *  It clicks on Skyteam logo on main page that redirects to company's parent page.
     *  Expected result - popup appears.
     */
    @Test
    public void popupTest() {
        before();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.popup());
        BasePage.cleanup();
    }

    /*
     *  It opens hotel book page from main page and fills 'To' fields,.
     *  Expected result - search results appear.
     */
    @Test
    public void hotelBookTest() {
        before();
        HotelPage hotelPage = new HotelPage();
        Assert.assertTrue(hotelPage.hotelBook());
        BasePage.cleanup();
    }

    /*
     *  It opens up login popup and enters valid data.
     *  Expected result - successful login.
     */
    @Test
    public void LoginTest() {
        before();
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.login("Password123"));
        BasePage.cleanup();
    }

    /*
     *  It opens site and fills 'From' and 'To' fields, but not the Date field.
     *  Expected result - search fails.
     */
    @Test
    public void flightSearchTest() {
        before();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.flightSearch());
        BasePage.cleanup();
    }

    /*
     *  It opens car search page from main page and fills location and date fields.
     *  Expected result - car rent variants appear.
     */
    @Test
    public void carSearchTest() {
        before();
        CarRentPage carRentPage = new CarRentPage();
        Assert.assertTrue(carRentPage.searchCars(),"No search results found");
        BasePage.cleanup();
    }
}
