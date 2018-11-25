package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import testSetup.SetupClass;

public class NewCustomerPage extends SetupClass {
    @FindBy(name = "name")
    WebElement tbxCustomerName;

    @FindBy(xpath = "//input[@name = 'rad1' and @value  = 'm']")
    WebElement rdMale;

    @FindBy(xpath = "//input[@name = 'rad1' and @value  = 'f']")
    WebElement rdFemale;

    @FindBy(name = "dob")
    WebElement tbxDateOfBirth;

    @FindBy(name = "addr")
    WebElement tbxAddress;

    @FindBy(name = "city")
    WebElement tbxCity;

    @FindBy(name = "state")
    WebElement tbxState;

    @FindBy(name = "pinno")
    WebElement tbxPin;

    @FindBy(name = "telephoneno")
    WebElement tbxMobileNumber;

    @FindBy(name = "emailid")
    WebElement tbxEmail;

    @FindBy(name = "password")
    WebElement tbxPassword;

    @FindBy(name = "sub")
    WebElement btnSubmit;

    @FindBy(name = "res")
    WebElement btnReset;

    public NewCustomerPage(){
        PageFactory.initElements(driver,this);
    }

    public CustomerInfoPage createNewCustomer(String customerName, String gender, String dateOfBirth, String address, String city, String state, String pin, String phone, String email, String password ){
    	tbxCustomerName.sendKeys(customerName);
    	logger.log(LogStatus.INFO, "input Customer Name: "+ customerName);
        if(gender.equalsIgnoreCase("Male")){
            rdMale.click();
        }else {
            rdFemale.click();
        }
        logger.log(LogStatus.INFO, "Select gender is "+ gender);
        tbxDateOfBirth.sendKeys(dateOfBirth);
        logger.log(LogStatus.INFO, "input Date Of Birth "+ dateOfBirth);
        tbxAddress.sendKeys(address);
        logger.log(LogStatus.INFO, "input Address "+ address);
        tbxCity.sendKeys(city);
        logger.log(LogStatus.INFO, "input City: "+ city);
        tbxState.sendKeys(state);
        logger.log(LogStatus.INFO, "input State: "+ state);
        tbxPin.sendKeys(pin);
        logger.log(LogStatus.INFO, "input Pin: "+ pin);
        tbxMobileNumber.sendKeys(phone);
        logger.log(LogStatus.INFO, "input Mobile number: "+ phone);
        tbxEmail.sendKeys(email);
        logger.log(LogStatus.INFO, "input Email: "+ email);
        tbxPassword.sendKeys(password);
        logger.log(LogStatus.INFO, "input Password: "+ password);
        btnSubmit.click();
        logger.log(LogStatus.INFO, "Click Submit button");
        return new CustomerInfoPage();
    }
}
