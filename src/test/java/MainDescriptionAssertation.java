import org.junit.Assert;
import org.junit.Test;

public class MainDescriptionAssertation extends TestBase{

    @Test
    public void TestDescriptionAssertation(){

        MainPage mainPage = new MainPage(driver);
        mainPage.searchBarSendKeys(mainPage.word);
        mainPage.clickSearchButton();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.hoverBlouseItem();
        searchPage.clickQuickView();
        searchPage.switchToIframe();
        Assert.assertEquals("Expected item desc is not the same as actual", searchPage.blouseItemDescriptionText, searchPage.getBlouseDesc());

    }
}
