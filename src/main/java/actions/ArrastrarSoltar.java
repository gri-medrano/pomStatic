package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

import static VarStatic.VarStatic.*;

public class ArrastrarSoltar {

    public static void arrastrarYSoltar(By elementoOrigen, By elementoDestino) throws Exception {
        try {
            WebElement fuente = esperar.presente(elementoOrigen);
            WebElement destino = esperar.presente(elementoDestino);
            String colorHabilitado = ConfigReader.obtenerHabilitacionColor();
            if(fuente != null && destino !=null){
                accion.hacerScroll(fuente);
                if ("true".equalsIgnoreCase(colorHabilitado)) {
                    resaltar.resaltar(fuente);
                    resaltar.resaltar(destino);
                }
                accion.arrastrarSoltar(fuente,destino);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
