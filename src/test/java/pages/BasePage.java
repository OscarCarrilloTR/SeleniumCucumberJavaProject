package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\6113729\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new FirefoxDriver(firefoxOptions);
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); aqui siempre
        // va a estar esperando 10 segundos espera implicita
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
        // driver.close(); otra opcion no tan recomendada de usar
    }

    private WebElement find(String locator) {
        // es para todo el framework que espera hasta que lo encuentra espera explicita
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void selectFromDropdownByTextWebElement(WebElement locator, String valueToSelect) {
        Select dropdown = new Select(locator);

        dropdown.selectByVisibleText(valueToSelect);
    }

    // Pasar sobre un elemento o poner encima el puntero
    public void hoverOverElement(String locator) {
        action.moveToElement(find(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(find(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(find(locator));
    }

    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

        return find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend) {

        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

        find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    /*
     * public void validateText(String locator, String textToValidate) {
     * Assert.assertEquals(textToValidate, find(locator).getText()); }
     */

    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    // Funsiones de Selenium isDisplayed, isEnabled e isSelected

    public boolean elementEnabled(String locator) {
        return find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator) {

        return find(locator).isDisplayed();

    }

    public boolean elementIsSelected(String locator) {

        return find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

}
