package pages;

import utils.PropertyLoader;
import utils.WebDriverWrapper;

public class MainPage extends Page{

    private static final String PAGE = PropertyLoader.loadProperty("site.Url");

    public MainPage(WebDriverWrapper dr) {
        super(dr, PAGE);
    }
}
