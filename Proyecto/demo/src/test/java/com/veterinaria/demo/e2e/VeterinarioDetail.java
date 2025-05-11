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
import org.openqa.selenium.support.ui.Select;
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
        driver.get(BASE_URL);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-btn")));
        loginButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        usernameField.clear();
        usernameField.sendKeys("vet2");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("pass1");

        WebElement submitButton = driver.findElement(By.id("loginSubmit"));
        submitButton.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));
        assertTrue(errorMessage.isDisplayed(), "El mensaje de error debería estar visible");
        assertEquals("Usuario o contraseña incorrectos.", errorMessage.getText(), "El mensaje de error no coincide");

        usernameField.clear();
        usernameField.sendKeys("vet1");

        passwordField.clear();
        passwordField.sendKeys("pass1");

        submitButton.click();

        WebElement clientesLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("clientes-link")));
        clientesLink.click();

        WebElement addClientButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-agregar")));
        addClientButton.click();

        WebElement nombreCliente = driver.findElement(By.id("nombre"));
        nombreCliente.clear();
        nombreCliente.sendKeys("Sebastián Angarita");

        WebElement correoCliente = driver.findElement(By.id("correo"));
        correoCliente.clear();
        correoCliente.sendKeys("angaritat.js@javeriana.edu.co");

        WebElement celularCliente = driver.findElement(By.id("celular"));
        celularCliente.clear();
        celularCliente.sendKeys("3194955734");

        WebElement cedulaCliente = driver.findElement(By.id("cedula"));
        cedulaCliente.clear();
        cedulaCliente.sendKeys("31415926335");

        WebElement nombreUsuarioCliente = driver.findElement(By.id("nombreUsuario"));
        nombreUsuarioCliente.clear();
        nombreUsuarioCliente.sendKeys("Ing. Angarita");

        WebElement fotoCliente = driver.findElement(By.id("foto"));
        fotoCliente.clear();
        fotoCliente.sendKeys("https://i.pinimg.com/236x/48/12/96/48129664d8dc5b068eb4d68a381c6c81.jpg");

        WebElement contrasenaCliente = driver.findElement(By.id("contrasena"));
        contrasenaCliente.clear();
        contrasenaCliente.sendKeys("1234");

        WebElement confirm_passwordCliente = driver.findElement(By.id("confirm_password"));
        confirm_passwordCliente.clear();
        confirm_passwordCliente.sendKeys("12345");

        WebElement boton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("crear_cliente")));
        try {
            boton.click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", boton);
        }

        confirm_passwordCliente.clear();
        confirm_passwordCliente.sendKeys("1234");

        WebElement newBoton = wait.until(ExpectedConditions.elementToBeClickable(By.className("crear_cliente")));
        try {
            newBoton.click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", boton);
        }
        
        WebElement mascotasLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("mascotas-link")));
        mascotasLink.click();

        WebElement addMascotaButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-agregar")));
        addMascotaButton.click();

        WebElement nombreMascota = driver.findElement(By.id("nombre"));
        nombreMascota.clear();
        nombreMascota.sendKeys("Scooby-Doo");

        WebElement razaMascota = driver.findElement(By.id("raza"));
        razaMascota.clear();
        razaMascota.sendKeys("Gran Danés Cobarde");

        WebElement edadMascota = driver.findElement(By.id("edad"));
        edadMascota.clear();
        edadMascota.sendKeys("53");

        WebElement pesoMascota = driver.findElement(By.id("peso"));
        pesoMascota.clear();
        pesoMascota.sendKeys("70.5");

        WebElement enfermedadMascota = driver.findElement(By.id("enfermedad"));
        enfermedadMascota.clear();
        enfermedadMascota.sendKeys("Miedo crónico a fantasmas");

        Select clienteSelect = new Select(driver.findElement(By.id("cliente")));
        clienteSelect.selectByVisibleText("Sebastián Angarita");

        WebElement fotoMascota = driver.findElement(By.id("foto"));
        fotoMascota.clear();
        fotoMascota.sendKeys("https://i.pinimg.com/1200x/ee/3c/16/ee3c16658a352467a8e727d300fe314f.jpg");

        WebElement fechaNacimientoMascota = driver.findElement(By.id("fechaNacimiento"));
        fechaNacimientoMascota.clear();
        fechaNacimientoMascota.sendKeys("09131969");

        WebElement fechaIngresoMascota = driver.findElement(By.id("fechaIngreso"));
        fechaIngresoMascota.clear();
        fechaIngresoMascota.sendKeys("06062025");

        WebElement fechaSalidaMascota = driver.findElement(By.id("fechaSalida"));
        fechaSalidaMascota.clear();
        fechaSalidaMascota.sendKeys("07072025");

        Select estadoSelect = new Select(driver.findElement(By.id("estado")));
        estadoSelect.selectByValue("1");

        WebElement boton2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("crear_mascota")));
        try {
            boton2.click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", boton);
        }

        WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(By.className("logout")));
        logOut.click();

        WebElement newLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-btn")));
        newLoginButton.click();

        WebElement newUsernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        newUsernameField.clear();
        newUsernameField.sendKeys("Ing. Angarita");

        WebElement newPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        newPasswordField.clear();
        newPasswordField.sendKeys("1234");

        WebElement newSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginSubmit")));
        newSubmitButton.click();
    }

    /* @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    } */
}