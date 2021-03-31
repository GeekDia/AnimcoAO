package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MenuPage{


    // Find Locators

    @FindBy(xpath = "//*[@id=\"appel-offres\"]/div/main/div/div/div/div/div/h1")
    @CacheLookup
    private WebElement pageTitle;

    HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getPageTitle(){
        return doGetText(pageTitle);
    }
}
