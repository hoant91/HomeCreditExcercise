package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testSetup.SetupClass;

public class DepositPage extends SetupClass {
    @FindBy(name = "accountno")
    WebElement tbxAccountNo;

    @FindBy (name = "ammount")
    WebElement tbxAmount;

    @FindBy (name = "desc")
    WebElement tbxDescripstion;

    @FindBy (name = "AccSubmit")
    WebElement btnSubmit;

    @FindBy (name = "res")
    WebElement btnReset;

    public DepositPage(){
        PageFactory.initElements(driver, this);
    }
    public DepositInfoPage depositForCustomer(String accountNumber, String amount, String description){
        try{
            tbxAccountNo.sendKeys(accountNumber);
            tbxAmount.sendKeys(amount);
            tbxDescripstion.sendKeys(description);
            btnSubmit.click();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new DepositInfoPage();
    }
}
