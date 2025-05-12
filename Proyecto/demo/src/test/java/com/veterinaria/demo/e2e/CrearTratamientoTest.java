package com.veterinaria.demo.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

// import org.junit.jupiter.api.AfterEach;
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
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        // options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* Caso de prueba 2 */
    @Test
    public void systemTest_CrearTratamiento_MostrarTratamiento() {
        // Paso 1: Configuración inicial del navegador
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        // Paso 2: Login (vet1/pass1)
        WebElement botonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-btn")));
        botonLogin.click();

        WebElement campoUsuario = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        campoUsuario.clear();
        campoUsuario.sendKeys("vet1");

        WebElement campoContrasena = driver.findElement(By.id("password"));
        campoContrasena.clear();
        campoContrasena.sendKeys("pass1");

        WebElement botonEnviarLogin = driver.findElement(By.id("loginSubmit"));
        botonEnviarLogin.click();

        // Paso 3: Navegación a sección de historial
        WebElement enlaceHistorial = wait.until(ExpectedConditions.elementToBeClickable(By.className("historial-link")));
        enlaceHistorial.click();

        // Paso 4: Creación de tratamiento
        WebElement botonAgregarTratamiento = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-agregar")));
        botonAgregarTratamiento.click();

        // Paso 5: Rellenar formulario de tratamiento
        WebElement campoCodigo = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("codigo")));
        campoCodigo.clear();
        campoCodigo.sendKeys("TRAT-001");

        WebElement selectServicio = driver.findElement(By.id("idServicio"));
        Select servicioSelect = new Select(selectServicio);
        servicioSelect.selectByVisibleText("Cirugía");

        WebElement selectMascota = driver.findElement(By.id("idMascota"));
        Select mascotaSelect = new Select(selectMascota);
        mascotaSelect.selectByVisibleText("Firulais - Carlos Gómez");

        WebElement campoDetalles = driver.findElement(By.id("detalles"));
        campoDetalles.clear();
        campoDetalles.sendKeys("Tratamiento postoperatorio para recuperación completa");

        WebElement selectMedicamento = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select-medicamento")));
        Select medicamentoSelect = new Select(selectMedicamento);
        medicamentoSelect.selectByVisibleText("Advantix");

        WebElement campoDosis = driver.findElement(By.className("input-dosis"));
        campoDosis.clear();
        campoDosis.sendKeys("5");

        WebElement botonGuardar = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-guardar")));
        try {
            botonGuardar.click();
        } catch (Exception e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", botonGuardar);
        }

        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert-success")));
        assertTrue(successMessage.isDisplayed(), "El mensaje de éxito debería estar visible");
    }

    /* Este se debe fusionar con el anterior, de forma que dos pestañas se abran a la vez y se vaya alternando entre ellas. Primero se muestra la de admin y se obtiene la cantidad inicial de medicamentos suministrados y ganancias. Luego, se muestra la de veterinario, se crea un tratamiento y se verifica su creación. Luego, se muestra la de admin y se recarga la pestaña para verificar el cambio en medicamentos suministrados y ganancias */
    @Test
    public void testDashboardAfterNewTreatment() {
        // Paso 1: Configuración inicial del navegador
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        // Paso 2: Login (admin/1234)
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

        // Paso 3: Obtener valores iniciales del dashboard
        WebElement tratamientosInicialesElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tratamientos-mes")));
        int tratamientosIniciales = Integer.parseInt(tratamientosInicialesElement.getText());

        // Obtener cantidad inicial de Advantix
        int advantixInicial = 0;
        List<WebElement> medicamentosRows = driver.findElements(By.className("medicamento-row"));
        for (WebElement row : medicamentosRows) {
            WebElement nombre = row.findElement(By.className("medicamento-nombre"));
            if (nombre.getText().equals("Advantix")) {
                WebElement cantidad = row.findElement(By.className("medicamento-cantidad"));
                advantixInicial = Integer.parseInt(cantidad.getText());
                break;
            }
        }

        WebElement ventasInicialesElement = driver.findElement(By.id("ventas-totales"));
        BigDecimal ventasIniciales = new BigDecimal(ventasInicialesElement.getText().replace("$", "").replace(",", ""));

        WebElement gananciasInicialesElement = driver.findElement(By.id("ganancias-totales"));
        BigDecimal gananciasIniciales = new BigDecimal(gananciasInicialesElement.getText().replace("$", "").replace(",", ""));

        // Paso 4: Obtener datos iniciales de otras secciones
        // Ir a tratamientos y contar elementos
        WebElement enlaceTratamientos = wait.until(ExpectedConditions.elementToBeClickable(By.className("tratamientos-link")));
        enlaceTratamientos.click();
        
        List<WebElement> filasTratamientosIniciales = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("tratamiento-fila")));
        int cantidadTratamientosInicial = filasTratamientosIniciales.size();
        
        // Ir a medicamentos y buscar Advantix
        WebElement enlaceMedicamentos = wait.until(ExpectedConditions.elementToBeClickable(By.className("medicamentos-link")));
        enlaceMedicamentos.click();
        
        WebElement campoBusqueda = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-busqueda-medicamento")));
        campoBusqueda.clear();
        campoBusqueda.sendKeys("Advantix");
        
        WebElement botonBuscar = driver.findElement(By.className("btn-buscar"));
        botonBuscar.click();
        
        // Obtener datos del medicamento
        WebElement filaMedicamento = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("medicamento-fila")));
        
        WebElement precioVentaElement = filaMedicamento.findElement(By.className("medicamento-precio-venta"));
        BigDecimal precioAdvantix = new BigDecimal(precioVentaElement.getText().replace("$", "").replace(",", ""));
        
        WebElement disponiblesElement = filaMedicamento.findElement(By.className("medicamento-disponibles"));
        int disponiblesAdvantix = Integer.parseInt(disponiblesElement.getText());
        
        WebElement vendidosElement = filaMedicamento.findElement(By.className("medicamento-vendidos"));
        int vendidosAdvantix = Integer.parseInt(vendidosElement.getText());
        
        // Ir a servicios y obtener precio de Cirugía
        WebElement enlaceServicios = wait.until(ExpectedConditions.elementToBeClickable(By.className("servicios-link")));
        enlaceServicios.click();
        
        List<WebElement> filasServicios = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("servicio-fila")));
        BigDecimal precioCirugia = BigDecimal.ZERO;
        
        for (WebElement fila : filasServicios) {
            WebElement nombreServicio = fila.findElement(By.className("servicio-nombre"));
            if (nombreServicio.getText().equals("Cirugía")) {
                WebElement precioElement = fila.findElement(By.className("servicio-precio"));
                precioCirugia = new BigDecimal(precioElement.getText().replace("$", "").replace(",", ""));
                break;
            }
        }
        
        // Volver al dashboard
        WebElement enlaceDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.className("admin-link")));
        enlaceDashboard.click();

        // Paso 5: Calcular valores esperados después del nuevo tratamiento
        int tratamientosEsperados = tratamientosIniciales + 1;
        int advantixEsperado = advantixInicial + 2; // Se añadieron 2 unidades en el test anterior
        int tratamientosListaEsperados = cantidadTratamientosInicial + 1;
        int advantixVendidosEsperado = vendidosAdvantix + 2;
        int advantixDisponiblesEsperado = disponiblesAdvantix - 2;
        
        BigDecimal ventasEsperadas = ventasIniciales.add(precioAdvantix.multiply(new BigDecimal(2)));
        BigDecimal gananciasEsperadas = gananciasIniciales.add(precioAdvantix.multiply(new BigDecimal(2))).add(precioCirugia);

        // Paso 6: Realizar el nuevo tratamiento (usando el test anterior)
        // ... (aquí iría el código del test anterior que crea el tratamiento)

        // Paso 7: Recargar dashboard y verificar valores
        driver.navigate().refresh();
        
        WebElement tratamientosActualesElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tratamientos-mes")));
        int tratamientosActuales = Integer.parseInt(tratamientosActualesElement.getText());
        assertEquals(tratamientosEsperados, tratamientosActuales, "La cantidad de tratamientos no coincide");

        // Verificar Advantix en dashboard
        int advantixActual = 0;
        medicamentosRows = driver.findElements(By.className("medicamento-row"));
        for (WebElement row : medicamentosRows) {
            WebElement nombre = row.findElement(By.className("medicamento-nombre"));
            if (nombre.getText().equals("Advantix")) {
                WebElement cantidad = row.findElement(By.className("medicamento-cantidad"));
                advantixActual = Integer.parseInt(cantidad.getText());
                break;
            }
        }
        assertEquals(advantixEsperado, advantixActual, "Las unidades de Advantix no coinciden");

        // Verificar ventas y ganancias
        WebElement ventasActualesElement = driver.findElement(By.id("ventas-totales"));
        BigDecimal ventasActuales = new BigDecimal(ventasActualesElement.getText().replace("$", "").replace(",", ""));
        assertEquals(ventasEsperadas, ventasActuales, "Las ventas totales no coinciden");

        WebElement gananciasActualesElement = driver.findElement(By.id("ganancias-totales"));
        BigDecimal gananciasActuales = new BigDecimal(gananciasActualesElement.getText().replace("$", "").replace(",", ""));
        assertEquals(gananciasEsperadas, gananciasActuales, "Las ganancias totales no coinciden");

        // Paso 8: Verificar cambios en otras secciones
        // Verificar tratamientos
        enlaceTratamientos = wait.until(ExpectedConditions.elementToBeClickable(By.className("tratamientos-link")));
        enlaceTratamientos.click();
        
        List<WebElement> filasTratamientosActuales = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("tratamiento-fila")));
        assertEquals(tratamientosListaEsperados, filasTratamientosActuales.size(), "La cantidad de tratamientos en la lista no coincide");

        // Verificar medicamentos
        enlaceMedicamentos = wait.until(ExpectedConditions.elementToBeClickable(By.className("medicamentos-link")));
        enlaceMedicamentos.click();
        
        campoBusqueda = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-busqueda-medicamento")));
        campoBusqueda.clear();
        campoBusqueda.sendKeys("Advantix");
        
        botonBuscar = driver.findElement(By.className("btn-buscar"));
        botonBuscar.click();
        
        filaMedicamento = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("medicamento-fila")));
        
        vendidosElement = filaMedicamento.findElement(By.className("medicamento-vendidos"));
        int advantixVendidosActual = Integer.parseInt(vendidosElement.getText());
        assertEquals(advantixVendidosEsperado, advantixVendidosActual, "Las unidades vendidas de Advantix no coinciden");
        
        disponiblesElement = filaMedicamento.findElement(By.className("medicamento-disponibles"));
        int advantixDisponiblesActual = Integer.parseInt(disponiblesElement.getText());
        assertEquals(advantixDisponiblesEsperado, advantixDisponiblesActual, "Las unidades disponibles de Advantix no coinciden");
    }

    /* @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    } */
}