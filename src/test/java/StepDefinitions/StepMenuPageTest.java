package StepDefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StepMenuPageTest {


    WebDriver driver;

    @Dado("que estoy en el menu de la web")
    public void queEstoyEnElMenuDeLaWeb() {

        // Configuración del WebDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        // Configuración de Chrome para bloquear notificaciones
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Bloquea las notificaciones

        // Inicialización del navegador con opciones configuradas
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.exito.com/");
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.exito.com/");
//        driver.manage().timeouts().implicitlyWait(89, TimeUnit.SECONDS);
//    }

    @Cuando("ingreso a categorias de los productos")
    public void ingresoACategoriasDeLosProductos() {

        driver.findElement(By.xpath("//*[@id=\"menu_hamburguesa\"]")).click();


    }

    @Y("selecciono lo que necesite Dormitorio")
    public void seleccionoLoQueNecesiteDormitorio() {

        driver.findElement(By.xpath("//*[@id=\"__next\"]/header/aside/ul/section[2]/div/li[7]/div/div")).click();

    }

    @Entonces("debería ver las siguientes subcategorias")
    public void deberíaVerLasSiguientesSubcategorias() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"column-2\"]/li[1]/ul/li[1]/a")).click();

        Thread.sleep(20000);
    }

    @Y("selecciono el numero de paginacion {int}")
    public void seleccionoElNumeroDePaginacion(int arg0) throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section[4]/div/div[2]/div[2]/div[3]/section/div/ul/li[5]/button")));

    }

    @Y("le doy clic al boton de agregar producto")
    public void leDoyClicAlBotonDeAgregarProducto() throws InterruptedException {
        JavascriptExecutor executor0 = (JavascriptExecutor) driver;
        executor0.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section[4]/div/div[2]/div[2]/div[2]/ul/li[13]/article/div[2]/div/button")));
        Thread.sleep(500);
    }

    @Y("doy clic al botton del carrito")
    public void doyClicAlBottonDelCarrito() {
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"__next\"]/header/section/div/div[2]/div[2]/button/span")));

    }

    @Y("doy clic en el detalle del producto")
    public void doyClicEnElDetalleDelProducto() {
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@data-atom-image='true' and @src='https://exitocol.vtexassets.com/arquivos/ids/22941960-109-109' and @crossorigin='anonymous']")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Y("agrego varias veces el producto que es de mi interes")
    public void agregoVariasVecesElProductoQueEsDeMiInteres() throws InterruptedException {
        // Encuentra el primer elemento
        WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section/section[1]/section[2]/section/section[1]/div[1]/div/div/p/input"));


        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
        executor3.executeScript("arguments[0].click();", inputElement);

        Thread.sleep(30000);
        inputElement.sendKeys("0");
        Thread.sleep(500);

        // Realiza el scroll para que el elemento sea visible
        JavascriptExecutor scrollExecutor = (JavascriptExecutor) driver;
        scrollExecutor.executeScript("arguments[0].scrollIntoView(true);", inputElement); // Línea para el scroll
        Thread.sleep(30000); // Pausa para que el scroll sea visible

        // Encuentra el tercero elemento
        WebElement inputElement1 = driver.findElement(By.xpath("//button[contains(@class, 'BuyNowStyle_default__nculq') and span[text()='Comprar Ahora']]"));

        JavascriptExecutor executor4 = (JavascriptExecutor) driver;
        executor4.executeScript("arguments[0].click();", inputElement1);
        inputElement1.click();

    }

    @Y("doy clic al boton de pagar el total")
    public void doyClicAlBotonDePagarElTotal() throws InterruptedException {
        // Espera explícita para garantizar que el botón esté listo
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'exito-checkout-io-0-x-paymentButton')]")));

        // Scroll hacia el botón
        JavascriptExecutor executorScroll = (JavascriptExecutor) driver;
        executorScroll.executeScript("arguments[0].scrollIntoView(true);", inputElement2);
        Thread.sleep(500);

        // Clic con JavaScript si es necesario
        JavascriptExecutor executorClick = (JavascriptExecutor) driver;
        executorClick.executeScript("arguments[0].click();", inputElement2);

        // Intenta también con Selenium (en caso de que funcione directamente)
        inputElement2.click();
    }
}

//    @Y("doy clic al boton de pagar el total")
//    public void doyClicAlBotonDePagarElTotal() {
//        WebElement inputElement2 = driver.findElement(By.xpath("//*[@id=\"render-store.custom.checkout-io\"]/div/div[1]/div/div[1]/div/div/div/div[2]/div[4]/div[5]/button"));
//        JavascriptExecutor executor5 = (JavascriptExecutor) driver;
//        executor5.executeScript("arguments[0].click();", inputElement2);
//        inputElement2.click();
//    }
//}


//WebElement button = driver.findElement(By.xpath(""));
// int numClicks = 5;
//Thread.sleep(100);
//for (int i = 0; i < numClicks; i++) {
//    button.click();
//    Thread.sleep(500); // Espera 500 milisegundos (0.5 segundos)








