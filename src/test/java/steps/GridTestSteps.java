package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.GridPage;

public class GridTestSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage() {// throws InterruptedException {
        // Thread.sleep(1000); // esperar 1000 milisegundos mala practica nunca tener
        // sleeps en tu codigo de automation
        grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue() {
        String value = grid.getValueFromGrid(3, 2);

        // System.out.println(value);
        Assert.assertEquals("r: 2, c: 1", value);

    }

    @Then("^I can validate the table is displayed$")
    public void theTableIsThere() {
        Assert.assertTrue("El elemento está siendo mostrado.", grid.cellStatus());
    }

}
