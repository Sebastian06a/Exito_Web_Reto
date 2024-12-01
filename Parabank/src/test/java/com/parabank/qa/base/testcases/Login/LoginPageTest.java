package com.parabank.qa.base.testcases.Login;

import com.parabank.qa.base.pages.Login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.parabank.qa.base.base.TestBase;
import com.parabank.qa.base.pages.Home.HomePage;


public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    //Constructor
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();

        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "ParaBank | Welcome | Online Banking");
    }

    @Test(priority = 2)
    public void parabankLogoImageTest() {
        boolean flag = loginPage.validateParBankImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
    }

@AfterMethod
    public void tearDown(){
        driver.quit();
}
}
