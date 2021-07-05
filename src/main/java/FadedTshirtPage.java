import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FadedTshirtPage {

    protected WebDriver driver;
    protected String shoppingCartTitleText = "Faded Short Sleeve T-shirts";
    protected String shoppingCartAttrText = "Blue, M";
    protected String shoppingCartQuantityText = "2";
    protected String shoppingCartCostText = "$33.02";

    @FindBy(id = "group_1")
    WebElement size;
    @FindBy(name = "Blue")
    WebElement color;
    @FindBy(id = "quantity_wanted")
    WebElement quantity;
    @FindBy(css = "p#add_to_cart  span")
    WebElement addToCartButton;
    @FindBy(id = "layer_cart_product_title")
    WebElement shoppingCartTitle;
    @FindBy(id = "layer_cart_product_attributes")
    WebElement shoppingCartAttr;
    @FindBy(id = "layer_cart_product_quantity")
    WebElement shoppingCartQuantity;
    @FindBy(id = "layer_cart_product_price")
    WebElement shoppingCartPrice;
    @FindBy(css = "a[title='Proceed to checkout'] > span")
    WebElement proceedToCheckout;
    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    WebElement fadedShortSleeveLinkText;

    public FadedTshirtPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pickSize(){
        Select dropSize = new Select(size);
        dropSize.selectByVisibleText("M");
    }

    public void pickColor(){  color.click(); }

    public void enterQuantity(String quantityNumber){
        quantity.clear();
        quantity.sendKeys(quantityNumber);
    }

    public void addToCartClick(){
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(shoppingCartTitle));
    }

    public String getElementText(WebElement element){ // Not sure about this one but probably good
        return element.getText();
    }

    public void proceedToCheckoutClick(){
        proceedToCheckout.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(fadedShortSleeveLinkText));
    }

}
