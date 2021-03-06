package test;

import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailAccountPage;
import page.GmailHomePage;
import sevice.UserCreator;

public class GmailLoginTest extends BaseTest {

    private User testUser = UserCreator.withCredentialsFromProperty();

    @Test
    public void login(){
        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        gmailHomePage.open();
        GmailAccountPage gmailAccountPage = gmailHomePage
                .fillLoginField(testUser.getUsername()).fillPasswordField(testUser.getPassword());

        Assert.assertTrue(gmailAccountPage.isLoginSuccessfull(), "Not successfull login");
    }

}
