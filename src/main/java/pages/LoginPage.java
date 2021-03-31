/**
 *  Login Pages
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

/**
 * @author bambadia
 *
 */
public class LoginPage extends MenuPage {

	WebDriver driver;

	// Locators

	@FindBy(id = "username")
	@CacheLookup
	private WebElement username;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"fm1\"]/div[4]/input[4]")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"fm1\"]/div[4]/input[5]")
	@CacheLookup
	private WebElement reset;

	@FindBy(id="app-name")
	@CacheLookup
	private WebElement pageTitle;

	@FindBy(xpath="//*[@id=\"msg\"]/h2")
	@CacheLookup
	private WebElement successMsg;


	// Constructor

	public LoginPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean isForgotPasswordLinkExist() {

		return reset.isDisplayed();

	}

	public void enterUsername(String username) {

		//email.sendKeys(username);
		doSendKeys(this.username, username);
	}

	public void enterPasswd(String passwd) {

		//password.sendKeys(passwd);
		doSendKeys(this.password, passwd);

	}

	public void clickOnLoginButton() {

		//loginButton.click();
		doClick(loginButton);
	}

	public String getPageTitle(){
		return doGetText(pageTitle);
	}

	public String getSuccesLoginMsg(){
		return doGetText(successMsg);
	}
	
	public HomePage doLogin(String username, String password) {
		
		enterUsername(username);
		enterPasswd(password);
		clickOnLoginButton();
		
		return new HomePage(driver) ;
	}
}
