package steps;

import config.DriverFactory;
import cucumber.api.java.en.And;
import pages.FlightsPage;
import pages.HomePage;

public class FlightsSteps extends DriverFactory {
    FlightsPage flightsPage = new FlightsPage(driver);
    HomePage homePage = new HomePage(driver);

    @And("User goes to flights page")
    public void goesToFlightPage() throws InterruptedException {
        homePage.switchToWindow();
        flightsPage.sortDrop("Price (Highest)");
        flightsPage.savePrices();
    }
}
