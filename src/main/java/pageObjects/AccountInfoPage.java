package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testSetup.SetupClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountInfoPage extends SetupClass {
    @FindBy(xpath = "//p[text() = 'Account Generated Successfully!!!']")
    WebElement lableSuccess;

    @FindBy(xpath = "//td[text() = 'Account ID']/following-sibling::td")
    WebElement txtAccountId;

    @FindBy(xpath = "//td[text() = 'Customer ID']/following-sibling::td")
    WebElement txtCustomerId;

    @FindBy(xpath = "//td[text() = 'Customer Name']/following-sibling::td")
    WebElement txtCustomerName;

    @FindBy(xpath = "//td[text() = 'Email']/following-sibling::td")
    WebElement txtEmail;

    @FindBy(xpath = "//td[text() = 'Account Type']/following-sibling::td")
    WebElement txtAccountType;

    @FindBy(xpath = "//td[text() = 'Date of Opening']/following-sibling::td")
    WebElement txtOpenDate;

    @FindBy(xpath = "//td[text() = 'Current Amount']/following-sibling::td")
    WebElement txtAmount;

    public AccountInfoPage(){
        PageFactory.initElements(driver, this);
    }

    public void verifyAccountInfo(String customerId, String customerName, String email, String accountType, String openDate, String amount) {
        Assert.assertEquals(txtCustomerId.getText(), customerId);
        Assert.assertEquals(txtCustomerName.getText(), customerName);
        Assert.assertEquals(txtEmail.getText(), email);
        Assert.assertEquals(txtAccountType.getText(), accountType);
        Assert.assertEquals(txtOpenDate.getText(), getOpenDate());
        Assert.assertEquals(txtAmount.getText(), amount);
    }

    public String getAccountId() {
        return txtAccountId.getText();
    }
    public boolean verifyAddCustomerSuccess() {
        return lableSuccess.isDisplayed();
    }

    private String getOpenDate(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String currentDate= dateFormat.format(date);
        System.out.println(currentDate);
        return currentDate;
    }
}
