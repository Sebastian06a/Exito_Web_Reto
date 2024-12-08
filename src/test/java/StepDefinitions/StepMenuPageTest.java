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
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
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
        WebElement paginationButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section[4]/div/div[2]/div[2]/div[3]/section/div/ul/li[5]/button"));

        // Hacer scroll hasta el elemento
        executor.executeScript("arguments[0].scrollIntoView(true);", paginationButton);
        Thread.sleep(20000); // Espera fija de 1 segundo para asegurar que el scroll se complete

        // Hacer clic en el elemento
        executor.executeScript("arguments[0].click();", paginationButton);
    }



//    @Y("selecciono el numero de paginacion {int}")
//    public void seleccionoElNumeroDePaginacion(int arg0) throws InterruptedException {
//
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section[4]/div/div[2]/div[2]/div[3]/section/div/ul/li[5]/button")));



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
        // Encuentra el primer elemento (campo de input)
        WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section/section[1]/section[2]/section/section[1]/div[1]/div/div/p/input"));

        // Realiza un scroll suave para enfocar el elemento antes de interactuar
        JavascriptExecutor scrollExecutor = (JavascriptExecutor) driver;
        scrollExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", inputElement);
        Thread.sleep(500); // Pausa breve para que el scroll se complete

        // Haz clic en el elemento con JavaScript
        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
        executor3.executeScript("arguments[0].click();", inputElement);

        // Espera (simulando tiempo necesario para cargar datos o interacciones)
        Thread.sleep(3000); // Ajusta el tiempo según el comportamiento de la página

        // Ingresa el valor "0" en el campo
        inputElement.sendKeys("0");
        Thread.sleep(500);

        // Encuentra el botón "Comprar Ahora"
        WebElement inputElement1 = driver.findElement(By.xpath("//button[contains(@class, 'BuyNowStyle_default__nculq') and span[text()='Comprar Ahora']]"));

        // Haz clic en el botón con JavaScript
        JavascriptExecutor executor4 = (JavascriptExecutor) driver;
        executor4.executeScript("arguments[0].click();", inputElement1);

        // También intenta hacer clic directamente por Selenium (respaldo)
        inputElement1.click();
    }

    @Y("doy clic al boton de pagar el total")
    public void doyClicAlBotonDePagarElTotal() throws InterruptedException {
        // Espera explícita para garantizar que el botón esté listo
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement inputElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'exito-checkout-io-0-x-paymentButton')]")));

        // Scroll hacia el botón
        JavascriptExecutor executorScroll = (JavascriptExecutor) driver;
        executorScroll.executeScript("arguments[0].scrollIntoView(true);", inputElement2);
        Thread.sleep(1000);

        // Clic con JavaScript si es necesario
        JavascriptExecutor executorClick = (JavascriptExecutor) driver;
        executorClick.executeScript("arguments[0].click();", inputElement2);

        // Intenta también con Selenium (en caso de que funcione directamente)
        inputElement2.click();
    }

    @Y("ingresar correo electronico y dar clic en confirmar")
    public void ingresarCorreoElectronicoYDarClicEnConfirmar() throws InterruptedException {
        // Espera hasta que el campo de correo electrónico esté visible y habilitado
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement entradaElemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='render-store.custom.checkout-io']//input[@type='email']")));

        // Haz clic en el elemento con JavaScript
        JavascriptExecutor executor5 = (JavascriptExecutor) driver;
        executor5.executeScript("arguments[0].click();", entradaElemento);

        // Ingresa el valor "sebas@gmail.com" en el campo
        entradaElemento.sendKeys("sebas@gmail.com");
        Thread.sleep(20000);

        // Espera hasta que el botón "Confirmar" esté visible y habilitado
        WebElement confirmarBoton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='render-store.custom.checkout-io']//form//button[@type='submit' and contains(@class, 'exito-checkout-io-0-x-preLoginActiveButton')]")));

        // Haz clic en el botón "Confirmar" con JavaScript
        executor5.executeScript("arguments[0].click();", confirmarBoton);

        // También intenta hacer clic directamente por Selenium (respaldo)
        confirmarBoton.click();
    }

    @Y("llenamos el formulario de ingresa tus datos")
    public void llenamosElFormularioDeIngresaTusDatos() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentar el tiempo de espera a 20 segundos

        // Ingresar el primer nombre
        WebElement firstNameElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameElement);
        Thread.sleep(6000); // Espera fija de 1 segundo
        firstNameElement.click();
        firstNameElement.sendKeys("TuNombre");

        // Ingresar el apellido
        WebElement lastNameElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("lastName")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastNameElement);
        Thread.sleep(1000); // Espera fija de 1 segundo
        lastNameElement.click();
        lastNameElement.sendKeys("TuApellido");

        // Seleccionar el tipo de documento
        WebElement documentTypeSelect = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#render-store\\.custom\\.checkout-io .exito-checkout-io-0-x-profileDocumentTypeSelect")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", documentTypeSelect);
        Thread.sleep(1000); // Espera fija de 1 segundo
        documentTypeSelect.click();

        // Seleccionar "Cédula extranjería"
        WebElement documentTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#render-store\\.custom\\.checkout-io .exito-checkout-io-0-x-profileInputSelectContainer ul > li:nth-child(2)")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", documentTypeOption);
        Thread.sleep(1000); // Espera fija de 1 segundo
        documentTypeOption.click();

        // Ingresar el número de documento
        WebElement documentElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("document")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", documentElement);
        Thread.sleep(1000); // Espera fija de 1 segundo
        documentElement.click();
        documentElement.sendKeys("123456789");

        // Ingresar el número de teléfono
        WebElement phoneElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("phone")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneElement);
        Thread.sleep(1000); // Espera fija de 1 segundo
        phoneElement.click();
        phoneElement.sendKeys("987654321");

        // Hacer clic en el primer checkbox
        WebElement checkbox1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#render-store\\.custom\\.checkout-io .exito-checkout-io-0-x-privacyPolicyAndTermsContainer .exito-checkout-io-0-x-termsContainer.exito-checkout-io-0-x-checked")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox1);
        Thread.sleep(1000); // Espera fija de 1 segundo
        checkbox1.click();

        // Hacer clic en el segundo checkbox
        WebElement checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#render-store\\.custom\\.checkout-io .exito-checkout-io-0-x-privacyPolicyAndTermsContainer article:nth-child(2) label div input[type='checkbox']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox2);
        Thread.sleep(1000); // Espera fija de 1 segundo
        checkbox2.click();
    }
}


//WebElement button = driver.findElement(By.xpath(""));
// int numClicks = 5;
//Thread.sleep(100);
//for (int i = 0; i < numClicks; i++) {
//    button.click();
//    Thread.sleep(500); // Espera 500 milisegundos (0.5 segundos)








