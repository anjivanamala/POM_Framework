package com.agility.focis.purchaseInvoiceAndCredit;

import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIVStepDefinitions {
    private PIVSteps pivSteps;

    public PIVStepDefinitions() throws IOException {

        pivSteps = new PIVSteps();
    }

    @When("Creates PIV Header with below details")
    public void creates_PIV_Header_with_below_details(List<Map<String, String>> pivHeaderInfo) throws InterruptedException {
        pivSteps.navigateHomePage();
        pivSteps.selectMenu("Purchase Invoice/Credit", "Purchase Invoice/Credit/Fast Check", "Job");
        for (Map<String, String> pivHeaderDetails : pivHeaderInfo) {
            pivSteps.createPIVHeader(pivHeaderDetails);
            pivSteps.verifyPIVHeader(pivHeaderDetails);
        }
    }

    @Then("Supplier Name and Supplier Invoice Number should be populated correctly")
    public void supplierNameAndSupplierInvoiceNumberShouldBePopulatedCorrectly() throws InterruptedException {
        pivSteps.verifySupplierInvoiceNumber();
        pivSteps.verifySupplierName();
        if (!SeleniumUtils.getMessageToPrint().equalsIgnoreCase("")) {
            Assert.fail();
        }
    }

    @And("PIV Amount Table should be populated correctly")
    public void pivAmountTableShouldBePopulatedCorrectly() {
    }

    @And("Processes {string} with below details")
    public void processesWithBelowDetails(String pivType, List<Map<String, String>> pivHeaderInfo) throws InterruptedException {
        pivSteps.navigateHomePage();
        pivSteps.selectMenu("Purchase Invoice/Credit", "Purchase Invoice/Credit/Fast Check", "Job");

        for (Map<String, String> pivHeaderDetails : pivHeaderInfo) {
            Map<String, String> mapToPass = new HashMap<>(pivHeaderDetails);
            if (pivType.equalsIgnoreCase("Purchase Invoice")) {
                mapToPass.put("PIV Amount", "100.00");
            } else {
                mapToPass.put("PIV Amount", "-100.00");
            }
            mapToPass.put("Tax Amount", "0.00");
            if (pivHeaderDetails.get("Entity Code").equalsIgnoreCase("1200")) {
                mapToPass.put("Currency", "USD");
            } else {
                mapToPass.put("Currency", "INR");
            }

            pivSteps.createPIVHeader(mapToPass);
            String jobNumber;
            if (pivHeaderDetails.get("Job Number").equalsIgnoreCase("Current Job")) {
                jobNumber = GlobalVariables.getJobNumber();
            } else {
                jobNumber = pivHeaderDetails.get("Job Number");
            }
            pivSteps.processPIV(jobNumber, pivType);
        }

    }
}
