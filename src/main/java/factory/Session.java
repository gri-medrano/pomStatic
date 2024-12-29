package factory;

import org.openqa.selenium.WebDriver;

public class Session {
    private static Session instance;
    private static ThreadLocal<WebDriver> webDriverThreadLocal;
    private Session() {
        webDriverThreadLocal = new ThreadLocal<>();
    }

    public static Session getInstance(){
        if (instance == null){
            instance = new Session();
        }
        return instance;
    }

    public static WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }

    public static void setWebDriver(WebDriver webDriver){
        webDriverThreadLocal.set(webDriver);
    }

    public static void removeWebDriver(){
        webDriverThreadLocal.remove();
    }
}
