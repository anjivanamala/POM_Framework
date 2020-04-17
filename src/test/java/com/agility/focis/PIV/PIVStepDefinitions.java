package com.agility.focis.PIV;

import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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

    @Then("Supplier Name and Supplier Invoice Number should be populated correctly")
    public void supplierNameAndSupplierInvoiceNumberShouldBePopulatedCorrectly() {
        pivSteps.verifySupplierInvoiceNumber();
        pivSteps.verifySupplierName();
        if(!SeleniumUtils.getMessageToPrint().equalsIgnoreCase("")){
            Assert.fail();
        }
    }

    @And("PIV Amount Table should be populated correctly")
    public void pivAmountTableShouldBePopulatedCorrectly() {
    }
}
