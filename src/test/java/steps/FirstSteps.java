package steps;

import config.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class FirstSteps extends DriverFactory {
    private WebDriver driver;

    @Before
    public void beforeScenario(){
        driver = new DriverFactory().getDriver();
    }

    @After
    public void afterScenario(){
        new DriverFactory().destroyDriver();
    }
}
