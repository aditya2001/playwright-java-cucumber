package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import params.GlobalParams;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser","env"})
    public void beforeRun(String browser, String env) throws Throwable {
                GlobalParams.setBrowserName(browser);
                GlobalParams.setEnvironmentName(env);
    }

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}