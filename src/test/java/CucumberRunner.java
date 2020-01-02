
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.DriverCreator;
import utilities.Driver_Factory;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        plugin = {"json:target/cucumber-report.json"},
        strict = true,
        monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
