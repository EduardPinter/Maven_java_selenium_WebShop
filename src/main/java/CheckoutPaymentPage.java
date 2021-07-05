import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPaymentPage {

    protected WebDriver driver;
    protected String descColorSize = "Color : Blue, Size : M";


    @FindBy(css = "small:nth-of-type(2) > a")
    WebElement summaryProductAttr;
    @FindBy(css = ".address_0.cart_item.first_item.last_item.odd  p > a")
    WebElement summaryProductTitle;
    @FindBy(id = "total_product")
    WebElement summaryTotalPrice;
    @FindBy(css = "div#center_column  a[title='Proceed to checkout'] > span")
    WebElement proceedToCheckout;

    public CheckoutPaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getElementText(WebElement element){ // Not sure about this one but probably good
        return element.getText();
    }

    public void clickOnProceed(){
        proceedToCheckout.click();
    }
}
