package steps;

import config.DriverFactory;
import cucumber.api.java.en.*;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class HomeSteps extends DriverFactory {
    HomePage homePage = new HomePage(driver);

    @Given("User goes to the main page")
    public void goToMainPage(){
        homePage.goToExpedia();
    }

    @Then("User click on \"([^\"]*)\" button")
    public void clickOnButton(String button){
        homePage.clickOnButton(button);
        System.out.println("Clicked on flights");

    }

    @Then("continue testing")
    public void continueTesting(){


        homePage.startDate("03/28/2020");
        homePage.endDate("03/28/2020");
        homePage.clickOnTravelers();
        System.out.println("Clicked on travelers");
        homePage.oneMoreAdult(1);
        System.out.println("Clicked on adults");
        homePage.clickOnTravelers();
        homePage.enterFromText("MEX");
        homePage.enterToText("Cun");
        homePage.clickOnSearch();
    }

}
