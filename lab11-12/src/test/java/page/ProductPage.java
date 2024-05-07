package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    @FindBy(xpath = "//*[@id=\'bx_117848907_132412_basket_actions\']/span[1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\'bx_117848907_89698_basket_actions\']/span[1]")
    private WebElement addToCartButtonIPhone;
    @FindBy(xpath = "//*[@id=\'BasketDelete\']")
    private WebElement clearCartButton;
    @FindBy(xpath = "//*[@id=\'BasketHeaderIcon\']")
    private WebElement cartButton;
    @FindBy(xpath = "//*[@id=\'pagetitle\']/span[1]")
    private WebElement counterTitle;
    @FindBy(xpath = "//*[@id=\'header\']/div/div[1]/div/div/div/div[1]/div/a/img")
    private WebElement mainPageButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getCounterTitle() {
        return counterTitle;
    }

    public ProductPage addToCart() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        log.info("Add to cart button clicked");
        return this;
    }

    public ProductPage addToCartIPhone() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonIPhone)).click();
        log.info("Add to cart button clicked");
        return this;
    }

    public ProductPage clearCart() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(clearCartButton)).click();
        log.info("Clear cart button clicked");
        return this;
    }

    public CartPage goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
        log.info("Cart button clicked");
        return new CartPage(driver);
    }

    public ProductPage open() {
        driver.get(
                "https://nsv.by/catalog/mobilnye-telefony/smartfon-honor-magic-v2-16gb-512gb-mezhdunarodnaya-versiya-fioletovyy/");
        log.info("Product page opened");
        return this;
    }

    public ProductPage openIPhone() {
        driver.get(
                "https://nsv.by/catalog/mobilnye-telefony/apple/apple-iphone-13-128gb-temnaja-noch/");
        log.info("Product page opened");
        return this;
    }
}
