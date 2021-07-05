import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class MainScreenshotElement extends TestBase{

    protected String pixelsRedDress = "-2337px";
    protected String srcOfPicture = "http://automationpractice.com/modules/homeslider/images/sample-3.jpg";

    @Test
    public void TestScreenshotElement() throws InterruptedException, IOException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickNextButtonSlider();
        mainPage.clickNextButtonSlider();
        Assert.assertEquals("Expected value is not the same as Actual", mainPage.getSliderCssProperty(), pixelsRedDress);
        Assert.assertEquals("Expected 'src' attribute is not the same as Actual", mainPage.getSrcAttribute(), srcOfPicture);
        mainPage.screenshotElement();

    }
}
