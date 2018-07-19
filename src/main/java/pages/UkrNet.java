package pages;

import utils.RandomData;
import utils.WebDriverWrapper;
import utils.WebElementActions;

public class UkrNet {
    public WebElementActions web;
    public MainPage mainPage;
    public RandomData randomData;


    public UkrNet(WebDriverWrapper driver) {
        web = new WebElementActions(driver);

        mainPage = new MainPage(driver);
        randomData = new RandomData();
    }
}
