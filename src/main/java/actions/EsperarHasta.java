package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

import static VarStatic.VarStatic.driver;

public class EsperarHasta {


    public static WebElement presente(By locator) {
        WebElement elemento = null;
        Duration duracion = Duration.ofMillis(ConfigReader.obtenerTiempoExplicito());
        try {
            WebDriverWait esperar = new WebDriverWait(driver, duracion);
            esperar.until(ExpectedConditions.and(
                    ExpectedConditions.presenceOfElementLocated(locator),
                    ExpectedConditions.visibilityOfElementLocated(locator),
                    ExpectedConditions.elementToBeClickable(locator)));

            elemento = driver.findElement(locator);
        } catch (TimeoutException e) {
            System.out.println("Tiempo de espera agotado para el elemento con locator: " + locator.toString());
        }
        return elemento;
    }
}
