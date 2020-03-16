package com.agility.focis.performActivities.cbc;

import io.cucumber.java.en.And;

import java.io.IOException;

public class CBCStepDefinitions {
    CBCSteps CBCSteps;

    public CBCStepDefinitions() throws IOException {

        CBCSteps = new CBCSteps();
    }

    @And("Performs Carrier Booking Confirmation Activity")
    public void performsCarrierBookingConfirmationActivity() {
    }

}
