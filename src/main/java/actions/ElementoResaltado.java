package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

import static VarStatic.VarStatic.driver;

public class ElementoResaltado {
    public static void resaltar(WebElement elemento) {
        String colorElemento = ConfigReader.obtenerColorElemento();
        int tiempoElemento = ConfigReader.obtenerTiempoResaltadoElemento();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid " + colorElemento + "'", elemento);
        try {
            Thread.sleep(tiempoElemento);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].style.border=''", elemento);
    }

}
