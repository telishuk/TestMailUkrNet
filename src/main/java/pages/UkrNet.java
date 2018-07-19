package pages;

import utils.WebDriverWrapper;
import utils.WebElementActions;

public class UkrNet {
    public WebElementActions web;
    public MainPage mainPage;


    public UkrNet(WebDriverWrapper driver) {
        web = new WebElementActions(driver);

        mainPage = new MainPage(driver);
    }
}
