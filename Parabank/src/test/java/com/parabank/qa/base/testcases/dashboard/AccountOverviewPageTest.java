package com.parabank.qa.base.testcases.dashboard;

import com.parabank.qa.base.base.TestBase;
import com.parabank.qa.base.pages.dashboard.AccountOverviewPage;
import com.parabank.qa.base.pages.Home.HomePage;
import com.parabank.qa.base.pages.Login.LoginPage;
import com.parabank.qa.base.pages.dashboard.OpenNewAccountPage;
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

    //Constructor
    public AccountOverviewPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        accountOverviewPage = new AccountOverviewPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
        testUtil.switchToTableFrame();
        accountOverviewPage = homePage.clickAccountOverviewLink();
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
