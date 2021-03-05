package webElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeElements {
    WebDriver driver;



    @FindBy(id = "tab-flight-tab-hp")
    public WebElement flightButton;

    @FindBy(id = "flight-origin-hp-flight")
    public WebElement txbFrom;

    @FindBy(id = "flight-destination-hp-flight")
    public WebElement txbTo;

    @FindBy(id = "flight-departing-hp-flight")
    public WebElement dateStart;

    @FindBy(id = "flight-returning-hp-flight")
    public WebElement dateEnd;

    @FindBy(id = "traveler-selector-hp-flight")
    public static WebElement btnTravelers;

    @FindBy(xpath = "(//*[@data-gcw-component='gcw-step-input'])[1]//div[@class='uitk-col all-col-shrink'][2]")
    public WebElement plusAdults;

    @FindBy(xpath = "(//span[contains(text(), 'Search')])[1]")
    public WebElement btnSearch;

    public HomeElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnTravelers(){
        btnTravelers.click();
    }
}
