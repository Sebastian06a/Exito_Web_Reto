//Abrir nueva cuenta
package com.parabank.qa.base.pages.dashboard;

import com.parabank.qa.base.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountPage extends TestBase {

    @FindBy (xpath = "//*[@id=\"leftPanel\"]/ul/li[1]/a")
    WebElement newaccountLabel;

    @FindBy (xpath = "//*[@id=\"type\"]")
    WebElement tipoCuenta;

    @FindBy (xpath = "//*[@id=\"type\"]/option[2]")
    WebElement cuentaSaving;

    @FindBy (xpath = "//*[@id=\"openAccountForm\"]/form/div/input")
    WebElement opennewAccountBtn;

    //Initializing the Page Objects:
    public OpenNewAccountPage() {
        PageFactory.initElements(driver, this);
    }

    //01. Validar comprobacion si es verdadera en newaccountLabel
    public boolean verifyOpenNewAccountLabel(){
        return newaccountLabel.isDisplayed();
    }

    //02. Validar selectFondosOpenNewAccount
    public void selectNewAccountByName(String SAVINGS ){
        driver.findElement(By.xpath("//option[text()='"+SAVINGS+"']")).click();
    }

}
