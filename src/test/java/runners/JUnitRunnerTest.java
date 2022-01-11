/*
package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html", "summary"},
        dryRun = false,
        monochrome = true,
        tags = "@Smoke or @Regression",
        glue = {"stepDefinitions", "hooks", "types"},
        features = "src/test/resources/features"

)
public class JUnitRunnerTest {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("\nIN BEFORE CLASS\n");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("\nIN AFTER CLASS\n");
    }
}
*/