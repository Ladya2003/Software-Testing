package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CallPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    @FindBy(xpath = "//*[@id=\'ClickCallBack\']")
    private WebElement callForm;

    @FindBy(xpath = "//*[@id=\'comp_5c11fd50eca000304bc4c3616bab9880\']/div/form/div[1]/div[1]/input")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"comp_5c11fd50eca000304bc4c3616bab9880\"]/div/form/div[1]/div[2]/input")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\'FormCall\']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='ClickCallBack']")
    private WebElement callButton;

    @FindBy(xpath = "//*[@id='comp_5c11fd50eca000304bc4c3616bab9880']/div/form/div[1]/div[1]/input")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id='comp_5c11fd50eca000304bc4c3616bab9880']/div/form/div[1]/div[2]/input")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id='licenses_popup']")
    private WebElement agreeCheckBox;

    @FindBy(xpath = "//*[@id='FormCall']")
    private WebElement phoneButton;

    public CallPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void callForm(String name, String phone) throws InterruptedException {
        callButton.click();
        Thread.sleep(3000);
        nameField.sendKeys(name);
        phoneField.sendKeys(phone);
        agreeCheckBox.click();
        phoneButton.click();
        Thread.sleep(5000);
    }
}
