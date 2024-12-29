package actions;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static VarStatic.VarStatic.*;

public class CambioVentana {

/*
    public CambioVentana(WebDriver driver){
        this.driver = driver;
        ventanaPrincipal = driver.getWindowHandle(); // Inicialización fuera de los métodos
    }
*/
     public static String ventanaPrincipal = driver.getWindowHandle(); // Inicialización fuera de los métodos

    public static void cambiarVentana(){
        Set<String> ventanas = driver.getWindowHandles();
        for(String ventana : ventanas) {
            if(!ventana.equals(driver.getWindowHandle())) {
                driver.switchTo().window(ventana);
                ultimaVentana = ventana; // Actualiza la última ventana
                break;
            }
        }
    }

    public static void volverVentanaPrincipal(){
        if (!ultimaVentana.isEmpty()) {
            driver.switchTo().window(ultimaVentana); // Cambia a la última ventana
            driver.close(); // Cierra la última ventana
        }
        driver.switchTo().window(ventanaPrincipal); // Cambia a la ventana principal
    }
}
