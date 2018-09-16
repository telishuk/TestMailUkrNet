package pages;

import utils.RandomData;
import utils.WebDriverWrapper;
import utils.WebElementActions;

public class UkrNet {
    public WebElementActions web;
    public LoginPage loginPage;
    public RandomData randomData;


    public UkrNet(WebDriverWrapper driver) {
        web = new WebElementActions(driver);

        loginPage = new LoginPage(driver);
        randomData = new RandomData();
    }
}
