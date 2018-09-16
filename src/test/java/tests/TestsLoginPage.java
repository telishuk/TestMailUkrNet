package tests;

import org.testng.annotations.*;
import utils.Fixture;
import utils.NoSuchLocatorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestsLoginPage extends Fixture{

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                {" ", " ", "Username is required"},
        };
    }

    @Parameters({"login", "password"})
    @Test
    public void positiveLoginUser(String login, String password) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.fillLoginForm(login, password);
        ukrnet.loginPage.clickLoginButton();
        assertEquals(ukrnet.loginPage.web.getElementsText("MailName"),"rstgroup@ukr.net", "The user is not logged in");
        ukrnet.loginPage.clickLogoutButton();
    }

    @Parameters({"login"})
    @Test
    public void negativeLoginUser(String login) throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.fillEmailField(login);
        ukrnet.loginPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Parameters({"login"})
    @Test
    public void negativePasswordUser(String login) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.fillLoginForm(login, "asdasdasda");
        ukrnet.loginPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Test
    public void negativeMailUser() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.fillLoginForm("234980234802", "asdasdasda");
        ukrnet.loginPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Test
    public void negativeAllField() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.clearAllField();
        ukrnet.loginPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "All fields don't empty");
    }

    @Parameters({"login"})
    @Test
    public void checkEnterLongPass(String login) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.fillLoginForm(login,ukrnet.randomData.getRandomLongString());
        ukrnet.loginPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Test
    public void checkLinkCreateBox() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.clickCreateBox();
        assertTrue(ukrnet.web.isElementPresent("PageHeader"), "User did't click link -> 'create box'");
    }

    @Test
    public void checkNotEnter() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.clickNotEnter();
        assertTrue(ukrnet.web.isElementPresent("PageHeader"), "User did't click link -> 'Can not login?'");
    }

    @Test
    public void checkUaLanguage() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.clickUaLanguage();
        assertTrue(ukrnet.web.isElementPresent("UaMainLogo"), "The language has not changed");
    }

    @Test
    public void checkRuLanguage() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.clickRuLanguage();
        assertTrue(ukrnet.web.isElementPresent("RuMainLogo"), "The language has not changed");
    }

    @Test
    public void checkEngLanguage() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.loginPage.openPage();
        ukrnet.loginPage.clickEngLanguage();
        assertTrue(ukrnet.web.isElementPresent("EngMainLogo"), "The language has not changed");
    }

}
