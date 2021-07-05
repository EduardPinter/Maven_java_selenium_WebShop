import org.junit.Assert;
import org.junit.Test;

public class MainCheckoutAssertations extends TestBase{

    @Test
    public void TestCheckoutAssertation(){

        MainPage mainPage = new MainPage(driver);
        mainPage.hoverWomenSection();
        mainPage.clickTshirtSection();
        TshirtsPage tshirtsPage = new TshirtsPage(driver);
        tshirtsPage.clickOnFadedShortSleeve();
        FadedTshirtPage fadedTshirtPage = new FadedTshirtPage(driver);
        fadedTshirtPage.pickColor();
        fadedTshirtPage.pickSize();
        fadedTshirtPage.enterQuantity("2");
        fadedTshirtPage.addToCartClick();
        Assert.assertEquals("Expected title is not the same as actual title", fadedTshirtPage.shoppingCartTitleText , fadedTshirtPage.getElementText(fadedTshirtPage.shoppingCartTitle));
        Assert.assertEquals("Expected attributes are not the same as actual attributes", fadedTshirtPage.shoppingCartAttrText, fadedTshirtPage.getElementText(fadedTshirtPage.shoppingCartAttr));
        Assert.assertEquals("Expected quantity is not the same as actual quantity", fadedTshirtPage.shoppingCartQuantityText, fadedTshirtPage.getElementText(fadedTshirtPage.shoppingCartQuantity));
        Assert.assertEquals("Expected cost is not the same as actual cost", fadedTshirtPage.shoppingCartCostText, fadedTshirtPage.getElementText(fadedTshirtPage.shoppingCartPrice));
        fadedTshirtPage.proceedToCheckoutClick();
        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        Assert.assertEquals("Expected title is not the same as actual title", fadedTshirtPage.shoppingCartTitleText , checkoutPaymentPage.getElementText(checkoutPaymentPage.summaryProductTitle));
        Assert.assertEquals("Expected attributes are not the same as actual attributes", checkoutPaymentPage.descColorSize, checkoutPaymentPage.getElementText(checkoutPaymentPage.summaryProductAttr));
        Assert.assertEquals("Expected cost is not the same as actual cost", fadedTshirtPage.shoppingCartCostText, checkoutPaymentPage.getElementText(checkoutPaymentPage.summaryTotalPrice));
        checkoutPaymentPage.clickOnProceed();
        ProceedCheckoutPage proceedCheckoutPage = new ProceedCheckoutPage(driver);
        Assert.assertEquals("Expected page title is not the same as actual title", proceedCheckoutPage.loginTitle, proceedCheckoutPage.getPageTitle());
        Assert.assertEquals("Expected url is not the same as actual url", proceedCheckoutPage.loginPageUrl, proceedCheckoutPage.getPageUrl());


    }
}
