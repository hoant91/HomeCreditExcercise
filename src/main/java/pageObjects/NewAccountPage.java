package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testSetup.SetupClass;

public class NewAccountPage extends SetupClass {
    @FindBy (name = "cusid")
    WebElement tbxCustomerId;

    @FindBy (name = "selaccount")
    WebElement dpAccountType;

    @FindBy (name = "inideposit")
    WebElement tbxInitDeposit;

    @FindBy (name = "button2")
    WebElement btnSubmit;

    @FindBy (name = "reset")
    WebElement btnReset;

    public NewAccountPage(){
        PageFactory.initElements(driver, this);
    }
    public AccountInfoPage addAccount(String customerId, String accountType, String initDeposit){
        try{
            tbxCustomerId.sendKeys(customerId);
            selectAccountType(dpAccountType,accountType);
            tbxInitDeposit.sendKeys(initDeposit);
            btnSubmit.click();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new AccountInfoPage();
    }

    public void selectAccountType(WebElement element,String option){
        Select options = new Select(element);
        options.selectByVisibleText(option);
    }

    public String getSeletcValue(WebElement element){
        Select options = new Select(element);
        return options.getFirstSelectedOption().getText();
    }
}
