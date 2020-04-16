package com.agility.focis.PIV;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PIVStepDefinitions {
    private PIVSteps pivSteps;

    public PIVStepDefinitions() throws IOException {

        pivSteps = new PIVSteps();
    }

    @When("Creates PIV Header with below details")
    public void creates_PIV_Header_with_below_details(List<Map<String, String>> pivHeaderInfo) throws InterruptedException {
        for (Map<String, String> pivHeaderDetails : pivHeaderInfo) {
            pivSteps.createPIVHeader(pivHeaderDetails);
            pivSteps.verifyPIVHeader(pivHeaderDetails);
        }
    }
}
