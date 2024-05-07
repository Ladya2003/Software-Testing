package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AuthPage;
import page.CartPage;
import page.CommentPage;
import page.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class CommentTest extends CommonConditions {
    @Test
    public void testWrittingComment() throws InterruptedException {
        User user = new AuthPage(driver)
                .open()
                .fillEmailAndPassword()
                .getUser();

        assertThat("User is authorized", !user.getEmail().isEmpty());

        ProductPage productPage = new ProductPage(driver);
        productPage.open();

        CommentPage commentPage = new CommentPage(driver);
        commentPage.writeCommentWithOver500Characters("All good",
                "No disadvantages",
                "This is a test comment. Please, don't mind it");

        boolean thankYouMessageDisplayed = commentPage.isThankYouMessageDisplayed();
        Assert.assertTrue(thankYouMessageDisplayed, "Comment was successfully added");

    }
}
