package test;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AuthPage;
import page.FiltrationPage;

import java.time.Duration;

public class FiltrationTest extends CommonConditions {
    @Test
    public void testSearchProductWithSomeStats() throws InterruptedException {
        User user = new AuthPage(driver)
                .open()
                .fillEmailAndPassword()
                .getUser();

        Assert.assertFalse(user.getEmail().isEmpty(), "User is not authorized");

        FiltrationPage filtrationPage = new FiltrationPage(driver);
        filtrationPage.searchProductWithSomeStats();

        String expectedUrl = "apple";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.toLowerCase().contains(expectedUrl), "URL does not contain Apple");
    }
}
