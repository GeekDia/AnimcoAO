package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class MenuPage extends ElementUtils {
    WebDriver driver;

    MenuPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // By locators

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div/header/div/div[1]")
    @CacheLookup
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div[2]/nav/div[1]/div/a[2]/div[2]/div")
    @CacheLookup
    private WebElement catalogEntryLink;

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div[2]/nav/div[1]/div/a[3]/div[2]")
    @CacheLookup
    private WebElement profilMgtEntryLink;

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div[2]/nav/div[1]/div/a[1]/div[2]/div")
    @CacheLookup
    private WebElement homeEntryTxtLink;

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div[2]/nav/div[1]/div/div/div/div/span")
    @CacheLookup
    private WebElement menuTxt;

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div/header/div/button")
    @CacheLookup
    private WebElement menuBtn;

    @FindBy(xpath="//*[@id=\"appel-offres\"]/div[1]/header/div/div[3]")
    @CacheLookup
    private WebElement xfrTxt;


    // Check XFR is displayed after login

    public Boolean isDisplayed(){
        return xfrTxt.isDisplayed();
    }

    // Clic on Catalog Entry

    public CatalogPage accessNeedCatalogs(){

        doClick(catalogEntryLink);

        return new CatalogPage(driver);
    }

}
