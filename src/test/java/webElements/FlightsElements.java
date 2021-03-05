package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.FlightsPage;

public class FlightsElements {
    WebDriver driver;

    @FindBy(id = "sortDropdown")
    public WebElement dpwPrices;

    public FlightsElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
