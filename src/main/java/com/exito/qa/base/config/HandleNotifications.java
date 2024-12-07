package com.exito.qa.base.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class HandleNotifications {
    public static void main(String[] args) {
        // Configuración del WebDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        // Opciones de Chrome para manejar notificaciones
        ChromeOptions options = new ChromeOptions();

        // Permitir notificaciones
        options.addArguments("--disable-notifications");

        // Si prefieres bloquearlas
         Map<String, Object> prefs = new HashMap<>();
         prefs.put("profile.default_content_setting_values.notifications", 2); // 1: permitir, 2: bloquear
         options.setExperimentalOption("prefs", prefs);

        // Inicializar el navegador con las opciones configuradas
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navegar al sitio web
            driver.get("https://www.google.com");

            // Realiza las acciones necesarias
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            //driver.quit();
        }
    }
}
