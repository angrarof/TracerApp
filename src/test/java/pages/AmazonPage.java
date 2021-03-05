package pages;

import config.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.AmazonElements;

import java.util.List;

public class AmazonPage extends DriverFactory {
    AmazonElements amazonElements = new AmazonElements(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    public AmazonPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToMain(){
        driver.get("https://www.amazon.com.mx/");
    }

    public void enterText(String text) throws Throwable{
        amazonElements.getTbxSearch().sendKeys(text);
    }

    public void clickOnSearch(){
        amazonElements.getBtnSearch().submit();
    }

    public void waitForResults(){
        wait.until(ExpectedConditions.visibilityOf(amazonElements.getFirstElement()));
    }

    public void clickOnLastElement(){
        List<WebElement> results = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        WebElement ele = driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])["+results.size()+"]"));
        ele.click();
    }

}
