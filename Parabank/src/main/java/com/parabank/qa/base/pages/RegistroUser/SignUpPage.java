//Pagina de registro
package com.parabank.qa.base.pages.RegistroUser;

import com.parabank.qa.base.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {

//Element Locators - Register usuario
@FindBy(css = "#loginPanel > p:nth-child(3) > a")
WebElement BtnSignUpUrl;

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement addStreet;

    @FindBy(id = "customer.address.city")
    WebElement addCity;

    @FindBy(id = "customer.address.state")
    WebElement addState;

    @FindBy(id = "customer.address.zipCode")
    WebElement addZipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    WebElement customerSSN;

    @FindBy(id = "customer.username")
    WebElement customUsername;

    @FindBy(id = "customer.password")
    WebElement custoPassword;

    @FindBy(id = "repeatedPassword")
    WebElement repeatedPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement btnRegister;

    //Validar mensaje de registro exitoso
    @FindBy(css = "#rightPanel > p")
    WebElement registroExitoso;

    //Initializing the Page Objects:
    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageRegister(){
        return driver.getTitle();
    }

    public SignUpPage clicOnRegisterLink(){
        BtnSignUpUrl.click();
        return new SignUpPage();
    }
}
