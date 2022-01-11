package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.CheckPoint;

public class Hooks {
    private static final Logger log = LogManager.getLogger(Hooks.class.getName());
    private WebDriver driver;
    private final TestContext context;
    public Hooks(TestContext context){
        this.context = context;
    }

    @Before ("@UI")
    public void before(Scenario scenario){
        log.info("BEFORE: Thread ID :: " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    @After ("@UI")
    public void after(Scenario scenario){
        log.info("AFTER: Thread ID ::" + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
       driver.quit();
    }

    @BeforeMethod
    public void methodSetUp() {
        CheckPoint.clearHashMap();
    }
}
