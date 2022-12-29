package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FirefoxPage;

public class FirefoxSteps {

    FirefoxPage duckDuckGo = new FirefoxPage();

    @Given("^I am on the DuckDuckGo search page$")
    public void navigateToGDuckDuckGo() {
        duckDuckGo.navigateToDuckDuckGo();
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria() {
        duckDuckGo.enterSearchCriteria("DuckDuckGo");
    }

    @And("^click on the search button$")
    public void clickSearchButton() {
        duckDuckGo.clickDuckDuckGoSearch();

    }

    @Then("^the results match the criteria$")
    public void validateResults() {
        Assert.assertEquals("Texto que Esperamos", duckDuckGo.firstResult());
    }

}
