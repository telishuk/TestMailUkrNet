package tests;

import org.testng.annotations.*;
import utils.Fixture;
import utils.NoSuchLocatorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestsMainPage extends Fixture{


    @Test(groups = "positive")
    public void positiveLoginUser() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.fillLoginForm("rstgroup", "gfhjkm100");
        ukrnet.mainPage.clickLoginButton();
        assertEquals(ukrnet.mainPage.web.getElementsText("MailName"),"rstgroup@ukr.net", "The user is not logged in");
        ukrnet.mainPage.clickLogoutButton();
    }

    @Test(groups = "negative")
    public void negativeLoginUser() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.fillEmailField("rstgroup");
        ukrnet.mainPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Test(groups = "negative")
    public void negativePasswordUser() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.fillLoginForm("rstgroup", "asdasdasda");
        ukrnet.mainPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Test(groups = "negative")
    public void negativeMailUser() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.fillLoginForm("234980234802", "asdasdasda");
        ukrnet.mainPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Test(groups = "negative")
    public void negativeAllField() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.clearAllField();
        ukrnet.mainPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "All fields don't empty ");
    }

    @Test(groups = "negative")
    public void checkEnterLongPass() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.fillLoginForm("rstgroup",ukrnet.randomData.getRandomLongString());
        ukrnet.mainPage.clickLoginButton();
        assertTrue(ukrnet.web.isElementPresent("ErrorFail"), "Error messages not visible");
    }

    @Test(groups = "positive")
    public void checkLinkCreateBox() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.clickCreateBox();
        assertTrue(ukrnet.web.isElementPresent("PageHeader"), "User did't click link -> 'create box'");
    }

    @Test(groups = "positive")
    public void checkNotEnter() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.clickNotEnter();
        assertTrue(ukrnet.web.isElementPresent("PageHeader"), "User did't click link -> 'Can not login?'");
    }

    @Test(groups = "positive")
    public void checkUaLanguage() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.clickUaLanguage();
        assertTrue(ukrnet.web.isElementPresent("UaMainLogo"), "The language has not changed");
    }

    @Test(groups = "positive")
    public void checkRuLanguage() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.clickRuLanguage();
        assertTrue(ukrnet.web.isElementPresent("RuMainLogo"), "The language has not changed");
    }

    @Test(groups = "positive")
    public void checkEngLanguage() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        ukrnet.mainPage.openPage();
        ukrnet.mainPage.clickEngLanguage();
        assertTrue(ukrnet.web.isElementPresent("EngMainLogo"), "The language has not changed");
    }

}
