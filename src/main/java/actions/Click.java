package actions;

import factory.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

import java.util.List;

import static VarStatic.VarStatic.*;

public class Click {
    public static void ClickearJs(By locator) throws Exception {
        clickearElemento(locator, true);
    }

    public static void Clickear(By locator) throws Exception {
        clickearElemento(locator, false);
    }

    public static void hacerClickEnElementos(By locator) {
        try {
            List<WebElement> elementos = Session.getInstance().getWebDriver().findElements(locator);
            if (elementos != null && !elementos.isEmpty()) {
                for (WebElement elemento : elementos) {
                    accion.hacerScroll(elemento);
                    elemento.click();
                }
            } else {
                System.out.println("La lista de elementos está vacía o es nula.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void clickearElemento(By locator, boolean usarJs) throws Exception {
        try {
            WebElement elemento = esperar.presente(locator);
            String colorEnabled = ConfigReader.obtenerHabilitacionColor();
            if (elemento != null) {
                javaScript.scrollLocator(locator);
                if ("true".equalsIgnoreCase(colorEnabled)) {
                    resaltar.resaltar(elemento);
                }
                if (usarJs) {
                    javaScript.click(elemento);
                } else {
                    elemento.click();
                }
            } else {
                throw new Exception("El elemento no se encontró o no es clickeable.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
