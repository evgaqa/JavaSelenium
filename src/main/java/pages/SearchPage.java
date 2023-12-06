package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

import java.util.List;

public class SearchPage extends BaseTest {

    @FindBy(css = "span[data-testid='itemDescription']")
    public List<WebElement> productTitles;

    @FindBy(css = "input[data-testid='itemAddCart']")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@class='notification__action']/a[text()='View Cart']")
    public WebElement viewCartPopupBtn;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
