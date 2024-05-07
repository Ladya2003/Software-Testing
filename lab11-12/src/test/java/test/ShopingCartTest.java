package test;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopingCartTest extends CommonConditions {
    @Test
    public void shopingCartTest() throws InterruptedException {
        User user = new AuthPage(driver)
                .open()
                .fillEmailAndPassword()
                .getUser();

        Assert.assertFalse(user.getEmail().isEmpty(), "User is not authorized");

        ProductPage productPage = new ProductPage(driver);
        productPage.open();
        productPage.addToCart();
        productPage.goToCart();

        // Ожидание URL с https://nsv.by/basket/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlMatches("https://nsv.by/basket/"));
    }

}
