//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;


//public class PruebaHumo {
//  public static void main(String[] arg){
      /*
      *Steps to automate:
      * 1.Open Chrome
      * 2.Navigate to URL
      * 3.Enter UserName
      * 4.Enter Password
      * 5.Click on Subimt button
      * 6.Validation (Login successfull)
      * a) Welcome Jonh mensaj¿ge is coming
      * b) Title of the page is coming as Account Overview
       */

//      //Configuracion- Chromedriver path setting
//      System.setProperty("webdriver.chrome.driver","C:\\Users\\sebas\\IdeaProjects\\Parabank\\.idea\\ChromeDriver\\chromedriver.exe");
//
//      //1.Abrir navegador
//      WebDriver driver = new ChromeDriver();
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      driver.manage().window().maximize();
//
//      //2.Navigate URL
     // driver.get("https://parabank.parasoft.com/");

      //Enter username
//      WebElement aUserName=driver.findElement(By.name("username"));
//      aUserName.sendKeys("john");
//
//      //3.Enter password
//      WebElement aPassword = driver.findElement(By.name("password"));
//      aPassword.sendKeys("demo");
//
//      //Submit-XPATH
//      WebElement aSubmit = driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input"));
//      aSubmit.click();
//
//        String expectativa = "ParaBank | Accounts Overview";
//        String actual = driver.getTitle();
//
//        if (expectativa.equals(actual)){
//            System.out.println("Login Successfull");
//        } else {
//            System.out.println("Login Failed.");
//        }



//  }
//}
