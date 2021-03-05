package webElements;

import com.google.gson.internal.$Gson$Types;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class AmazonElements {
    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement tbxSearch;

    @FindBy(xpath = "//*[@id='nav-search-submit-text']")
    private WebElement btnSearch;

    @FindBy(xpath = "(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")
    private WebElement firstElement;
    
    public AmazonElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
