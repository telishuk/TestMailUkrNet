package pages;

import utils.NoSuchLocatorException;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

import java.io.IOException;

public class MainPage extends Page{

    private static final String PAGE = PropertyLoader.loadProperty("site.Url");

    public MainPage(WebDriverWrapper dr) {
        super(dr, PAGE);
    }

    public void clickLoginButton() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("ButtonLogin");
    }

    public void clickLogoutButton() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickElement("UserMenu");
        web.clickButton("ButtonLogout");
    }

    public void clearAllField() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clearField("FieldMail");
        web.clearField("FieldPassword");
    }


    public void fillLoginForm(String email, String password) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("FieldMail", email);
        web.input("FieldPassword", password);
    }

    public void fillEmailField(String email) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.input("FieldMail", email);
    }

    public void fillPassField(String pass) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.input("FieldPassword", pass);
    }

    public void clickCreateBox() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickLink("ButtonCreateBox");
    }

    public void clickNotEnter() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickLink("ButtonNotEnter");
    }

    public void clickUaLanguage() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButton("UaLanguage");
    }

    public void clickRuLanguage() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButton("RuLanguage");
    }

    public void clickEngLanguage() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButton("EngLanguage");
    }



}
