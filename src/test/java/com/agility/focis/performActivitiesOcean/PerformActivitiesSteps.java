package com.agility.focis.performActivitiesOcean;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.DropDownUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.agility.focis.utilities.testObject.TextBoxUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

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
        clickOnPerformActivityAndSwithToWindow("Carrier Booking Request");
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
        SeleniumUtils.switchToParentWindow();
        SeleniumUtils.waitForPageLoad();

    }

    public void clickOnPerformActivityAndSwithToWindow(String activity) throws InterruptedException {

        performActivitiesPage.performActivity(activity).click();
        performActivitiesPage.acceptAlrtActivityPerform.click();
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

    public void verifyXMLData(String activityName) throws InterruptedException {
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
        SeleniumUtils.logInfo(performActivitiesPage.xmlRawData.getAttribute("value"));
    }
}
