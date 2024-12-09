//Pagina de Inicio
package com.parabank.qa.base.pages.Home;

import com.parabank.qa.base.pages.dashboard.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.parabank.qa.base.base.TestBase;

public class HomePage extends TestBase {

    //01.validación de nombre de usuario
    @FindBy(css = "#leftPanel > p")
    WebElement userNameLabel;

    //02.validación de "Open New Account"
    @FindBy(css = "#leftPanel > ul > li:nth-child(1) > a")
    WebElement openNewAccountLink;

    //03.validacion de "Accounts Overview"
    @FindBy(css = "#leftPanel > ul > li:nth-child(2) > a")
    WebElement AccountOverviewlink;

    //04.validación de "Transfer Funds"
    @FindBy(css = "#leftPanel > ul > li:nth-child(3) > a")
    WebElement transferFundsLink;

    //05.* Validacion de "Bill Pay"
    @FindBy(css = "#leftPanel > ul > li:nth-child(4) > a")
    WebElement billPayLink;

    //06.* Validacion de "Find Transactions"
    @FindBy(css = "#leftPanel > ul > li:nth-child(5) > a")
    WebElement findTransactionsLink;

    //07.* Validación de "Update Contact Info"
    @FindBy(css = "#leftPanel > ul > li:nth-child(6) > a")
    WebElement updateContactInfoLink;

    //8.validación de "Request Loan"  Solicitar préstamo
    @FindBy(css = "#leftPanel > ul > li:nth-child(7) > a")
    WebElement RequestLoanLink;



    //Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //01.Validar el titulo de la pagina web
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    //02.Validar nombre de usuario
    public boolean verifyCorrectUsername(){
        return userNameLabel.isDisplayed();
    }

    //03.Validar "Open New Account"
    public OpenNewAccountPage clickOpenNewAccountsLink() {
        openNewAccountLink.click();
        return new OpenNewAccountPage();
    }

    //04.Validar "Accounts Overview"
    public AccountOverviewPage clickAccountOverviewLink() {
        AccountOverviewlink.click();
        return new AccountOverviewPage();
    }

    //05.Validar "Transfer Funds"
    public TransferFundsPage clicktransferFundsLink() {
        transferFundsLink.click();
        return new TransferFundsPage();
    }

    //06.Validar "Bill Pay"
    public BillPayPage billPayPage(){
        billPayLink.click();
        return new BillPayPage();
    }

    //07.Validar "Find Transactions"
    public FindTransactionsPage findTransactionsPage(){
        findTransactionsLink.click();
        return new FindTransactionsPage();
    }

    //08.Validar "Update Contact Info"
    public UpdateContactInfo updateContactInfo(){
        updateContactInfoLink.click();
        return new UpdateContactInfo();
    }

    //09.Validar "Request Loan"
    public RequestLoanPage clickOnRequestLink() {
         RequestLoanLink.click();
         return new RequestLoanPage();
        }
    }
