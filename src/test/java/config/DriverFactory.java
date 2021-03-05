package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    protected static WebDriver driver;

    public DriverFactory(){
        initialize();
    }

    public void initialize(){
        if(driver==null){
            createDriverInstance();
        }
    }

    public void createDriverInstance(){
        String projectLocation = System.getProperty("user.dir");
        String browser = new PropertiesFile().readBrowser();
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",projectLocation+"\\lib\\geckoDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",projectLocation+"\\lib\\chromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void destroyDriver(){
        driver.quit();
        driver = null;
    }
}
