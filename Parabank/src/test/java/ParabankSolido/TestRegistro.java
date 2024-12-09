package ParabankSolido;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class TestRegistro {

    @Test (priority =1)
    public static void main(String[] args)
    {
        //Desabilitar ventana emergente de guardado de dirección
        ChromeOptions options = new ChromeOptions();
        Map<String,Object> prefs = new HashMap<String, Object>();
        prefs.put("autofill.profile_enabled",false);
        options.setExperimentalOption("prefs",prefs);

        //Abrir Navegador
        //WebDriverManager.chromedriver().browserVersion("126.1").setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //Configuracion-Chromedriver path setting
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sebas\\IdeaProjects\\Parabank\\browserdrivers\\chromedriver28.exe");

        //Navigate URL
        driver.get("https://parabank.parasoft.com/");

        //Localizadores de registro de usuario
        WebElement signUpbtn = driver.findElement(By.cssSelector("div#loginPanel > p:nth-last-child(1)>a"));
        signUpbtn.click();

        WebElement firstName = driver.findElement(By.cssSelector("input#customer\\.firstName"));
        firstName.sendKeys("Alonso");

        WebElement lastName = driver.findElement(By.cssSelector("input#customer\\.lastName"));
        lastName.sendKeys("Raymundo");

        WebElement address = driver.findElement(By.cssSelector("input#customer\\.address\\.street"));
        address.sendKeys("Chorrillos av los eucaliptos");

        WebElement addressCity = driver.findElement(By.cssSelector("input#customer\\.address\\.city"));
        addressCity.sendKeys("Lima");

        WebElement addresState = driver.findElement(By.cssSelector("input#customer\\.address\\.state"));
        addresState.sendKeys("Chorrillos");

        WebElement addreszipCode = driver.findElement(By.cssSelector("input#customer\\.address\\.zipCode"));
        addreszipCode.sendKeys("15057");

        WebElement phoneNumber = driver.findElement(By.cssSelector("input#customer\\.phoneNumber"));
        phoneNumber.sendKeys("938608879");

        WebElement ssnSeguro = driver.findElement(By.cssSelector("input.input[name='customer.ssn'][type='text']"));
        ssnSeguro.sendKeys("123456");

        WebElement userName = driver.findElement(By.cssSelector("input#customer\\.username"));
        userName.sendKeys("au");
        WebElement passWord = driver.findElement(By.cssSelector("input#customer\\.password"));
        passWord.sendKeys("au");
        WebElement repeatedPassword = driver.findElement(By.cssSelector("input#repeatedPassword"));
        repeatedPassword.sendKeys("au");

        //Boton de click registro
        WebElement registro = driver.findElement(By.cssSelector("#customerForm > table > tbody > tr:nth-child(13) >td:nth-child(2)>input"));
        registro.click();

        //Validar mensaje exitoso
        //String expectedTitle = "If you have an account with us you can sign-up for free instant online access. You will have to provide some personal information.";
        WebElement expo = driver.findElement(By.cssSelector("#rightPanel > p"));
        String actualTitle = expo.getText();

        System.out.println("the first message is :: "+actualTitle);

        try {
        //Validar mensaje de error
            WebElement usernamee =driver.findElement(By.cssSelector("span#customer\\.username\\.errors.error"));
            String firsText = usernamee.getText();
            System.out.println("the second error message is :: "+firsText);
            driver.quit();
        }
        catch(NoSuchElementException e) {
            //Cerrar sesión
            WebElement loGouts = driver.findElement(By.cssSelector("div#leftPanel > ul > li:nth-child(8) > a"));
            loGouts.click();

            //Validar Login
            WebElement aUserName=driver.findElement(By.name("username"));
            aUserName.sendKeys("au");
            String actualusuario2 = aUserName.getText();
            System.out.println(actualusuario2);
            WebElement aPassword = driver.findElement(By.name("password"));
            aPassword.sendKeys("au");
            WebElement aSubmit = driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input"));
            aSubmit.click();


            //Assert.assertEquals(userName ,aUserName,"El usuario ingresado y el esperado no coinciden");
            //Assert.assertEquals("Ray72",actualusuario2);

            //Validar Accounts Overview
            String expectativa = "ParaBank | Accounts Overview";
            String actual = driver.getTitle();
            if (expectativa.equals(actual)){
                System.out.println("Login Successfull:: " +expectativa);
            } else {
                System.out.println("Login Failed:: ");
            }
            //driver.quit();
        }
         //driver.close();
        //driver.quit();
    }
}