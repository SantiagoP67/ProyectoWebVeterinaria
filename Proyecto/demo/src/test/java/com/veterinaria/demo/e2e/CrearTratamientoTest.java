package com.veterinaria.demo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
public class CrearTratamientoTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "http://localhost:4200";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Evitar notificaciones emergentes
        options.addArguments("--disable-extensions"); // Deshabilitar extensiones del navegador
        // options.addArguments("--headless"); // Modo headless para pruebas sin UI
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Caso de prueba para crear un tratamiento y verificar su correcto registro y actualización
     * en el sistema, incluyendo cambios en inventario, ventas y ganancias.
     */
    @Test
    public void SystemTest_CrearTratamiento_MostrarTratamiento() {
        // Maximizar ventana y abrir URL principal
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        // Abrir una nueva pestaña para sesiones paralelas (Admin y Veterinario)
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // --- PESTAÑA 1: ADMINISTRADOR ---
        driver.switchTo().window(tabs.get(0));
        driver.get(BASE_URL);

        // Iniciar sesión como admin
        WebElement botonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-btn")));
        botonLogin.click();

        WebElement campoUsuario = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        campoUsuario.clear();
        campoUsuario.sendKeys("admin");

        WebElement campoContrasena = driver.findElement(By.id("password"));
        campoContrasena.clear();
        campoContrasena.sendKeys("1234");

        WebElement botonEnviarLogin = driver.findElement(By.id("loginSubmit"));
        botonEnviarLogin.click();

        // Esperar a que las métricas principales se carguen y no sean cero
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.id("tratamientos-mes"), "0")));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.id("ventas-totales"), "0")));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.id("ganancias-totales"), "0")));

        // Guardar métricas iniciales
        int tratamientosIniciales = Integer.parseInt(driver.findElement(By.id("tratamientos-mes")).getText());
        BigDecimal ventasIniciales = parseCurrency(driver.findElement(By.id("ventas-totales")).getText());
        BigDecimal gananciasIniciales = parseCurrency(driver.findElement(By.id("ganancias-totales")).getText());

        // Navegar a sección de medicamentos para obtener datos de Advantix
        driver.findElement(By.className("medicamentos-link")).click();

        WebElement campoBusqueda = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-busqueda-medicamento")));
        campoBusqueda.clear();
        campoBusqueda.sendKeys("Advantix");

        driver.findElement(By.className("btn-buscar")).click();

        WebElement filaMedicamento = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("medicamento-fila")));
        int advantixDisponiblesInicial = Integer.parseInt(filaMedicamento.findElement(By.className("medicamento-disponibles")).getText());
        int advantixVendidosInicial = Integer.parseInt(filaMedicamento.findElement(By.className("medicamento-vendidos")).getText());
        BigDecimal precioAdvantix = parseCurrency(filaMedicamento.findElement(By.className("medicamento-precio-venta")).getText());
        BigDecimal precioCompraAdvantix = parseCurrency(filaMedicamento.findElement(By.className("medicamento-precio-compra")).getText());

        // Navegar a servicios para obtener precio de cirugía
        driver.findElement(By.className("servicios-link")).click();
        List<WebElement> filasServicios = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("servicio-fila")));
        BigDecimal precioCirugia = BigDecimal.ZERO;
        for (WebElement fila : filasServicios) {
            if (fila.findElement(By.className("servicio-nombre")).getText().equals("Cirugía")) {
                precioCirugia = parseCurrency(fila.findElement(By.className("servicio-precio")).getText());
                break;
            }
        }

        // Volver al dashboard
        driver.findElement(By.className("admin-link")).click();

        // --- PESTAÑA 2: VETERINARIO ---
        driver.switchTo().window(tabs.get(1));
        driver.get(BASE_URL);

        // Iniciar sesión como veterinario
        botonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-btn")));
        botonLogin.click();

        campoUsuario = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        campoUsuario.clear();
        campoUsuario.sendKeys("vet1");

        campoContrasena = driver.findElement(By.id("password"));
        campoContrasena.clear();
        campoContrasena.sendKeys("pass1");

        botonEnviarLogin = driver.findElement(By.id("loginSubmit"));
        botonEnviarLogin.click();

        // Navegar a la sección de tratamientos
        wait.until(ExpectedConditions.elementToBeClickable(By.className("historial-link"))).click();

        // Crear nuevo tratamiento
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-agregar"))).click();

        // Completar formulario de tratamiento
        WebElement campoCodigo = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("codigo")));
        campoCodigo.clear();
        String codigoAleatorio = "TRAT" + (int)(Math.random() * 10000);
        campoCodigo.sendKeys(codigoAleatorio);

        Select servicioSelect = new Select(driver.findElement(By.id("idServicio")));
        servicioSelect.selectByVisibleText("Cirugía");

        Select mascotaSelect = new Select(driver.findElement(By.id("idMascota")));
        mascotaSelect.selectByVisibleText("Firulais - Carlos Gómez");

        WebElement campoDetalles = driver.findElement(By.id("detalles"));
        campoDetalles.clear();
        campoDetalles.sendKeys("Tratamiento postoperatorio para recuperación completa");

        Select medicamentoSelect = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select-medicamento"))));
        medicamentoSelect.selectByVisibleText("Advantix");

        WebElement campoDosis = driver.findElement(By.className("input-dosis"));
        campoDosis.clear();
        campoDosis.sendKeys("2");

        // Guardar tratamiento, con click forzado si es necesario
        WebElement botonGuardar = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-guardar")));
        try {
            botonGuardar.click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", botonGuardar);
        }

        // --- VERIFICACIÓN: Confirmar que el tratamiento fue creado correctamente ---

        // Buscar tratamiento en la tabla de tratamientos
        WebElement tablaTratamientos = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tabla-tratamientos")));
        List<WebElement> filasTratamientos = tablaTratamientos.findElements(By.tagName("tr"));

        WebElement tratamientoCreado = null;
        for (WebElement fila : filasTratamientos) {
        List<WebElement> celdas = fila.findElements(By.tagName("td"));
        if (!celdas.isEmpty() && celdas.get(0).getText().equals(codigoAleatorio)) {
            tratamientoCreado = fila;
            break;
        }
    }

    // --- PESTAÑA 1: ADMINISTRADOR (revisar métricas actualizadas) ---
    driver.switchTo().window(tabs.get(0));
    driver.navigate().refresh();

    // Verificar incremento en tratamientos
    int tratamientosFinales = Integer.parseInt(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tratamientos-mes"))).getText());
    assertEquals(tratamientosIniciales + 1, tratamientosFinales, "No se incrementó el número de tratamientos");

    // Verificar ventas totales incrementadas
    BigDecimal ventasFinales = parseCurrency(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ventas-totales"))).getText());
    assertTrue(ventasFinales.compareTo(ventasIniciales) > 0, "Las ventas totales no aumentaron");

    // Verificar ganancias totales incrementadas
    BigDecimal gananciasFinales = parseCurrency(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ganancias-totales"))).getText());
    assertTrue(gananciasFinales.compareTo(gananciasIniciales) > 0, "Las ganancias totales no aumentaron");

    // Volver a medicamentos y verificar inventario actualizado de Advantix
    driver.findElement(By.className("medicamentos-link")).click();

    campoBusqueda = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-busqueda-medicamento")));
    campoBusqueda.clear();
    campoBusqueda.sendKeys("Advantix");

    driver.findElement(By.className("btn-buscar")).click();

    filaMedicamento = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("medicamento-fila")));
    int advantixDisponiblesFinal = Integer.parseInt(filaMedicamento.findElement(By.className("medicamento-disponibles")).getText());
    int advantixVendidosFinal = Integer.parseInt(filaMedicamento.findElement(By.className("medicamento-vendidos")).getText());

    assertEquals(advantixDisponiblesInicial - 2, advantixDisponiblesFinal, "El inventario disponible no se actualizó correctamente");
    assertEquals(advantixVendidosInicial + 2, advantixVendidosFinal, "El número de medicamentos vendidos no se actualizó correctamente");

    // Cerrar driver
    driver.quit();
}

/**
 * Convierte una cadena de texto con formato monetario a BigDecimal
 * Ejemplo: "$1,234.56" -> 1234.56
 */
private BigDecimal parseCurrency(String text) {
    // Quitar símbolos de moneda y comas, espacios, y convertir a BigDecimal
    String clean = text.replaceAll("[^\\d.,-]", "").replace(",", "");
    return new BigDecimal(clean);
}
}