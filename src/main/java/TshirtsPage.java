import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TshirtsPage{

    protected WebDriver driver;

    @FindBy(css = "h5 > a[title='Faded Short Sleeve T-shirts']")
    WebElement fadedShortSleeve;

    public TshirtsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFadedShortSleeve(){
        fadedShortSleeve.click();
    }

}