package testcases;

import testSetup.SetupClass;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.*;
import org.testng.annotations.*;
import utils.ExcelUtil;
import utils.TestUtil;

public class AddCustomerAndDeposit extends SetupClass {
    LoginPage loginPage;
    HomePage homePage;
    NewCustomerPage newCustomer;
    NewAccountPage newAccount;
    DepositPage deposit;
    CustomerInfoPage customerInfo;
    AccountInfoPage accountInfo;
    DepositInfoPage depositInfo;

    String sheetName = "NewCustomer";
    String customerId = "";
    String accountId ="";
    public AddCustomerAndDeposit() {
        super();
    }
    @BeforeClass
    public void setUp() {
        initialization();
        logger = report.startTest(getClass().getSimpleName(),("AddNewCustomer_CreateAccount_Deposit"));
        loginPage = new LoginPage();
        homePage = loginPage.login(props.getProperty("userId"), props.getProperty("password"));
        logger.log(LogStatus.INFO, "Login successfully!");
    }
    @Test(dataProvider = "getTestData")
    public void AddNewCustomer_CreateAccount_Deposit(String customerName, String gender, String dateOfBirth, String address, String city, String state, String pin, String phone, String email, String password, String accountType, String initAmount, String depositAmount, String description) {
        // Click on New customer on left menu
        newCustomer = homePage.clickOnNewCustomer();
        logger.log(LogStatus.INFO, "Click on New Customer => Add new customer form ");
        // Input valid customer information and submit
        customerInfo = newCustomer.createNewCustomer(customerName, gender, dateOfBirth, address, city, state, pin, phone, email, password);

        // Verify add customer successfully
        customerInfo.verifyAddCustomerSuccess();
        logger.log(LogStatus.PASS, "Add new customer successfully!");
        // Get customerId
        customerId = customerInfo.getCustomerId();

        // Verify information of customer just created
        customerInfo.verifyCustomerInfo(customerName, gender, dateOfBirth, address, city, state, pin, phone, email);
        logger.log(LogStatus.INFO, "Customer information are correctly!");

        // Navigate to add account for customer just created
        newAccount = homePage.clickOnNewAccount();
        logger.log(LogStatus.INFO, "Navigate to create account for customer just created!");

        // Input account information
        accountInfo = newAccount.addAccount(customerId, accountType, initAmount);

        // Get accountId
        accountId = accountInfo.getAccountId();
        logger.log(LogStatus.INFO, "Create account successfully with Account Id: "+ accountId);
        
        // Verify information of account just created
        accountInfo.verifyAccountInfo(customerId, customerName, email, accountType, dateOfBirth, initAmount);
        logger.log(LogStatus.PASS, "Account information are correctly!");
        
        // Navigate to Deposit page
        deposit = homePage.clickOnDeposit();
        logger.log(LogStatus.INFO, "Navigate to Deposit for customer just created!");

        // Deposit for account of customer just created
        depositInfo = deposit.depositForCustomer(accountId, depositAmount, description);
        logger.log(LogStatus.INFO, "Deposit for customer just created");

        // Verify transaction detail of deposit
        String currentBalance = TestUtil.conculateBalance(initAmount, depositAmount);
        depositInfo.verifyDepositDetail(customerId, accountId, depositAmount, description, currentBalance);
        logger.log(LogStatus.PASS, "Deposit infomation correctly!");
    }

    @DataProvider
    public Object[][] getTestData() {
        Object data[][] = ExcelUtil.getTestData(sheetName);
        return data;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        report.endTest(logger);
        report.flush();
    }
}
