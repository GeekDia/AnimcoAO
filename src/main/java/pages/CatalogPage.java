package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

import java.util.List;

public class CatalogPage extends MenuPage {
    WebDriver driver;

    CatalogPage(WebDriver driver) {
        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    // By locators

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div/header/div/div[1]")
    @CacheLookup
    private WebElement pageTitle;

    @FindBy(xpath="//*[@id=\"appel-offres\"]/div/main/div/div/div/div/div[1]/div[2]/button")
    @CacheLookup
    private WebElement createCatalogBtn;

    @FindBy(xpath="//*[@id=\"appel-offres\"]/div/main/div/div/div/div/div[4]/div/div[2]/div[1]/span")
    @CacheLookup
    private WebElement overLayTitle;


    // Get page Title

    public String getPageTitle(){
        return doGetText(pageTitle);
    }

    // Get Overlay Title



    // Create Catalog

    public void createCatalog(){

        doClick(createCatalogBtn);

    }




}
