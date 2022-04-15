package pageObjects.television;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

public class televisionPageFactory {
    WebDriver driver;

    //Getting all the elements/selectors on the pages
    @FindBy(css = "#nav-hamburger-menu")
    WebElement allMenuBtn;
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchField;
    @FindBy(css = "#nav-logo")
    WebElement navLogo;
    @FindBy(className = "hmenu-item")
    List<WebElement> mainMenuList;
    @FindBy(xpath = "//*[@class='a-list-item']/a")
    List<WebElement> televisionFilterMenuList;
    @FindBy(css = ".a-section h2 > a > span.a-text-normal")
    List<WebElement> samsungNameCards;
    @FindBy(css = "h2 > a")
    WebElement items;
    @FindBy(css = "#s-result-sort-select")
    WebElement filterBtn;
    @FindBy(css = "#feature-bullets > h1")
    WebElement aboutItemTitle;
    @FindBy(css = "#feature-bullets > ul > li > span")
    WebElement aboutItemList;


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
    public boolean isSearchFieldDisplayed() {
        try {
            return searchField.isDisplayed();
        } catch (Exception e) {
            System.out.print("Search field cannot be located \n" + e.getMessage());
            return false;
        }
    }

    //Check that search field is editable
    public boolean isSearchFieldEditable() {
        return isEditable(searchField);
    }

    //Check that logo is displayed
    public boolean isLogoDisplayed() {
        try {
            return navLogo.isDisplayed();
        } catch (Exception e) {
            System.out.print("Logo cannot be located \n" + e.getMessage());
            return false;
        }
    }

    public String getSearchFieldTypeAttribute() {
        return searchField.getAttribute("type");
    }

    //Check that the menu button is displayed
    public boolean isAllMenuBtnDisplayed() {
        try {
            return allMenuBtn.isDisplayed();
        } catch (Exception e) {
            System.out.print("The side menu button cannot be located \n" + e.getMessage());
            return false;
        }
    }

    //Check that the menu list is displayed after the menu button is clicked.
    public boolean isMainMenuListDisplayed() {
        boolean mainMenu = false;
        try {
            for (WebElement i : mainMenuList) {
                if (i.getText().equalsIgnoreCase("TV, Appliances, Electronics")) {
                    mainMenu = i.isDisplayed();
                    break;
                }
            }
            return mainMenu;
        } catch (Exception e) {
            System.out.print("The side menu list is not displayed \n" + e.getMessage());
            return false;
        }
    }

    //Check that the television list is displayed
    public boolean isTelevisionListDisplayed() {
        boolean tvMenu = false;
        try {
            for (WebElement i : televisionFilterMenuList) {
                if (i.getText().equalsIgnoreCase("Samsung")) {
                    tvMenu = i.isDisplayed();
                    break;
                }
            }
            return tvMenu;
        } catch (Exception e) {
            System.out.print("The television list is not displayed \n" + e.getMessage());
            return false;
        }
    }

    //Check that the filter button is displayed
    public boolean isFilterButtonDisplayed() {
        try {
            return filterBtn.isDisplayed();
        } catch (Exception e) {
            System.out.print("The filter button is not displayed \n" + e.getMessage());
            return false;
        }
    }

    //Check that the name cards of items are displayed to help us confirm each name contains Samsung
    public boolean isSamsungFilterCorrect() {
        boolean nameCards = false;
        try {
            for (WebElement i : samsungNameCards) {
                if (i.getText().contains("Samsung")) {
                    nameCards = true;
                }else{
                    nameCards = false; //return false if an element does not contain Samsung
                    break;
                }
            }
            return nameCards;
        } catch (Exception e) {
            System.out.print("The Samsung name cards is not displayed \n" + e.getMessage());
            return false;
        }
    }

    //Check that the list of items are displayed to help us click on the second highest
    public boolean isSamsungItemsDisplayed() {
        try {
            return items.isDisplayed();
        } catch (Exception e) {
            System.out.print("The list containing each item is not displayed \n" + e.getMessage());
            return false;
        }
    }

    //Check that about item title is displayed
    public boolean isAboutItemTitleDisplayed() {
        try {
            return aboutItemTitle.isDisplayed();
        } catch (Exception e) {
            System.out.print("The about item header is not displayed \n" + e.getMessage());
            return false;
        }
    }

    //Check that the list of bullet points under about item is displayed
    public boolean isAboutItemDescriptionListDisplayed() {
        try {
            return aboutItemList.isDisplayed();
        } catch (Exception e) {
            System.out.print("The list containing about item description is not displayed \n" + e.getMessage());
            return false;
        }
    }

    //Below are methods to click on different elements

    //Click on the main menu button
    public void clickOnAllMenuBtn() {
        allMenuBtn.click();
    }

    //Loop through the main menu list and click on the element that contains the text passed
    //To click on items on the main menu list
    public void clickOnMenuItem(String tvText) {
        try {
            for (WebElement i : mainMenuList) {
                if (i.getText().equalsIgnoreCase(tvText)) {
                    i.click();
                    break;
                }
            }
        }catch (Exception e) {
            System.out.print("The menu element is not displayed \n" + e.getMessage());
        }
    }

    //Check the Televisions list and click on Samsung
    public void clickOnSamsung(){
        try {
            for (WebElement i : televisionFilterMenuList) {
                if (i.getText().equalsIgnoreCase("Samsung")) {
                    i.click();
                    break;
                }
            }
        }catch (Exception e) {
            System.out.print("Samsung is not displayed \n" + e.getMessage());
        }
    }

    //Click on the filter button on the samsung page and filter
    public void clickOnSamsungPriceFilter() {
        Select filter = new Select(filterBtn);
        filter.selectByValue("price-desc-rank");
    }

    //Click on the






}

