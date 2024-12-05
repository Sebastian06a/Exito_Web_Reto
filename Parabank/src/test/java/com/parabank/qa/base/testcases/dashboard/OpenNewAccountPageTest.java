package com.parabank.qa.base.testcases.dashboard;

import com.parabank.qa.base.pages.dashboard.AccountOverviewPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.parabank.qa.base.base.TestBase;
import com.parabank.qa.base.pages.Home.HomePage;
import com.parabank.qa.base.pages.Login.LoginPage;
import com.parabank.qa.base.pages.dashboard.OpenNewAccountPage;
import com.parabank.qa.base.util.TestUtil;

public class OpenNewAccountPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    OpenNewAccountPage opennewaccountPage;


    //Constructor
    public OpenNewAccountPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        opennewaccountPage = new OpenNewAccountPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
        testUtil.switchToFrame();
        opennewaccountPage = homePage.clickOpenNewAccountsLink();
    }

    //Validar New Accounts
    @Test(priority = 1)
    public void verifyOpenNewAccountPageLabel(){
        Assert.assertTrue(opennewaccountPage.verifyOpenNewAccountLabel(),"contacts label is missing on the page");
    }

    @Test(priority = 2)
    public void selectSingleOpenNewAccountPageTest(){
        opennewaccountPage.selectNewAccountByName("SAVINGS");
    }

    @Test(priority = 3)
    public void selectFondosOpenNewAccountPageTest(){
        opennewaccountPage.selectNewAccountByName("SAVINGS");
    }




    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
