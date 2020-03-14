package com.agility.focis.performActivitiesOcean;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PerformActivitiesStepDefinitions {
    PerformActivitiesSteps performActivitiesSteps;

    public PerformActivitiesStepDefinitions() throws IOException {

        performActivitiesSteps = new PerformActivitiesSteps();
    }

    @When("Performs Activities as below")
    public void performs_Activities_as_below(List<Map<String, String>> activitiesList) throws InterruptedException {
        for (int i = 0; i < activitiesList.size(); i++) {
            String cbr = activitiesList.get(i).get("Carrier Booking Request");
            String cbc = activitiesList.get(i).get("Carrier Booking Confirmation");
            String bctc = activitiesList.get(i).get("Booking Confirmation to Customer");
            String mbl = activitiesList.get(i).get("Master Bill Of Lading Instructions");
//            Perform Activities based on Options
            if (cbr.equalsIgnoreCase("Yes")) {
                performActivitiesSteps.enterContract("FAK");
                performActivitiesSteps.completeCBR();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Carrier Booking Request i.e " + cbr);
            }
            if (cbc.equalsIgnoreCase("Yes")) {

                performActivitiesSteps.completeCBC();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Carrier Booking Confirmation i.e " + cbc);
            }
            if (bctc.equalsIgnoreCase("Yes")) {
                performActivitiesSteps.completeBCTC();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Booking Confirmation to Customer i.e " + bctc);
            }
            if (mbl.equalsIgnoreCase("Yes")) {
                performActivitiesSteps.completeMBL();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Master Bill Of Lading Instructions i.e " + mbl);
            }

        }
    }

    @Then("Status of Activities should be Completed")
    public void statusOfActivitiesShouldBeCompleted() {
        performActivitiesSteps.verifyStatusOfActivities();
        GlobalVariables.setJobStatus(performActivitiesSteps.performActivitiesPage.jobStatus.getText());
    }

    @And("EDI XML Data should be populated Correctly for {string}")
    public void ediXMLDataShouldBePopulatedCorrectlyFor(String activityName) throws InterruptedException, JsonProcessingException {
        switch (activityName) {
            case "CBR":
                performActivitiesSteps.verifyCBRXML();
                break;
            case "MBL":

            default:
                SeleniumUtils.logInfo("Invalid Activity i.e " + activityName);
        }

    }
}
