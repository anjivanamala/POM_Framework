package com.agility.focis.performActivities.common;

import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.performActivities.ac.ArrivalConfirmationSteps;
import com.agility.focis.performActivities.awb.IssueAWBSteps;
import com.agility.focis.performActivities.bctc.BCTCSteps;
import com.agility.focis.performActivities.cbc.CBCSteps;
import com.agility.focis.performActivities.cbr.CBRSteps;
import com.agility.focis.performActivities.crc.CRCSteps;
import com.agility.focis.performActivities.dc.DepartureConfirmationSteps;
import com.agility.focis.performActivities.mblf.MBLFSteps;
import com.agility.focis.performActivities.mbli.MBLISteps;
import com.agility.focis.performActivities.slbol.SLBOLSteps;
import com.agility.focis.performActivities.sqsur.SQSURSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommonStepDefinitions {
    CommonSteps commonSteps;
    ArrivalConfirmationSteps arrivalConfirmationSteps;
    IssueAWBSteps issueAWBSteps;
    BCTCSteps bctcSteps;
    CBCSteps cbcSteps;
    CBRSteps cbrSteps;
    CRCSteps crcSteps;
    DepartureConfirmationSteps departureConfirmationSteps;
    MBLFSteps mblfSteps;
    MBLISteps mbliSteps;
    SLBOLSteps slbolSteps;
    SQSURSteps sqsurSteps;


    public CommonStepDefinitions() throws IOException {

        commonSteps = new CommonSteps();

        arrivalConfirmationSteps = new ArrivalConfirmationSteps();
        issueAWBSteps = new IssueAWBSteps();
        bctcSteps = new BCTCSteps();
        cbcSteps = new CBCSteps();
        cbrSteps = new CBRSteps();
        crcSteps = new CRCSteps();
        departureConfirmationSteps = new DepartureConfirmationSteps();
        mblfSteps = new MBLFSteps();
        mbliSteps = new MBLISteps();
        slbolSteps = new SLBOLSteps();
        sqsurSteps = new SQSURSteps();

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
                cbrSteps.enterContract("FAK");
                cbrSteps.completeCBR();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Carrier Booking Request i.e " + cbr);
            }
            if (cbc.equalsIgnoreCase("Yes")) {

                cbcSteps.completeCBC();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Carrier Booking Confirmation i.e " + cbc);
            }
            if (bctc.equalsIgnoreCase("Yes")) {
                bctcSteps.completeBCTC();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Booking Confirmation to Customer i.e " + bctc);
            }
            if (mbl.equalsIgnoreCase("Yes")) {
                mbliSteps.completeMBLI();
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Master Bill Of Lading Instructions i.e " + mbl);
            }

        }
    }

    @Then("Status of Activities should be Completed")
    public void statusOfActivitiesShouldBeCompleted() {
        commonSteps.verifyStatusOfActivities();
        GlobalVariables.setJobStatus(commonSteps.commonPage.jobStatus.getText());
    }

    @And("EDI XML Data should be populated Correctly for {string}")
    public void ediXMLDataShouldBePopulatedCorrectlyFor(String activityName) throws InterruptedException, JsonProcessingException {
        switch (activityName) {
            case "CBR":
                cbrSteps.verifyCBRXML();
                break;
            case "MBL":

            default:
                SeleniumUtils.logInfo("Invalid Activity i.e " + activityName);
        }

    }
}
