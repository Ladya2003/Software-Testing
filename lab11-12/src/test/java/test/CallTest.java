package test;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AuthPage;
import page.CallPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class CallTest extends CommonConditions {
    @Test
    public void testCallForm() throws InterruptedException {
        User user = new AuthPage(driver)
                .open()
                .fillEmailAndPassword()
                .getUser();

        assertThat("User is authorized", !user.getEmail().isEmpty());

        CallPage callPage = new CallPage(driver);
        callPage.callForm("Владислав",
                "291131281");

        Assert.assertTrue(
                driver.findElement(By.xpath("//*[@id=\'comp_5c11fd50eca000304bc4c3616bab9880\']/div/div[2]/div"))
                        .isDisplayed());
    }
}
