package hooks;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import params.GlobalParams;
import utils.WebActions;

import java.nio.file.Paths;

public class Hooks {
    public DriverFactory driverFactory;
    public Page page;

    @Before
    public void launchBrowser() {
        String browserName = GlobalParams.getBrowserName();
        System.out.println(browserName);
        String env = GlobalParams.getEnvironmentName();
        System.out.println(env);
        driverFactory = new DriverFactory();
        page = driverFactory.initDriver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        page.close();
    }

    @After(order = 1)
    public void takeScreenshotAndTrace(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll("", "_"); //Replace all space in scenario name with underscore
            byte[] sourcePath = page.screenshot();
            scenario.attach(sourcePath, "image/png", screenshotName);  //Attach screenshot to report if scenario fails
            DriverFactory.getContext().tracing().stop(new Tracing.StopOptions().setPath(Paths.get("target/" + screenshotName + ".zip")));
        }
    }

}