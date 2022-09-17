package tests;

import io.qameta.allure.Description;
import models.Addresses;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ItemDetailsTest extends BaseTest {
    protected static String PRODUCT_NAME = "Dress";
    protected static String PRODUCT_PRICE = "61,19 ₴";


    @Test(groups = {"Regression"}, retryAnalyzer = Retry.class)
    @Description("Test for checking the price and the name of the product in the general catalog and a separate product page")
    public void verifyItemNameAndPricePageTest() {
        loginPage.clickLoginButton();
        loginPage.login(userEmail, userPassword);
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

    @Test(groups = {"Smoke"}, retryAnalyzer = Retry.class)
    @Description("Add to cart test")
    public void addToCartTest() {
        loginPage.clickLoginButton();
        loginPage.login(userEmail, userPassword);
        myAccountPage.clickHomeButton();
        productsPage.clickWomenButton();
        womenPage.waitForElementDisplayed();
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.waitForElementDisplayed();
        itemDetailsPage.clickAddToCartItemButton();
        itemDetailsPage.waitForItemCartDisplayed();
        basketPage.clickingOnTheShoppingCart();
        Assert.assertEquals(basketPage.getItemNameInBasket(), PRODUCT_NAME,
                "The title of the book does not correspond");
        Assert.assertEquals(basketPage.getItemPriceInBasket(), PRODUCT_PRICE,
                "The price of the book does not correspond");
    }

    @Test(groups = {"Smoke"}, retryAnalyzer = Retry.class, dataProvider = "userAddAddressesData")
    @Description("Product purchase test")
    public void productPurchaseTest(Addresses yourAddresses) {
        loginPage.clickLoginButton();
        loginPage.login(userEmail, userPassword);
        myAccountPage.clickHomeButton();
        productsPage.clickWomenButton();
        womenPage.waitForElementDisplayed();
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.waitForElementDisplayed();
        itemDetailsPage.clickAddToCartItemButton();
        itemDetailsPage.waitForItemCartDisplayed();
        basketPage.clickingOnTheShoppingCart();
        basketPage.clickProceedToCheckout();
        newAddressesModal.fillingOutTheForm(yourAddresses);
        basketPage.clickSaveAddresses();
        basketPage.waitForElementDisplayed();
        basketPage.clickProceedAddresses();
        basketPage.clickTermsOfService();
        basketPage.clickProceedCarrier();
        Assert.assertTrue(basketPage.isMessageDisplayed(), "The inscription did not appear");
        basketPage.clickMyAccountButton();
        myAccountPage.clickAddressesButton();
        myAccountPage.clickDeleteAddressesButton();
        myAccountPage.waitForElementDisplayed();
    }

    @Test(groups = {"Negative"}, retryAnalyzer = Retry.class, dataProvider = "userAddAddressesData")
    @Description("Negative product purchase test")
    public void negativeProductPurchaseTest(Addresses yourAddresses) {
        loginPage.clickLoginButton();
        loginPage.login(userEmail, userPassword);
        myAccountPage.clickHomeButton();
        productsPage.clickWomenButton();
        womenPage.waitForElementDisplayed();
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.waitForElementDisplayed();
        itemDetailsPage.clickAddToCartItemButton();
        itemDetailsPage.waitForItemCartDisplayed();
        basketPage.clickingOnTheShoppingCart();
        basketPage.clickProceedToCheckout();
        newAddressesModal.fillingOutTheForm(yourAddresses);
        basketPage.clickSaveAddresses();
        basketPage.waitForElementDisplayed();
        basketPage.clickProceedAddresses();
        basketPage.clickProceedCarrier();
        Assert.assertTrue(basketPage.isErrorMessageDisplayed());
        Assert.assertEquals(basketPage.getErrorMessageDisplayed(), "You must agree to the terms of service before continuing.", "The message 'You must agree to the terms of service before continuing' did not appear.");
        basketPage.clickCloseMessageButton();
        basketPage.clickMyAccountButton();
        myAccountPage.clickAddressesButton();
        myAccountPage.clickDeleteAddressesButton();
        myAccountPage.waitForElementDisplayed();
    }

    @Test(groups = {"Regression"}, retryAnalyzer = Retry.class)
    @Description("Cart deletion test")
    public void cartDeletionTest() {
        loginPage.clickLoginButton();
        loginPage.login(userEmail, userPassword);
        myAccountPage.clickHomeButton();
        productsPage.clickWomenButton();
        womenPage.waitForElementDisplayed();
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.waitForElementDisplayed();
        itemDetailsPage.clickAddToCartItemButton();
        itemDetailsPage.waitForItemCartDisplayed();
        basketPage.clickingOnTheShoppingCart();
        basketPage.clickDeleteItemButton();
        basketPage.clickingOnTheShoppingCart();
        Assert.assertTrue(basketPage.isIconInformationDisplayed(),
                "Item not removed from cart");
    }

    @Test(groups = {"Smoke"}, dataProvider = "inventoryItemsTestData", retryAnalyzer = Retry.class)
    @Description("Test for checking goods in the catalog")
    public void checkingGoodsInTheCatalogTest(String nameItem, String priceItem) {
        loginPage.clickLoginButton();
        loginPage.login(userEmail, userPassword);
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
                {"Floral Top  ", "624,00"},
        };
    }

    @DataProvider(name = "userAddAddressesData")
    public Object[][] userAddAddressesData() {
        return new Object[][]{
                {Addresses.builder().lastName(faker.name().lastName()).firstName(faker.name().firstName()).company(faker.company().name())
                        .address("Minskay").postCode("11111").city(faker.address().city())
                        .country("21").phone("25588445").mobile(faker.phoneNumber().phoneNumber())
                        .state("13").alias(faker.name().title()).build()},
        };
    }
}

