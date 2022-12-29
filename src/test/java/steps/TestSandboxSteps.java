package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.TestSandBox;

public class TestSandboxSteps {
    TestSandBox sandboxPage = new TestSandBox();

    @Given("^I navigate to the sandobox page$")
    public void navigateToTheSandboxSite() {
        sandboxPage.navigateToSandbox();
    }

    @And("^select a value form the dropdown$")
    public void selectState() {
        sandboxPage.selectCategory("Auto");
    }
}
