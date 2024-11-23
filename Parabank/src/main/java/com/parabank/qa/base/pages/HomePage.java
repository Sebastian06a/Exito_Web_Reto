//Pagina de Inicio
package com.parabank.qa.base.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.parabank.qa.base.base.TestBase;

public class HomePage extends TestBase {

//    @FindBy(xpath = "//P[contains(text(),'ww ww')]")
//    WebElement userNameLabel;

    // validacion de nombre de ususario
    @FindBy(css = "#leftPanel > p")
    WebElement userNameLabel;

    //validacion de Account Overview
    @FindBy(css = "#leftPanel > ul > li:nth-child(2) > a")
    WebElement AccountOverviewlink;

    //validacion de aperturar nueva cuenta
    @FindBy(css = "#leftPanel > ul > li:nth-child(1) > a")
    WebElement openNewAccountLink;

    //validacion detransferencia de fondos
    @FindBy(css = "#leftPanel > ul > li:nth-child(3) > a")
    WebElement transFundsLink;

    //validación de Solicitar préstamo
    @FindBy(css = "#leftPanel > ul > li:nth-child(7) > a")
    WebElement RequestLoanLink;

    //Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Validar el titulo de la pagina web
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    //Validar nombre del usuario
    public boolean verifyCorrectUsername(){
        return userNameLabel.isDisplayed();
    }

    //Validar ver cuentas de usuario
    public AccountOverviewPage clickAccountOverviewLink() {
        AccountOverviewlink.click();
        return new AccountOverviewPage();
    }

    //Validar nuevas cuentas nuevas
    public OpenNewAccountPage clickOnAccountsLink() {
        openNewAccountLink.click();
        return new OpenNewAccountPage();
    }

    public TransferFundsPage clickOnFundsLink() {
        transFundsLink.click();
        return new TransferFundsPage();
    }

    public RequestLoanPage clickOnRequestLink() {
         RequestLoanLink.click();
         return new RequestLoanPage();
        }
    }
