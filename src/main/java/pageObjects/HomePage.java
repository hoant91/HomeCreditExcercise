package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testSetup.SetupClass;

public class HomePage extends SetupClass {
    @FindBy(xpath = "//td[text() = 'Welcome To Manager's Page of Guru99 Bank']")
    WebElement lableWelcomeLink;

    @FindBy(xpath = "//a[text() = 'New Customer']")
    WebElement newCustomer;

    @FindBy(xpath = "//a[text() = 'New Account']")
    WebElement newAccount;

    @FindBy(xpath = "//a[text() = 'Deposit']")
    WebElement newDeposit;

    /*    @FindBy(xpath = "//td[text() = 'Welcome To Manager's Page of Guru99 Bank']")
        WebElement lableWelcome;

        @FindBy(xpath = "//td[text() = 'Welcome To Manager's Page of Guru99 Bank']")
        WebElement lableWelcome;*/
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public NewCustomerPage clickOnNewCustomer() {
        newCustomer.click();
        return new NewCustomerPage();
    }

    public NewAccountPage clickOnNewAccount() {
        newAccount.click();
        return new NewAccountPage();
    }

    public DepositPage clickOnDeposit() {
        newDeposit.click();
        return new DepositPage();
    }
}
