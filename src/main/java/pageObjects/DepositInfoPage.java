package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testSetup.SetupClass;

public class DepositInfoPage extends SetupClass {
    @FindBy(xpath = "//p[text() = 'Account Generated Successfully!!!']")
    WebElement lableSuccess;

    @FindBy(xpath = "//td[text() = 'Transaction ID']/following-sibling::td")
    WebElement txtTransactionId;

    @FindBy(xpath = "//td[text() = 'Account No']/following-sibling::td")
    WebElement txtAccountNo;

    @FindBy(xpath = "//td[text() = 'Amount Credited']/following-sibling::td")
    WebElement txtAmount;

    @FindBy(xpath = "//td[text() = 'Type of Transaction']/following-sibling::td")
    WebElement txtTypeOfTransaction;

    @FindBy(xpath = "//td[text() = 'Description']/following-sibling::td")
    WebElement txtDescription;

    @FindBy(xpath = "//td[text() = 'Current Balance']/following-sibling::td")
    WebElement txtCurrentBalance;

    public DepositInfoPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyDepositDetail(String customerId, String accountNumber, String amount, String description, String currentBalance) {
        String typeOfTransaction = "Deposit";
        Assert.assertEquals(txtAccountNo.getText(), accountNumber);
        Assert.assertEquals(txtAmount.getText(), amount);
        Assert.assertEquals(txtTypeOfTransaction.getText(), typeOfTransaction);
        Assert.assertEquals(txtDescription.getText(), description);
        Assert.assertEquals(txtCurrentBalance.getText(), currentBalance);
    }
}
