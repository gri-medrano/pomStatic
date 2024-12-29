package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.logging.Level;

import static utils.ConfigReader.logger;

public class WebDriverManager {
    private static final String baseUrl;
    private static final int timeImplicit;
    private static final String navegador;

   public static WebDriver driver = Session.getInstance().getWebDriver();

    static {
        timeImplicit = ConfigReader.getTimeImplicit();
        baseUrl = ConfigReader.getBaseUrl();
        navegador = ConfigReader.getBrowser();
        System.out.println("Se cargo todas las configuraciones de configuration.properties:");
    }

    public static void initializeDriver() {
       // WebDriver driver = Session.getInstance().getWebDriver();
        if (driver == null && baseUrl != null) {
            switch (navegador.toUpperCase()) {
                case "CHROME":
                    CreatorChromeDriver driverChrome = new CreatorChromeDriver();
                    driver = driverChrome.createWebDriver();
                    break;
                case "FIREFOX":
                    CreatorFirefoxDriver driverFirefox = new CreatorFirefoxDriver();
                    driver = driverFirefox.createWebDriver();
                    break;
                case "EDGE":
                    CreatorEdgeDriver driverEdge = new CreatorEdgeDriver();
                    driver = driverEdge.createWebDriver();
                    break;
                default:
                    logger.log(Level.WARNING, "Navegador no válido. Se utilizará Chrome por defecto.");
                    driver = new ChromeDriver();
            }
            Session.getInstance().setWebDriver(driver);//setDriver guarda la instancia de WebDriver en el contexto actual de la session, para que en la ejecucion no se pierda el hilo
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeImplicit));
            driver.get(baseUrl);
        } else {
            logger.log(Level.SEVERE, "Base URL is null. WebDriver cannot be initialized.");
        }
    }

    public static WebDriver getDriver() {
        return Session.getInstance().getWebDriver();
    }

    public static void closeDriver(){
        if (Session.getInstance().getWebDriver() != null) {
            try {
                Session.getInstance().getWebDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Session.getInstance().removeWebDriver();
            }
        }
    }

}
