package com.agility.focis.jp.fcl;

import com.agility.focis.base.BaseStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class FCLStepDefinitions extends BaseStepDefinitions {
    FCLSteps fclSteps;

    public FCLStepDefinitions() throws IOException {

        fclSteps = new FCLSteps();
    }

    @Given("User is logged into FOCiS Application")
    public void user_is_logged_into_FOCiS_Application() throws IOException, InterruptedException {
        fclSteps.loginToApp();
    }

    @When("selects {string} from Menu")
    public void selects_from_Menu(String string) {

    }

    @When("selects {string} from Child Menu")
    public void selects_from_Child_Menu(String string) {

    }

    @Then("{string} Page displays")
    public void page_displays(String string) {

    }
}
