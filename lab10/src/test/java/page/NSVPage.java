package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NSVPage {
    private WebDriver driver;

    public NSVPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "title-search-input_fixed")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='subserch']")
    private WebElement searchButton;

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

    public void searchPhone(String phoneName) throws InterruptedException {
        searchInput.sendKeys(phoneName);
        searchButton.click();
        Thread.sleep(5000);
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
