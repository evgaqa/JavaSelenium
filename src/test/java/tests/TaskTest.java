package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.SearchPage;
import pages.BasePage;
import utils.BaseTest;

import java.time.Duration;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TaskTest extends BaseTest {

    public BasePage basePage = new BasePage(driver);
    public CartPage cartPage = new CartPage(driver);
    public SearchPage searchPage = new SearchPage(driver);

    @ParameterizedTest
    @CsvSource({"stainless work table, Table", "coffee maker, Coffee"})
    public void checkTitleContainKeyWord(String searchRequest, String expectedWord) {

        //open base page
        driver.get(basePage.BASE_URL);

        //type search request to search field
        basePage.searchBox.sendKeys(searchRequest);

        //click search button
        basePage.searchButton.click();

        //check titles contains 'Table'
        ArrayList<String> titles = new ArrayList<>();
        searchPage.productTitles.stream().map(WebElement::getText).forEach(titles::add);
        assertThat(titles, not(empty()));
        assertThat(titles, everyItem(containsString(expectedWord)));

        //click to last item add to cart button
        searchPage.addToCartButtons.get(searchPage.addToCartButtons.size() - 1).click();

        //go to cart throw popup
        searchPage.viewCartPopupBtn.click();

        //remove all items from cart
        cartPage.deleteCartItemBtn.forEach(WebElement::click);

        //validate 'Your cart is empty.' message is shown
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cartPage.cartEmptyHeader));
        cartPage.cartEmptyHeader.isDisplayed();
        assertThat(cartPage.cartEmptyHeader.getText(), is(cartPage.EMPTY_CART_HEADER));
    }
}
