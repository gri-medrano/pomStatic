package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static VarStatic.VarStatic.driver;


public class BuscarElemento {

    public static WebElement buscarElemento(By locator){
        try {
            return driver.findElement(locator);
        }catch (NoSuchElementException e){
          //  throw new ElementoNoEncontradoException("Elemento no encontrado: " + locator.toString(), e);
        }
        return null;
    }
}
