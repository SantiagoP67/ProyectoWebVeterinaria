package com.veterinaria.demo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class VeterinarioDetail {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "http://localhost:4200";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        // options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void SystemTest_TratamientoDetail_TratamientoName() {
        driver.manage().window().maximize();
        // 1. Navegar a la página principal
        driver.get(BASE_URL);

        // 2. Hacer click en el botón de login
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-btn")));
        loginButton.click();

        // --- PRIMER INTENTO FALLIDO ---
        // 3. Ingresar credenciales incorrectas (vet2)
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        usernameField.clear();
        usernameField.sendKeys("vet2");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("pass1");

        // 4. Hacer click en el botón de submit
        WebElement submitButton = driver.findElement(By.id("loginSubmit"));
        submitButton.click();

        // 5. Verificar que aparece el mensaje de error
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));
        assertTrue(errorMessage.isDisplayed(), "El mensaje de error debería estar visible");
        assertEquals("Usuario o contraseña incorrectos.", errorMessage.getText(), "El mensaje de error no coincide");

        // --- SEGUNDO INTENTO EXITOSO ---
        // 6. Ingresar credenciales correctas (vet1)
        usernameField.clear();
        usernameField.sendKeys("vet1");

        passwordField.clear();
        passwordField.sendKeys("pass1");

        // 7. Hacer click en el botón de submit nuevamente
        submitButton.click();

        WebElement clientesLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("clientes-link")));
        clientesLink.click();

        // 10. Añadir nuevo cliente
        WebElement addClientButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-agregar")));
        addClientButton.click();

        WebElement nombre = driver.findElement(By.id("nombre"));
        nombre.sendKeys("Sebastián Angarita");

        WebElement correo = driver.findElement(By.id("correo"));
        correo.sendKeys("angaritat.js@javeriana.edu.co");

        WebElement celular = driver.findElement(By.id("celular"));
        celular.sendKeys("319495573");

        //cedula, nombreUsuario, foto, contrasena, confirm_password
        WebElement cedula = driver.findElement(By.id("cedula"));
        cedula.sendKeys("123456789");

        WebElement nombreUsuario = driver.findElement(By.id("nombreUsuario"));
        nombreUsuario.sendKeys("Ing. Angarita");

        WebElement foto = driver.findElement(By.id("foto"));
        foto.sendKeys("https://www.clarin.com/2023/12/28/k8gOUmfp5_720x0__1.jpg");

        WebElement contrasena = driver.findElement(By.id("contrasena"));
        contrasena.sendKeys("BeagleGiggle#1");

        WebElement confirm_password = driver.findElement(By.id("confirm_password"));
        confirm_password.sendKeys("BeagleGiggle#2");

        WebElement boton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("crear_cliente")));
        try {
            boton.click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", boton);
        }

        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alertWait.until(ExpectedConditions.alertIsPresent());
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Las contraseñas no coinciden", alertText, "El mensaje de alerta no coincide");
        alert.accept();

        confirm_password.clear();
        confirm_password.sendKeys("BeagleGiggle#1");

        boton = wait.until(ExpectedConditions.elementToBeClickable(By.className("crear_cliente")));
        try {
            boton.click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", boton);
        }
        
        wait.until(ExpectedConditions.urlContains("/clientes"));
    }

    /* @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    } */
}