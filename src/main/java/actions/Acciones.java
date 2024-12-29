package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static VarStatic.VarStatic.buscar;
import static VarStatic.VarStatic.driver;
import static VarStatic.VarStatic.actions;

public class Acciones {
    public static void Tab(){
        actions.keyDown(Keys.TAB).perform();
    }

    public static void hacerClick(By locator){
        scrollElemento(locator, actions).click().perform();
    }

    public static Actions scrollElemento(By locator, Actions actions){
        return actions.moveToElement(buscar.buscarElemento(locator));
    }

    public static void hacerScroll(By locator){
        actions.moveToElement(buscar.buscarElemento(locator)).perform();
    }

    public static void hacerScroll(WebElement elemento){
        actions.moveToElement(elemento).perform();
    }

    public static void hacerClickSecundario(By locator){
        actions.contextClick(buscar.buscarElemento(locator)).perform();
    }

    public static void clickEscribirFlechaAbajoEnter(By locator, String text){
        actions.click(buscar.buscarElemento(locator))
                .sendKeys(text)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }
    public static void flechaAbajoDoble(){
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public static void flechaAbajo(){
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public static void clickFlechaAbajoDoble(By locator){
        actions.click(buscar.buscarElemento(locator));
        scrollElemento(locator, actions).click()
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }
    //puede mejorarse
    public static void clickFlechaAbajo(By locator){
        actions.click(buscar.buscarElemento(locator))
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public static void hacerDobleClick(By locator){
        actions.doubleClick(buscar.buscarElemento(locator)).perform();
    }

    public static void arrastrarSoltar(By fuente, By destino){
        WebElement archivoFuente = buscar.buscarElemento(fuente);
        WebElement archivoDestino = buscar.buscarElemento(destino);
        actions.dragAndDrop(archivoFuente,archivoDestino).perform();
    }

    public static void arrastrarSoltar(WebElement fuente, WebElement destino){
        actions.dragAndDrop(fuente,destino).perform();
    }

    public static void control_A(By locator){
        actions.moveToElement(buscar.buscarElemento(locator))
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();
    }

    public static void realizarAccionConTeclas(By locator, Keys keyModifier, CharSequence keyToSend){
        WebElement elemento = buscar.buscarElemento(locator);
        actions.moveToElement(elemento);
        actions.keyDown(keyModifier);
        actions.sendKeys(keyToSend);
        actions.keyUp(keyModifier);
        actions.perform();
        //realizarAccionConTeclas(By.id("miElemento"), Keys.SHIFT, "t"); Ejemplo de como usarla
    }

    public static void borrarTexto(By locator){

        actions.moveToElement(buscar.buscarElemento(locator)).sendKeys(Keys.DELETE).perform();
    }

    public static void limpiarCampoyEscribir(By locator, String text) throws Exception {
        // Inicializa el WebDriver (asumiendo que Session es tu clase personalizada para gestionar sesiones)
        WebElement campo = driver.findElement(locator);

        Click mouse = new Click();

        // Clic en el elemento usando JavaScript
        mouse.ClickearJs(locator);
        // Borrar el contenido del campo de entrada usando JavaScript para asegurar que esté limpio
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", campo);
        // Verificar que el campo está vacío
        while (!campo.getAttribute("value").isEmpty()) {
            js.executeScript("arguments[0].value = '';", campo);
        }
        // Adicionalmente enviar combinación de teclas para asegurarse de borrar cualquier texto existente
        campo.sendKeys(Keys.CONTROL + "a");  // Seleccionar todo el texto (en Windows/Linux)
        borrarTexto(locator);

       //este no funciona--> campo.sendKeys(Keys.DELETE);  // Borrar el texto seleccionado
        // Enviar el nuevo texto
        campo.sendKeys(text);
        // Cerrar el navegador (si es necesario)
        // driver.quit();
    }

}


















