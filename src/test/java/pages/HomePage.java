package pages;

import config.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.HomeElements;

import java.util.Set;

public class HomePage extends DriverFactory {
    HomeElements homeElements = new HomeElements(driver);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToExpedia(){
        driver.get("https://www.expedia.com/");
    }

    public void clickOnButton(String button){
        WebElement ele = null;
        switch (button){
            case "Flights":
                ele = homeElements.flightButton;
                break;
            case "Search":
                ele = homeElements.btnSearch;
        }
        WebElement btn = wait.until(ExpectedConditions.visibilityOf(ele));
        btn.click();
    }

    public void enterFromText(String from){

        homeElements.txbFrom.sendKeys(from);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homeElements.txbFrom.sendKeys(Keys.TAB);
    }

    public void enterToText(String to){

        homeElements.txbTo.sendKeys(to);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homeElements.txbTo.sendKeys(Keys.TAB);
    }

    public void oneMoreAdult(int number){
        for (int i = 1; i<number;i++){

            homeElements.plusAdults.click();
        }
    }

    public void clickOnSearch(){
        homeElements.btnSearch.submit();
    }

    public void clickOnTravelers(){
            homeElements.clickOnTravelers();


    }

    public void startDate(String date){
        homeElements.dateStart.sendKeys(date);
    }

    public void endDate(String date){
        homeElements.dateEnd.sendKeys(date);
    }

    public void switchToWindow(){
        String parentWindow = driver.getWindowHandle();
        Set<String> newWindowHandles = driver.getWindowHandles();
        for (String handle : newWindowHandles){
            if (!handle.equals(parentWindow)){
                System.out.println("Other window");
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Parent window");
    }
}
