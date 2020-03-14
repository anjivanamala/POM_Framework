package com.agility.focis.base;

import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(Cucumber.class)
public class BaseStepDefinitions {
    BaseSteps baseSteps;

    public BaseStepDefinitions() throws IOException {

        baseSteps = new BaseSteps();
    }

    @Given("User is logged into FOCiS Application")
    public void user_is_logged_into_FOCiS_Application() throws IOException, InterruptedException {
        baseSteps.loginToApp();
    }

    @When("selects {string} from {string} Menu")
    public void selectsFromMenu(String childMenu, String mainMenu) {
        baseSteps.selectMenu(childMenu, mainMenu);
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) throws InterruptedException {
        baseSteps.clickOnaButton(button);
    }

    @When("Clicks {string} Tab")
    public void clicksTab(String tabName) throws InterruptedException {
        baseSteps.clickOnTab(tabName);
    }

    // Method to Take a screenshot...
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverInstantiation.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        System.out.println(scenario.getStatus().toString());
    }

    @AfterStep
    public void performAfterEveryStep(Scenario scenario) {
        if (!SeleniumUtils.getMessageToPrint().equalsIgnoreCase("")) {
            scenario.write(SeleniumUtils.getMessageToPrint());
            SeleniumUtils.reInitializeLog();
        }
        if (SeleniumUtils.isCaptureSnap()) {
            final byte[] screenshot = ((TakesScreenshot) DriverInstantiation.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            SeleniumUtils.reInitializeCaptureSnapFlag();
        }

    }


}
