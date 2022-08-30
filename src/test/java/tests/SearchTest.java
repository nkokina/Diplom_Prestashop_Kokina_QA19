package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    private final String ITEM_NAME="dress";

    @Test
    public void searchItemTest(){
        loginPage.clickLoginButton();
       loginPage.login(EMAIL, PASSWORD);
       searchPage.searchItemToText(ITEM_NAME);
       searchPage.waitForElementDisplayed();
        Assert.assertTrue(searchPage.isIconInformationDisplayed(), "Search failed");
    }
    @Test
    public void searchWithoutAuthorizationTest(){
        searchPage.searchItemToText(ITEM_NAME);
        searchPage.waitForElementDisplayed();
        Assert.assertTrue(searchPage.isIconInformationDisplayed(), "Search failed");
    }

    @Test
    public void negativeSearchItemTest(){
        loginPage.clickLoginButton();
        loginPage.login(EMAIL, PASSWORD);
        searchPage.searchItemToText("");
        searchPage.waitForElementDisplayed();
        Assert.assertTrue(searchPage.isErrorMessageDisplayed());
        Assert.assertEquals(searchPage.getErrorMessageDisplayed().isEmpty(), false, "Field are empty");
    }
}
