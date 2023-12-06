package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

import java.util.List;

public class CartPage extends BaseTest {

    public final String EMPTY_CART_HEADER = "Your cart is empty.";

    @FindBy(css = "button[class*='deleteCartItemButton itemDelete__link itemDelete--positioning']")
    public List<WebElement> deleteCartItemBtn;

    @FindBy(xpath = "//div[@class='cartEmpty']/descendant::p[@class='header-1']")
    public WebElement cartEmptyHeader;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
