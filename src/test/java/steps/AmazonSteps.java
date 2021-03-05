package steps;

import config.DriverFactory;
import cucumber.api.java.en.*;
import pages.AmazonPage;

public class AmazonSteps extends DriverFactory {
    AmazonPage amazonPage = new AmazonPage(driver);

    @And("goes to amazon")
    public void goesToAmazon(){
        amazonPage.goToMain();
    }

    @Then("searches something")
    public void searchesSomething() throws Throwable{
        amazonPage.enterText("redmi note 8");
        amazonPage.clickOnSearch();
        amazonPage.waitForResults();
        amazonPage.clickOnLastElement();
    }

}
