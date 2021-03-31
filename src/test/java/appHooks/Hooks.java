/**
 * App HOOKS
 */
package appHooks;

import org.openqa.selenium.OutputType;

import utils.DriverManager;
import utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;

import appBase.BaseStep;

import java.net.UnknownHostException;

/**
 * @author bambadia
 *
 */
public class Hooks {


    BaseStep base;

    @Before
    public void initialize() {

        base = new BaseStep();
        base.setUpFramework();
        try {
            base.openBrowser(TestUtils.readProperties("browser"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * @param scenario
     * This function take a screenshot when error is encountered
     */
    @After(order = 1)
    public void takescreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)
                    DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName().replaceAll(" ",
                    "_"));

        }

    }


    @After(order = 0)
    public void tearDown() {

        try {
            base.quit();

        } catch (Exception e) {
            throw e;
        }

    }

}
