package com.agility.focis.performActivities.awb;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.CBR.JOBDETAILS;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.performActivities.common.CommonSteps;
import com.agility.focis.utilities.testObject.DynamicTableUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IssueAWBSteps extends CommonSteps {
    private WebDriver driver;
    IssueAWBPage issueAWBPage;

    public IssueAWBSteps() throws IOException {
        this.driver = getDriver();
        issueAWBPage = new IssueAWBPage(this.driver);

    }

    public void performAWB() throws InterruptedException {
        GlobalVariables.setJobNumber("100138336");
        navigateToDashboard();
        if (driver.getCurrentUrl().contains("dashboard")) {
            DynamicTableUtils.typeTextOnSearchPickerPopup("EventName", "Issue AWB");
            Thread.sleep(1000);
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.clickOnIconUsingReferenceData("EventName", "Issue AWB", "blue");
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.takeScreenshot();
        }
        switchToNewWindow();
        SeleniumUtils.waitForPageLoad();
//      Complete CSD
        clickOnTab("CSD");

    }
}
