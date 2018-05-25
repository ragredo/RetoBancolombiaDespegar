package reto.bancolombia.pageobjects;
//Esta libreria contiene los métodos de los objetos de la pantalla de Resultados de la busquedad

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaResultado {

                WebDriver driver;

                public void ordenar() throws InterruptedException {
                               driver.findElement(By.xpath("//*[@id=\"eva-select-1\"]/option[2]")).click();
                               Thread.sleep(5000);
                }
///
                public PaginaResultado(WebDriver driver) {
                               this.driver = driver;
                }
}

