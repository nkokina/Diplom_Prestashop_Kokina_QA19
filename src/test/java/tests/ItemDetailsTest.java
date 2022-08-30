package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BasketPage;
import page.ItemDetailsPage;
import page.WomenPage;

public class ItemDetailsTest extends BaseTest {
    WomenPage womenPage;
    ItemDetailsPage itemDetailsPage;
    BasketPage basketPage;
    protected static String PRODUCT_NAME = "Dress";
    protected static String PRODUCT_PRICE = "61,19 ₴";
    @BeforeMethod
    public void initialise() {
        womenPage = new WomenPage(driver);
        itemDetailsPage=new ItemDetailsPage(driver);
        basketPage=new BasketPage(driver);
    }

    @Test (groups = {"Smoke"})
    public void verifyItemNameAndPricePage() {
        loginPage.clickLoginButton();
        loginPage.login(EMAIL, PASSWORD);
        myAccountPage.clickHomeButton();
        productsPage.clickWomenButton();
        womenPage.waitForElementDisplayed();
        Assert.assertTrue(womenPage.isRemoveButtonDisplayed(), "Did not find the transition to the Women's page");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(itemDetailsPage.getItemPrice(), PRODUCT_PRICE,
                "The price of the book does not correspond");
    }

    @Test(groups = {"Smoke"})
    @Description("Check The Added Item In The Cart Test")
    public void checkTheAddedItemInTheCart() {
        loginPage.clickLoginButton();
        loginPage.login(EMAIL, PASSWORD);
        myAccountPage.clickHomeButton();
        productsPage.clickWomenButton();
        womenPage.waitForElementDisplayed();
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.waitForElementDisplayed();
        itemDetailsPage.clickAddToCartItemButton();
        basketPage.clickingOnTheShoppingCart();
        Assert.assertEquals(basketPage.getItemNameInBasket(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(basketPage.getItemPriceInBasket(), PRODUCT_PRICE,
                "The price of the book does not correspond");
    }

    @Test(groups = {"Smoke"}, dataProvider = "inventoryItemsTestData")
    @Description("Inventory Items Test")
    public void inventoryItemsTest(String nameItem, String priceItem) {
        loginPage.clickLoginButton();
        loginPage.login(EMAIL, PASSWORD);
        myAccountPage.clickHomeButton();
        productsPage.clickWomenButton();
        womenPage.waitForElementDisplayed();
        Assert.assertTrue(productsPage.getProductName(nameItem), "Product name is wrong");
        Assert.assertTrue(productsPage.getProductPrice(priceItem), "Product price is wrong");
    }

    @DataProvider
    public Object[][] inventoryItemsTestData() {
        return new Object[][]{
                {"Faded Short Sleeve T-shirts", "19,81"},
                {"Blouse", "32,40"},
                {"Printed Dress", "31,20"},
                {"Dress", "61,19"},
                {"Printed Summer Dress", "36,61"},
                {"Printed Summer Dress", "36,60"},
                {"Blue Printed Maxi Dress", "432,00"},
                {"Printed Chiffon Dress", "24,60"},
                {"Black blouse with flowers", "660,00"},
                {"V Neckline  Top - White", "432,00"},
                {"V-back Dress", "420,00"},
                {"Floral Top", "624,00"},
        };
    }
}

