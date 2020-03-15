package com.agility.focis.performActivitiesOcean;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.CBR.JOBDETAILS;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.jp.initiateJob.InitiateJobPage;
import com.agility.focis.utilities.testObject.DropDownUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.agility.focis.utilities.testObject.TextBoxUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.text.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerformActivitiesSteps extends BaseSteps {
    private WebDriver driver;
    PerformActivitiesPage performActivitiesPage;

    public PerformActivitiesSteps() throws IOException {
        this.driver = getDriver();
        performActivitiesPage = new PerformActivitiesPage(this.driver);

    }


    public void completeCBR() throws InterruptedException {
        clickOnTab("Tasks");
        SeleniumUtils.waitForPageLoad();
        GlobalVariables.setProductType(performActivitiesPage.verifyProductType.getText());
        clickOnPerformActivityAndSwithToWindow("Carrier Booking Request");
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(performActivitiesPage.referenceSearchButton("Agility Office (Owner of Activity)"));
        performActivitiesPage.referenceSearchButton("Agility Office (Owner of Activity)").click();
        performActivitiesPage.selectAllReferences.click();
        performActivitiesPage.saveReferences.click();

        performActivitiesPage.referenceSearchButton("Shipper").click();
        performActivitiesPage.selectAllReferences.click();
        performActivitiesPage.saveReferences.click();

        performActivitiesPage.referenceSearchButton("Consignee").click();
        performActivitiesPage.selectAllReferences.click();
        performActivitiesPage.saveReferences.click();

        performActivitiesPage.completeButton.click();
        SeleniumUtils.waitForPageLoad();
        performActivitiesPage.alertButtonToComplete.click();
        SeleniumUtils.waitForPageLoad();
        performActivitiesPage.alertButtonToPrint.click();
        SeleniumUtils.waitForPageLoad();
        performActivitiesPage.ediButton.click();
        GlobalVariables.setParties(getPartyInformationCBR());
        SeleniumUtils.switchToParentWindow();
        SeleniumUtils.waitForPageLoad();

    }

    public void clickOnPerformActivityAndSwithToWindow(String activity) throws InterruptedException {

        performActivitiesPage.performActivity(activity).click();
        if (driver.findElements(By.xpath("//div[@aria-describedby ='alrtActivityPerform']//button[text() = 'OK']")).size() > 0) {
            performActivitiesPage.acceptAlrtActivityPerform.click();
        }

        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.setParentWindow(driver.getWindowHandle());
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void enterContract(String typeOfContract) throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForPageLoad();
        performActivitiesPage.contractInput.sendKeys("AutoContract");
        Select contractType = new Select(performActivitiesPage.carrierContractType);
        contractType.selectByVisibleText(typeOfContract);
    }

    public void completeCBC() {

    }

    public void completeBCTC() {
    }

    public void completeMBL() {
    }

    public void verifyStatusOfActivities() {
    }

    public void readCBRXML() throws InterruptedException {
        performActivitiesPage.moreLinksButton.click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(performActivitiesPage.moreLinksIframe);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToPresent(By.xpath("//ul[@id = 'ulSideMenuBar']//a[text() = 'Intg.. Audit']"));
        SeleniumUtils.waitForElementToBeClickable(performActivitiesPage.moreLinks_linkToBeClicked("Intg.. Audit"));
        performActivitiesPage.moreLinks_linkToBeClicked("Intg.. Audit").click();
        performActivitiesPage.fobSearchButton("", "Booking Request").click();
        SeleniumUtils.waitForElementToBeClickable(performActivitiesPage.xmlDataLink("Booking Request"));
        performActivitiesPage.xmlDataLink("Booking Request").click();
        String xmlRawData = performActivitiesPage.xmlRawData.getAttribute("value");
        GlobalVariables.setCbrXMLData(xmlRawData);
    }

    public void verifyCBRXML() throws InterruptedException, JsonProcessingException {
        this.readCBRXML();
        JOBDETAILS cbrXMLData = CBREDI.getEDIInfo(GlobalVariables.getCbrXMLData());
        compareStringsAndLogInfo("Job Number", GlobalVariables.getJobNumber(), cbrXMLData.getJobNumber());
        compareStringsAndLogInfo("Product", GlobalVariables.getProduct(), cbrXMLData.getProduct());
        compareStringsAndLogInfo("Product Type", GlobalVariables.getProductType(), cbrXMLData.getProductType());
        compareStringsAndLogInfo("Job Status", GlobalVariables.getJobStatus(), cbrXMLData.getJobStatus().getStatusDescription());
        compareStringsAndLogInfo("Incoterm", GlobalVariables.getIncoterm(), cbrXMLData.getIncotermlocation().getINCOTERMTYPE());
        compareStringsAndLogInfo("Incoterm Location", GlobalVariables.getIncoTermLocation(), cbrXMLData.getIncotermlocation().getLocation());
        if (!GlobalVariables.getParties().equals(cbrXMLData.getParties().getpartyInformation())) {
            SeleniumUtils.logInfo("Parties Information Populated Incorrectly" + "\nExpected: \n" + GlobalVariables.getParties() + "\nActual: \n" + cbrXMLData.getParties().getpartyInformation());
        }

        if (!SeleniumUtils.getMessageToPrint().equalsIgnoreCase(""))
            Assert.fail("CBR EDI Data Populated Incorrectly");

    }

    public void compareStringsAndLogInfo(String fieldName, String expected, String actual) {
        if (!expected.equalsIgnoreCase(actual))
            SeleniumUtils.logInfo(fieldName + " populated incorrectly\nExpected: " + expected + "\n Actual : " + actual + "\n");

    }

    public Map<String, Map<String, String>> getPartyInformationCBR() {
        Map<String, Map<String, String>> parties = new HashMap<>();
        Map<String, String> agilityOffice = new HashMap<>();
        Map<String, String> branch = new HashMap<>();
        Map<String, String> shipper = new HashMap<>();
        Map<String, String> consignee = new HashMap<>();
        Map<String, String> notifyParty = new HashMap<>();

        agilityOffice.put("Name", WordUtils.capitalizeFully(performActivitiesPage.partyName("Agility Office (Owner of Activity)").getAttribute("value")));
        agilityOffice.put("Address", performActivitiesPage.partyAddress("Agility Office (Owner of Activity)").getAttribute("value"));
        parties.put("Agility Office", agilityOffice);

        branch.put("Name", WordUtils.capitalizeFully(performActivitiesPage.partyName("Booking Branch (Performer of Activity)").getAttribute("value")));
        branch.put("Address", performActivitiesPage.partyAddress("Booking Branch (Performer of Activity)").getAttribute("value"));
        parties.put("Branch", branch);

        shipper.put("Name", WordUtils.capitalizeFully(performActivitiesPage.partyName("Shipper").getAttribute("value")));
        shipper.put("Address", performActivitiesPage.partyAddress("Shipper").getAttribute("value"));
        parties.put("Shipper", shipper);

        consignee.put("Name", WordUtils.capitalizeFully(performActivitiesPage.partyName("Consignee").getAttribute("value")));
        consignee.put("Address", performActivitiesPage.partyAddress("Consignee").getAttribute("value"));
        parties.put("Consignee", consignee);

        notifyParty.put("Name", WordUtils.capitalizeFully(performActivitiesPage.partyName("Notify Party").getAttribute("value")));
        notifyParty.put("Address", performActivitiesPage.partyAddress("Notify Party").getAttribute("value"));
        parties.put("Notify Party", notifyParty);
        return parties;
    }
}
