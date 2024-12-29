package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static VarStatic.VarStatic.*;

public class JavaScript {
    public static void scrollLocator(By locator){
        WebElement element = buscar.buscarElemento(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void click(WebElement elemento)  {
        try{
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void dobleClick(By locator)  {
        try {
            WebElement elemento = esperar.presente(locator);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("var evt = document.createEvent('MouseEvents');" +
                    "evt.initMouseEvent('dblclick',true,true,window,0,0,0,0,0,false,false,false,false,0,null);" +
                    "arguments[0].dispatchEvent(evt);", elemento);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void limpiar(WebElement elemento)  {
        try{
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", elemento);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void escribir(WebElement elemento,String texto)  {
        try{
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", elemento, texto);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
