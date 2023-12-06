package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

public class BasePage extends BaseTest {

    public final String BASE_URL = "https://www.webstaurantstore.com/";

    @FindBy(id = "searchval")
    public WebElement searchBox;

    @FindBy(css = "button[value='Search']")
    public WebElement searchButton;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
