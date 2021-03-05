package pages;

import config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.FlightsElements;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FlightsPage extends DriverFactory {
    FlightsElements flightsElements = new FlightsElements(driver);
    WebDriverWait wait = new WebDriverWait(driver,20);

    public FlightsPage(WebDriver driver){
        this.driver = driver;
    }

    public void sortDrop(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test-id='listing-main']")));
        Select sortBy = new Select(flightsElements.dpwPrices);
        sortBy.selectByVisibleText(text);

    }

    public void savePrices() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> prices = driver.findElements(By.xpath("//*[@data-test-id='listing-price-dollars']"));
        List<Integer> orderPrices = new ArrayList<>();
        String[][] data = null;
        for(WebElement price : prices){
            try {
                System.out.println(price.getText());
                orderPrices.add(Integer.parseInt(price.getText().replace("$","").replace(",","")));
            }catch (StaleElementReferenceException ex){

            }
        }
        System.out.println(orderPrices);
        Collections.sort(orderPrices);
        System.out.println(orderPrices);
        List<Integer> lowestToHighest = new ArrayList<>();
        for(int i = orderPrices.size()-1; i>=0; i--){
            lowestToHighest.add(orderPrices.get(i));
        }
        System.out.println(lowestToHighest);
    }
}
