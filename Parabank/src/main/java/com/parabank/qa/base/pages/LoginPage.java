//Pagina de Inicio de sesion
package com.parabank.qa.base.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.parabank.qa.base.base.TestBase;

public class LoginPage extends TestBase {

    //Page factory - OR:
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id='loginPanel']/form/div[3]/input")
    WebElement loginBtn;

    //Validar url para registro
//    @FindBy(css = "#loginPanel > p:nth-child(3) > a")
//    WebElement SignUpUrl;

    //Validar titulo Parabank
    @FindBy(xpath = "//img[contains(@class,'logo')]")
    WebElement pbankLogo;

    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Page Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateParBankImage() {
        return pbankLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }


}
