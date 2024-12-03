//Transferir fondos
package com.parabank.qa.base.pages.dashboard;

import com.parabank.qa.base.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPage extends TestBase {

    @FindBy (css = "input[id=\"amount\"]")
    WebElement transferamount;

    @FindBy (css = "select[id=\"fromAccountId\"]")
    WebElement fromaccount;

    @FindBy (css = "select[id=\"toAccountId\"]")
    WebElement toaccount;

    @FindBy (css = "#transferForm > div:nth-child(4) > input")
    WebElement transferBtn;

    //Initializing the Page Objects:
    public TransferFundsPage(){
    PageFactory.initElements(driver, this);
}

//01. Validar transferamount
    public boolean verifyTransferAmount(){
    return transferamount.isDisplayed();
    }


}
