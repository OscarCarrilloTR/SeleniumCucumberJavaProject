package pages;

public class FirefoxPage extends BasePage {

    private String searchButton = "//input[@id='search_button_homepage']";
    private String searchTextField = "//input[@id='search_form_input_homepage']";
    private String firstResult = "";

    public FirefoxPage() {
        super(driver);
    }

    public void navigateToDuckDuckGo() {
        navigateTo("https://duckduckgo.com/");
    }

    public void clickDuckDuckGoSearch() {
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria) {
        write(searchTextField, criteria);
    }

    /*
     * public void validateSearch() { validateText("", ""); }
     */

    public String firstResult() {
        return textFromElement(firstResult);
    }
}
