package com.exito.qa.base.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class menuPage  {


    WebDriver driver;


//Locators de la Web
    By btn_menu = By.xpath("//*[@id=\"__next\"]/header/section/div/div[1]/button");

    By link_categoria = By.xpath("//*[@id=\"__next\"]/header/aside/ul/section[2]/div/li[7]");

    By link_subCategoria = By.xpath("//*[@id=\"column-2\"]/li[1]/ul/li[1]/a");

    By btn_paginación = By.xpath("//*[@id=\"__next\"]/main/section[4]/div/div[2]/div[2]/div[3]/section/div/ul/li[5]/button");

    By btn_agregarCompra = By.xpath("(//button[contains(@class, 'DefaultStyle_default__jW12W')])[1]");

    By btn_añadirMasProductoCarrito = By.xpath("((//button[contains(@class, 'QuantitySelectorDefault_plus__0gQDO')])[1]");

    By btn_Carrito = By.xpath("//*[@id=\"__next\"]/header/section/div/div[1]/div[2]/div[2]/button/span");





//Constructor
public menuPage(){
}


//Inicializar las paginas

public void menuPageClik(){
        driver.findElement(btn_menu).click();
}

public void link_categoriaPage(){
        driver.findElement(link_categoria).click();
}

public void link_subCategoriaPage(){
        driver.findElement(link_subCategoria).click();
}

public void btn_PaginacionPage(){
        driver.findElement(btn_paginación).click();
}

public void btn_agregarCompraPage(){
        driver.findElement(btn_agregarCompra).click();
}

public void btn_añadirMasProductoCarritoPage() throws InterruptedException {
        //driver.findElement(btn_añadirMasProductoCarrito);
    WebElement button = driver.findElement(btn_añadirMasProductoCarrito);

// Definir el número de veces que quieres hacer clic en el botón
    int numClicks = 5;

// Bucle que ejecuta el clic en el botón el número de veces definido
    for (int i = 0; i < numClicks; i++) {
        button.click();
        // Puedes agregar una pausa entre cada clic si es necesario
        Thread.sleep(400); // Espera 500 milisegundos (0.5 segundos)
    }

}

public void btn_CarritoPage(){
        driver.findElement(btn_Carrito);
}


}
