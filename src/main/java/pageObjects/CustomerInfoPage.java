package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import testSetup.SetupClass;

public class CustomerInfoPage extends SetupClass {
    @FindBy(xpath = "//p[text() = 'Customer Registered Successfully!!!']")
    WebElement lableSuccess;

    @FindBy(xpath = "//td[text() = 'Customer ID']/following-sibling::td")
    WebElement txtCustomerId;

    @FindBy(xpath = "//td[text() = 'Customer Name']/following-sibling::td")
    WebElement txtCustomerName;

    @FindBy(xpath = "//td[text() = 'Gender']/following-sibling::td")
    WebElement txtGender;

    @FindBy(xpath = "//td[text() = 'Birthday']/following-sibling::td")
    WebElement txtBirthDay;

    @FindBy(xpath = "//td[text() = 'Address']/following-sibling::td")
    WebElement txtAddress;

    @FindBy(xpath = "//td[text() = 'City']/following-sibling::td")
    WebElement txtCity;

    @FindBy(xpath = "//td[text() = 'State']/following-sibling::td")
    WebElement txtState;

    @FindBy(xpath = "//td[text() = 'Pin']/following-sibling::td")
    WebElement txtPin;

    @FindBy(xpath = "//td[text() = 'Mobile No.']/following-sibling::td")
    WebElement txtMobileNumber;

    @FindBy(xpath = "//td[text() = 'Email']/following-sibling::td")
    WebElement txtEmail;

    @FindBy(linkText = "Continue")
    WebElement linkContinue;

    public CustomerInfoPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCustomerInfo(String customerName, String gender, String birthday, String address, String city, String state, String pin, String phone, String email) {
        Assert.assertEquals(txtCustomerName.getText(), customerName);
        Assert.assertEquals(txtGender.getText().toLowerCase(), gender.toLowerCase());
        Assert.assertEquals(txtAddress.getText(), address);
        Assert.assertEquals(txtCity.getText(), city);
        Assert.assertEquals(txtState.getText(), state);
        Assert.assertEquals(txtPin.getText(), pin);
        Assert.assertEquals(txtMobileNumber.getText(), phone);
        Assert.assertEquals(txtEmail.getText(), email);
    }

    public String getCustomerId() {
        return txtCustomerId.getText();
    }

    public boolean verifyAddCustomerSuccess() {
    	try {
    		return lableSuccess.isDisplayed();
    	}catch(ElementNotFoundException ex) {
    		System.out.println("Add customer Failed");
    		return false;
    	}
        
    }
}
