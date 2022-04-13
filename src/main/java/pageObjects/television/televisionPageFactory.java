package pageObjects.television;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class televisionPageFactory {
    WebDriver driver;

    //Getting all the elements/selectors on the pages
    @FindBy(css = "#nav-hamburger-menu")
    WebElement allMenuBtn;
    @FindBy(css = ".nav-search-field")
    WebElement searchField;
    @FindBy(css = "#nav-logo")
    WebElement navLogo;
    @FindBy(css = ".hmenu")
    WebElement mainMenuList;
    @FindBy(css = ".a-list-item > a")
    WebElement televisionFilterList;
    @FindBy(css = ".a-section h2 > a > span.a-text-normal")
    WebElement nameCards;
    @FindBy(css = "#s-result-sort-select")
    WebElement filterBtn;




    public televisionPageFactory(WebDriver driver) {
        this.driver = driver;

        //Initialize web elements
        PageFactory.initElements(driver, this);
    }


    //Methods below check that elements on the page are displayed and editable

    //Check that field is editable - For any check for editable field, we reuse this.
    private boolean isEditable(WebElement element) {
        element.sendKeys("editable");
        if (element.getAttribute("value").contentEquals("editable")) return true;
        return false;
    }

    //Check that search field is displayed
    public boolean isSearchFieldDisplayed () {
        try {
            return searchField.isDisplayed();
        } catch(Exception e) {
            System.out.print("Search field cannot be located \n" + e.getMessage());
            return false;
        }
    }

    //Check that search field is editable
    public boolean isSearchFieldEditable() {
        return isEditable(searchField);
    }

    //Check that logo is displayed
    public boolean isLogoDisplayed () {
        try {
            return navLogo.isDisplayed();
        } catch(Exception e) {
            System.out.print("Logo cannot be located \n" + e.getMessage());
            return false;
        }
    }


    public String getSearchFieldTypeAttribute () {
        return searchField.getAttribute("type");
    }

    //Check that the menu button is displayed
    public boolean isAllMenuBtnDisplayed () {
        try {
            return allMenuBtn.isDisplayed();
        } catch(Exception e) {
            System.out.print("The side menu button cannot be located \n" + e.getMessage());
            return false;
        }
    }




}

