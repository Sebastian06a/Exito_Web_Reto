package com.parabank.qa.base.testcases.dashboard;

import com.parabank.qa.base.base.TestBase;
import com.parabank.qa.base.pages.Home.HomePage;
import com.parabank.qa.base.pages.Login.LoginPage;
import com.parabank.qa.base.pages.dashboard.AccountOverviewPage;
import com.parabank.qa.base.pages.dashboard.OpenNewAccountPage;
import com.parabank.qa.base.pages.dashboard.TransferFundsPage;
import com.parabank.qa.base.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TransferFundsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    AccountOverviewPage accountOverviewPage;
    OpenNewAccountPage opennewaccountPage;
    TransferFundsPage transferFundsPage;

//Constructor
    public TransferFundsPageTest (){
       super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        initialization();
        testUtil = new TestUtil();
        accountOverviewPage = new AccountOverviewPage();
        opennewaccountPage = new OpenNewAccountPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
        testUtil.switchToTableFrame();
        accountOverviewPage = homePage.clickAccountOverviewLink();
        opennewaccountPage = homePage.clickOpenNewAccountsLink();
        transferFundsPage = homePage.clicktransferFundsLink();
    }

    //Validar transferencia de fondos "Transfer Funds"
    @Test(priority=1)
    public void verifyTransferAmountTest(){
        testUtil.switchToTableFrame();
    Assert.assertTrue(transferFundsPage.verifyTransferAmount(), "Verificar Transferencia");
    }

@Test(priority=2)
public void verifyTransferfundsAmountTest(){

}

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
