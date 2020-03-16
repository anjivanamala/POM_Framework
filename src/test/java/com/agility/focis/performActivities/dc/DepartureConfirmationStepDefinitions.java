package com.agility.focis.performActivities.dc;

import io.cucumber.java.en.And;

import java.io.IOException;

public class DepartureConfirmationStepDefinitions {
    DepartureConfirmationSteps DepartureConfirmationSteps;

    public DepartureConfirmationStepDefinitions() throws IOException {

        DepartureConfirmationSteps = new DepartureConfirmationSteps();
    }

    @And("Performs Departure Confirmation Activity")
    public void performsDepartureConfirmationActivity() {
    }
}
