package com.agility.focis.performActivities.bctc;

import io.cucumber.java.en.And;

import java.io.IOException;

public class BCTCStepDefinitions {
    BCTCSteps BCTCSteps;

    public BCTCStepDefinitions() throws IOException {

        BCTCSteps = new BCTCSteps();
    }

    @And("Performs Booking Confirmation to Customer Activity")
    public void performsBookingConfirmationToCustomerActivity() {
    }
}
