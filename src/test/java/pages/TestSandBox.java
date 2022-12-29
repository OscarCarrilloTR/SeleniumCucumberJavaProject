package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestSandBox extends BasePage {
    
    //Falta revisar porque no sirve el wait.until(ExpectedConditions.visibilityOfElementLocated de la clase BasePage.java
    //private String categoryDropdown = "//select[@id='searchDropdownBox']";
    private String categoryDropdown = "searchDropdownBox";

    public TestSandBox() {
        super(driver);
    }

    public void navigateToSandbox() {
        navigateTo("https://www.amazon.com.mx/");
    }

    public void selectCategory(String category) {
        WebElement webElement= driver.findElement(By.id(categoryDropdown));
        selectFromDropdownByTextWebElement(webElement, category);
    }
}
