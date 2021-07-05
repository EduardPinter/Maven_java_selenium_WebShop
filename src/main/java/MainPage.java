import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class MainPage {

    protected WebDriver driver;
    protected String word = "blouse";

    @FindBy(css = "a[title='Women']")
    WebElement womenNavigationLink;
    @FindBy(css = ".first-in-line-xs.submenu-container a[title='T-shirts']")
    WebElement tshirtSection;
    @FindBy(id = "search_query_top")
    WebElement searchInputField;
    @FindBy(name = "submit_search")
    WebElement searchButton;
    @FindBy(className = "bx-next")
    WebElement nextButton;
    @FindBy(css = "#homeslider")
    WebElement sliderSelector;
    @FindBy(css = "#homepage-slider")
    WebElement sliderScreenshot;
    @FindBy(css = "#homeslider > li:nth-child(4) > a > img")
    WebElement srcRedDress;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverWomenSection(){
        Actions actions = new Actions(driver);
        actions.moveToElement(womenNavigationLink).perform();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(tshirtSection));
    }

    public void clickTshirtSection(){
        tshirtSection.click();
    }

    public void searchBarSendKeys(String word){
        searchInputField.sendKeys(word);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickNextButtonSlider() throws InterruptedException {
        nextButton.click();
        Thread.sleep(1000);
    }

    public String getSliderCssProperty(){
        return sliderSelector.getCssValue("left");
    }

    public String getSrcAttribute(){
        return srcRedDress.getAttribute("src");
    }

    public void screenshotElement() throws IOException {
        File file = sliderScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenshot.png"));
    }
}
