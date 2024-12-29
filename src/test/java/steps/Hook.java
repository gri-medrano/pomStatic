package steps;

import factory.Session;
import factory.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;


import java.io.ByteArrayInputStream;

import static factory.WebDriverManager.driver;

public class Hook {

    @Before(order = 0)
    public synchronized void antes(Scenario scenario) {
        System.out.println("Inicio el driver");
        System.out.println(STR."Inicio scenario name   : \{scenario.getName()}");
        if (driver == null) {
            WebDriverManager.initializeDriver();
        }
    }

    @After(order = 0)
    public synchronized void despues(Scenario scenario) {
        System.out.println("--------------------------------------------------------------");
        System.out.println(STR."Final scenario name   : \{scenario.getName()}");
        System.out.println(STR."Final scenario state  : \{scenario.getStatus()}");
        System.out.println("--------------------------------------------------------------");

        try {
            Allure.addAttachment(
                    scenario.getName(),
                    new ByteArrayInputStream(((TakesScreenshot) Session.getInstance().getWebDriver()).getScreenshotAs(OutputType.BYTES))
            );
            WebDriverManager.closeDriver();
        } catch (Exception e) {
            WebDriverManager.closeDriver();
        }
    }
}