package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;

import static VarStatic.VarStatic.esperar;
import static VarStatic.VarStatic.resaltar;
import static VarStatic.VarStatic.accion;

public class ComboBox {
    public static void seleccionarPorValor(By locator, String valor) throws Exception {
        seleccionarOpcion(locator, valor, TipoSeleccion.VALOR);
    }

    public static void seleccionarPorTextoVisible(By locator, String textoVisible) throws Exception {
        seleccionarOpcion(locator, textoVisible, TipoSeleccion.TEXTO_VISIBLE);
    }

    public static void seleccionarOpcion(By locator, String opcion, TipoSeleccion tipo) throws Exception {
        try {
          //  WebElement elemento = esperar.presente(locator);
            String colorHabilitado = ConfigReader.obtenerHabilitacionColor();
            if (esperar.presente(locator)!= null) {
                accion.hacerScroll(esperar.presente(locator));
                if ("true".equalsIgnoreCase(colorHabilitado)) {
                    resaltar.resaltar(esperar.presente(locator));
                }
                Select select = new Select(esperar.presente(locator));
                switch (tipo) {
                    case VALOR:
                        select.selectByValue(opcion);
                        break;
                    case TEXTO_VISIBLE:
                        select.selectByVisibleText(opcion);
                        break;
                    case INDEX:
                        int index = Integer.parseInt(opcion);
                        select.selectByIndex(index);
                        break;
                }
            } else {
                throw new Exception("El elemento no se encontró o no es un select válido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public enum TipoSeleccion {
        VALOR, TEXTO_VISIBLE, INDEX
    }

}
