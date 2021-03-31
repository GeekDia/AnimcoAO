/**
 * Base Page
 * Set driver and browser
 */
package appBase;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.DriverManager;
import utils.ElementUtils;
import utils.Browsers;
import utils.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author bambadia
 *
 */
public class BaseStep {

	private WebDriver driver;
	protected static HashMap<String, String> strings = new HashMap<>();
	private Boolean grid = false;

	ElementUtils utils = new ElementUtils();

	public void setUpFramework() {

		DriverFactory.setGridURL("http://localhost:4446/wd/hub");
		DriverFactory.setConfigPropertiesPath("config/config.properties");

	}

	/*
	 * This method open the browser
	 */

	public WebDriver openBrowser(String browser) {

		// route log file for each browser
		String strFile = "logs" + File.separator + browser;
		File logFile = new File(strFile);
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		// route logs to separate file for each thread

		ThreadContext.put("ROUTINGKEY", strFile);

		if (System.getenv("ExecutionType") != null && System.getenv("ExecutionType").equalsIgnoreCase("Grid")) {

			setGrid(true);
		}
		// Set execution type Grid or Local
		DriverFactory.setRemote(getGrid());

		if (DriverFactory.isRemote()) {

			utils.log.info("Executing tests on Grid !!!");

			DesiredCapabilities caps = null;

			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {

				caps = DesiredCapabilities.chrome();
				caps.setBrowserName("chrome");
				caps.setPlatform(Platform.ANY);
				utils.log.info("Lauching Chrome !!!");

			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {

				caps = DesiredCapabilities.firefox();
				caps.setBrowserName("firefox");
				caps.setPlatform(Platform.ANY);

				utils.log.info("Lauching Firefox !!!");

			} else if (browser.equalsIgnoreCase(Browsers.IE.name())) {

				caps = DesiredCapabilities.internetExplorer();
				caps.setBrowserName("internet explorer");
				caps.setPlatform(Platform.WIN10);
				utils.log.info("Lauching Internet Explorer !!!");

			}

			try {
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridURL()), caps);
				utils.log.info("Grid set successfully !!!");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {

			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {

				//WebDriverManager.chromedriver().setup();
				String chromeExecPath = System.getProperty("user.dir") + File.separator + "src/test/resources" + File.separator + "config" + File.separator + "chromedriver.exe";
				System.out.println(chromeExecPath);
				System.setProperty("webdriver.chrome.driver", chromeExecPath);

				// disable push no"webdriver.chrome.driver"tifications
				Map<String, Object> preferences = new HashMap<>();
				preferences.put("profile.default_content_setting_values.notifications", 2);
				preferences.put("credentials_enable_service", false);
				preferences.put("profile.password_manager_enabled", false);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", preferences);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				options.addArguments("--incognito");
				options.addArguments("ignore-certificate-errors");

				driver = new ChromeDriver(options);
				utils.log.info("Create driver instance as chrome driver !!!");

			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {

				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOpts = new FirefoxOptions();
				firefoxOpts.addArguments("--private");

				driver = new FirefoxDriver(firefoxOpts);

				utils.log.info("Create driver instance as Gecko driver !!!");

			} else if (browser.equalsIgnoreCase(Browsers.IE.name())) {

				WebDriverManager.iedriver().setup();
				InternetExplorerOptions ieOpts = new InternetExplorerOptions();
				ieOpts.addCommandSwitches("-private");
				driver = new InternetExplorerDriver(ieOpts);
				utils.log.info("Create driver instance as Internet Explorer driver !!!");

			}

		}

		DriverManager.getInstance().setDriver(driver);
		DriverManager.getInstance().getDriver().manage().window().maximize();
		DriverManager.getInstance().getDriver().manage().deleteAllCookies();

		return DriverManager.getInstance().getDriver();

	}

	public Boolean getGrid() {
		return grid;
	}

	public void setGrid(Boolean grid) {
		this.grid = grid;
	}

	/*
	 * 
	 * Quit the driver after test completed
	 */

	public void quit() {
		DriverManager.getInstance().getDriver().quit();
	}
}
