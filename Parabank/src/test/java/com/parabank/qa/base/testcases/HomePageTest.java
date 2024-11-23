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

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    AccountOverviewPage accountOverviewPage;
    OpenNewAccountPage opennewaccountPage;

    //Constructor
    public HomePageTest(){
        super();
    }

    //Test cases should be separated -- independent with each other
    //before each test case -- lauch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        opennewaccountPage = new OpenNewAccountPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
    }

    @Test(priority=1)
    public void verifyHomePageTitleTest(){
    String homePageTitle = homePage.verifyHomePageTitle();
    Assert.assertEquals(homePageTitle,"ParaBank | Accounts Overview","Home page title not matched");
        System.out.println("Este es el titulo de la pagina::"+homePageTitle );
    }

    @Test(priority=2)
    public void verifyUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUsername());
    }

    @Test(priority = 3)
    public void verifyAccountOverviewLinkTest(){
        testUtil.switchToFrame();
        accountOverviewPage = homePage.clickAccountOverviewLink();
    }

 @Test(priority = 4)
    public void verifyOpenNewAccountLinkTest(){
        testUtil.switchToFrame();
         opennewaccountPage = homePage.clickOnAccountsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
