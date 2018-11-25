package pageObjects;

import com.relevantcodes.extentreports.LogStatus;

import testSetup.SetupClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SetupClass {
    @FindBy(name = "uid")
    WebElement textboxUserId;

    @FindBy(name = "password")
    WebElement textboxPassword;

    @FindBy(name = "btnLogin")
    WebElement btnLogin;

    @FindBy(name = "btnReset")
    WebElement btnReset;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String userID, String password) {
        textboxUserId.sendKeys(userID);
        logger.log(LogStatus.INFO, "input userID: " + userID);

        textboxPassword.sendKeys(password);
        logger.log(LogStatus.INFO, "input password: " + password);

        btnLogin.click();
        logger.log(LogStatus.INFO, "click on Login Button");
        return new HomePage();
    }
}
