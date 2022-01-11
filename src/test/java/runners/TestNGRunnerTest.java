package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html", "summary"},
        snippets = CAMELCASE,
        dryRun = false,
        monochrome = true,
        tags = "@Regression",
        glue = {"stepDefinitions", "hooks", "types"},
        features = "src/test/resources/features"

)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
/*
    @BeforeClass
    public static void beforeClass(){
        System.out.println("\nIN BEFORE CLASS\n");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("\nIN AFTER CLASS\n");
    }
*/
}