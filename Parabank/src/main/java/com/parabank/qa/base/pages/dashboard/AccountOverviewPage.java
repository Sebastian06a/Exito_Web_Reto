package com.parabank.qa.base.pages.dashboard;

import com.parabank.qa.base.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage extends TestBase {

    @FindBy (xpath = "//table[@id='accountTable' and @class='gradient-style']\n")
    WebElement accountTable;

    @FindBy (xpath = "//th[text()='Account']/following::tr[1]/td/a")
    WebElement account;

    @FindBy (xpath = "//th[text()='Balance*']/following::tr[1]/td[2]")
    WebElement balance;

    @FindBy (xpath = "//b[text()='Total']/following::td[1]/b[1]")
    WebElement totalBalance;

    @FindBy (xpath = "//th[text()='Available Amount']/following::tr[1]/td[3]")
    WebElement availableAmount;

    //Initializing the Page Objects:
    public AccountOverviewPage() {
        PageFactory.initElements(driver, this);
    }

    //01.Validar Account Table
    public boolean verifyAccountsTable(){
        return accountTable.isDisplayed();
    }










}
