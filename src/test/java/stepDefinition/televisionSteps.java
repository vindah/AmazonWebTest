package stepDefinition;

import dataProvider.configFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import pageObjects.television.televisionPageFactory;

import java.util.concurrent.TimeUnit;

public class televisionSteps {

    WebDriver driver;
    televisionPageFactory televisionPage;
    configFileReader ConfigFileReader;


    // This runs before each test
    @Before()
    public void setup() {
        driver = utilities.driverFactory.open("chrome");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        ConfigFileReader = new configFileReader();
    }



    @Test
    //Smoke test - verify that the home page loads properly
    @Given("The merchant is on the home page")
    public void merchant_home_page() {
        System.out.println("Opening URL: " + ConfigFileReader.getApplicationUrl());    //+ "signin"
        driver.get(ConfigFileReader.getApplicationUrl()) ;
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        televisionPage = new televisionPageFactory(driver);
    }
    @Then("The Logo should be displayed")
    public void verify_page_logo () {
        Assert.assertTrue(televisionPage.isLogoDisplayed());
    }
    @Then("The search field should be present and editable")
    public void verify_search_field () {
        Assert.assertTrue(televisionPage.isSearchFieldDisplayed());
        Assert.assertTrue(televisionPage.isSearchFieldEditable());
        Assert.assertEquals(televisionPage.getSearchFieldTypeAttribute(), "text");
    }
    @Then("The side menu button should be present")
    public void verify_side_menu_btn(){
        Assert.assertTrue(televisionPage.isAllMenuBtnDisplayed());
    }

    //Acceptance test to validate the Samsung TV page
    @When("The user clicks on the Side menu button")
    public void click_on_side_menuBtn(){
        televisionPage.clickOnAllMenuBtn();
        Assert.assertTrue(televisionPage.isMainMenuListDisplayed());
    }

    @And("The user clicks on Tv, Electronics and Appliances")
    public void click_on_tvElectronicsAndAppliances(){
        televisionPage.clickOnMenuItem("TV, Appliances, Electronics");
    }

    @And("The user clicks on Televisions")
    public void click_on_televisions() throws InterruptedException {
        Thread.sleep(2000);
        televisionPage.clickOnMenuItem("Televisions");
        Assert.assertTrue(televisionPage.isTelevisionListDisplayed());
    }

    @And("The user clicks on Samsung")
    public void click_on_samsung(){
        televisionPage.clickOnSamsung();
    }

    @Then("The Samsung page should be displayed successfully")
    public void verify_samsung_page(){
        Assert.assertTrue(televisionPage.isSamsungFilterCorrect());
    }

    @When("The user filters by high to low")
    public void filter_by_highToLow() throws InterruptedException {
        Assert.assertTrue(televisionPage.isFilterButtonDisplayed());
        televisionPage.clickOnSamsungPriceFilter();
        Thread.sleep(4000);
        Assert.assertTrue(televisionPage.checkItemPrices());
    }

    @And("The user clicks on the second highest item")
    public void click_on_secondHighest_item() throws InterruptedException {
        televisionPage.clickOnSecondHighestItem();
        Thread.sleep(3000);
    }

    @Then("The user should be able to log the about of the item successfully to the console")
    public void log_about_of_Samsung_item(){
        Assert.assertTrue(televisionPage.isAboutItemTitleDisplayed());
        Assert.assertTrue(televisionPage.isAboutItemDescriptionListDisplayed());
    }




    @After()
    public void takeScreenshots(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
        driver.quit();
    }
}
