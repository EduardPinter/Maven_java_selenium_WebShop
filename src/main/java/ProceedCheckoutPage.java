import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ProceedCheckoutPage {

    protected WebDriver driver;
    protected String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
    protected String loginTitle = "Login - My Store";

    public ProceedCheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl(){
       return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}