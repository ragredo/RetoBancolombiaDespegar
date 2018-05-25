package reto.bancolombia.definition;
//Esta libreria contiene los Definitions y Steps del Gherkin

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reto.bancolombia.pageobjects.PaginaBusqueda;
import reto.bancolombia.pageobjects.PaginaResultado;
import utilidades.Utilidades;

public class BusquedaDefinitions {
                WebDriver driver;
                PaginaBusqueda paginaBusqueda;
                PaginaResultado paginaResultado;
                Utilidades uti;
                

                @Before
                public void SetUp() {
                               System.setProperty("webdriver.chrome.driver", "D:\\SVE\\sve.bancolombia\\src\\test\\resources\\driver\\chromedriver.exe");
                               driver = new ChromeDriver();
                               driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                               paginaBusqueda = new PaginaBusqueda(driver);
                               paginaResultado = new PaginaResultado(driver);
                               uti = new Utilidades(driver);
                }

                @Given("el usuario esta en la pagina de Despegar")
                public void ingresoURL() {
                               driver.get("https://www.despegar.com.co/");
                               paginaBusqueda.btnCerrarVentana();
                               driver.manage().window().maximize();
                               System.out.println("el usuario esta en la pagina de Despegar");
                               
                }
                @And("el usuario esta en la opcion Paquetes")
                public void opcionPaquete() throws InterruptedException {
                               paginaBusqueda.btnPaquetes();
                               System.out.println("el usuario esta en la Opción Paquetes");
                }

                @When("el usuario ingresa la ciudad origen \"(.*)\"$")
                public void usuarioIngresaCiudadOrigen(String ciudadOrigen) throws InterruptedException {
                               paginaBusqueda.txtCiudadOrigen(ciudadOrigen);
                               System.out.println("el usuario ingresa la ciudad origen");
                }

                @And("el usuario ingresa la ciudad destino \"(.*)\"$")
                public void usuarioIngresaCiudadDestino(String ciudadDestino) throws InterruptedException {
                               paginaBusqueda.txtCiudadDestino(ciudadDestino);
                               System.out.println("el usuario ingresa la ciudad destino");
                }

                @And("el usuario ingresa fecha partida \"(.*)\"$")
                public void usuarioIngresaFechaPartida(String fechaPartida) throws InterruptedException {
                               paginaBusqueda.txtFechaPartida(fechaPartida);
                               System.out.println("el usuario ingresa fecha partida valida");
                }

                @And("el usuario ingresa fecha regreso \"(.*)\"$")
                public void usuarioIngresaFechaRegreso(String fechaRegreso) throws InterruptedException {
                               paginaBusqueda.txtFechaRegreso(fechaRegreso);
                               System.out.println("el usuario ingresa fecha regreso valida");
                }

                @And("el usuario presiona boton buscar")
                public void usuarioPresionaBotonBuscar() {
                               paginaBusqueda.btnBuscar();
                               System.out.println("el usuario presiona boton buscar");
                }

                @And("ordenar por menor precio")
                public void ordenar() throws InterruptedException {
                               paginaResultado.ordenar();
                               System.out.println("ordena");
                }

                @Then("guardar en archivo excel")
                public void guardarArchivoExcel() throws Exception {
                               uti.seleccionarResultados();
                               System.out.println("crear archivo y marca en verde el mas barato");
                }

                // Validaciones sobre las validaciones de los campos obligatorios
                @Then("muestra mensaje de validacion Ingresa un origen.")
                public void mensajeValidacionIngresaOrigen() throws InterruptedException {
                               Thread.sleep(3000);
                               String msgValidacion = paginaBusqueda.msgIngresaOrigen();
                               assertEquals("Ingresa un origen.", msgValidacion);
                               System.out.println("muestra mensaje de validacion Ingresa un origen.");
                }

                @Then("muestra mensaje de validacion El destino deben ser diferente al origen.")
                public void mensajeValidacionIngresaDestino() throws InterruptedException {
                               Thread.sleep(3000);
                               String msgValidacion = paginaBusqueda.msgIngresaDestino();
                               assertEquals("El destino debe ser diferente del origen.", msgValidacion);
                               System.out.println("muestra mensaje de validacion El destino deben ser diferente al origen.");
                }

                @Then("muestra mensaje de validacion Ingresa una fecha de partida.")
                public void mensajeIngresaFechaPartida() throws InterruptedException {
                               Thread.sleep(3000);
                               String msgValidacion = paginaBusqueda.msgIngresaFechaPartida();
                               assertEquals("Ingresa una fecha de partida.", msgValidacion);
                               System.out.println("muestra mensaje de validacion Ingresa una fecha de partida.");
                }

                @Then("muestra mensaje de validacion Ingresa una fecha de regreso.")
                public void mensajeIngresaFechaRegreso() throws InterruptedException {
                               Thread.sleep(3000);
                               String msgValidacion = paginaBusqueda.msgIngresaFechaRegreso();
                               assertEquals("Ingresa una fecha de regreso.", msgValidacion);
                               System.out.println("muestra mensaje de validacion Ingresa una fecha de regreso.");
                }

                @After
                public void tearDown() {
                               driver.quit();
                }
}
