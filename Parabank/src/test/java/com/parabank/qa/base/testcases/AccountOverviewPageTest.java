package com.parabank.qa.base.testcases;

import com.parabank.qa.base.base.TestBase;
import com.parabank.qa.base.pages.AccountOverviewPage;
import com.parabank.qa.base.pages.HomePage;
import com.parabank.qa.base.pages.LoginPage;
import com.parabank.qa.base.pages.OpenNewAccountPage;
import com.parabank.qa.base.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountOverviewPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    AccountOverviewPage accountOverviewPage;
    OpenNewAccountPage opennewaccountPage;


    //Constructor
    public AccountOverviewPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        accountOverviewPage = new AccountOverviewPage();
        opennewaccountPage = new OpenNewAccountPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
        testUtil.switchToTableFrame();
        accountOverviewPage = homePage.clickAccountOverviewLink();
        opennewaccountPage = homePage.clickOnAccountsLink();
    }

    //Validar Accounts Table
    @Test(priority=1)
    public void verifyAccountsTableTest(){
        testUtil.switchToTableFrame();
        Assert.assertTrue(accountOverviewPage.verifyAccountsTable());
    }






    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
