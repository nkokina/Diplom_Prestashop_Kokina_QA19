package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    private final String ITEM_NAME = "dress";

    @Test(groups = {"Regression"}, retryAnalyzer = Retry.class)
    @Description("Registered user product search test")
    public void searchItemTest() {
        searchPage.searchItemToText(ITEM_NAME);
        searchPage.waitForElementDisplayed();
        Assert.assertTrue(searchPage.isIconInformationDisplayed(), "Search failed");
    }

    @Test(groups = {"Regression"}, retryAnalyzer = Retry.class)
    @Description("Unregistered user product search test")
    public void searchWithoutAuthorizationTest() {
        searchPage.searchItemToText(ITEM_NAME);
        searchPage.waitForElementDisplayed();
        Assert.assertTrue(searchPage.isIconInformationDisplayed(), "Search failed");
    }

    @Test(groups = {"Negative"}, retryAnalyzer = Retry.class)
    @Description("Negative product search test")
    public void negativeSearchItemTest() {
        searchPage.searchItemToText("");
        searchPage.waitForElementDisplayed();
        Assert.assertTrue(searchPage.isErrorMessageDisplayed());
        Assert.assertFalse(searchPage.getErrorMessageDisplayed().isEmpty(), "Field are empty");
    }
}
