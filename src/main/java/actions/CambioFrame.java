package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static VarStatic.VarStatic.driver;

public class CambioFrame {

    public static void cambiarAFramePorId(String id) {
        driver.switchTo().frame(id);
    }

    public static void cambiarAFramePorNombre(String nombre) {
        driver.switchTo().frame(nombre);
    }

    public static void cambiarAFramePorElemento(By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }

    public static void volverAlContenidoPrincipal() {
        driver.switchTo().defaultContent();
    }
}
