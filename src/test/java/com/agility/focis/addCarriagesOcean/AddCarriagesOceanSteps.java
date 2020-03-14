package com.agility.focis.addCarriagesOcean;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddCarriagesOceanSteps extends BaseSteps {
    private WebDriver driver;
    AddCarriagesOceanPage addCarriagesOceanPage;

    public AddCarriagesOceanSteps() throws IOException {
        this.driver = getDriver();
        addCarriagesOceanPage = new AddCarriagesOceanPage(this.driver);

    }

    public void clickOnAddMainCarriage() throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.addMainCarriageButton);
        addCarriagesOceanPage.addMainCarriageButton.click();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.tab("Movement"));
    }

    public void addMainCarriage(String carrier, String vessel, String voyage, String portOfLoading, String etd, String portofDischarge, String eta, String jobtype) throws InterruptedException {


    }

    public void updateMainCarriageHeader(String carrier, String jobType) throws InterruptedException {
        clickOnAddMainCarriage();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesOceanPage.mainCarriageiFrame);
        SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.useBlankSchedule);
        addCarriagesOceanPage.useBlankSchedule.click();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.carrierInput);
        Thread.sleep(1000);
        addCarriagesOceanPage.carrierInput.sendKeys(carrier);
        SeleniumUtils.waitForNumberOfElementsToBeMoreThan(By.xpath("//ul/li/a[contains(text(),'" + carrier + "')]"), 0);
        addCarriagesOceanPage.inlineSearchRecommendations(carrier).click();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.jobType);
        Select jobTypeDropdown = new Select(addCarriagesOceanPage.jobType);
        jobTypeDropdown.selectByVisibleText(jobType);
    }


    public void addSingleLeg(String carrier, String jobType, List<Map<String, String>> mainCarriageInfo) throws InterruptedException {
        updateMainCarriageHeader(carrier, jobType);
        try {
            for (int i = 0; i < mainCarriageInfo.size(); i++) {

                String portOfLoading = mainCarriageInfo.get(i).get("Port of Loading");
                String etd = mainCarriageInfo.get(i).get("ETD");
                String portOfDischarge = mainCarriageInfo.get(i).get("Port of Discharge");
                String eta = mainCarriageInfo.get(i).get("ETA");
                if (!portOfLoading.equalsIgnoreCase("")) {
                    enterVesselDetailsOfALeg(2, portOfLoading, etd, portOfDischarge, eta);
                    addCarriagesOceanPage.saveAndCloseMainCarriageButton.click();
                    driver.switchTo().defaultContent();
                    SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.tab("Movement"));
                }

            }
        } catch (Exception e) {
            driver.switchTo().defaultContent();
            addCarriagesOceanPage.closeIframeButton.click();
            SeleniumUtils.logInfo("Error Occured while adding Main Carriage");
            SeleniumUtils.logInfo("\n" + e.toString());
        }
    }


    public void addTwoLegs(String carrier, String jobType, List<Map<String, String>> mainCarriageInfo) throws InterruptedException {
        updateMainCarriageHeader(carrier, jobType);
        addCarriagesOceanPage.originMainCheckBox(1).click();
        addCarriagesOceanPage.destinationMainCheckBox(2).click();
        try {
            for (int i = 0; i < mainCarriageInfo.size(); i++) {

                String portOfLoading = mainCarriageInfo.get(i).get("Port of Loading");
                String etd = mainCarriageInfo.get(i).get("ETD");
                String portOfDischarge = mainCarriageInfo.get(i).get("Port of Discharge");
                String eta = mainCarriageInfo.get(i).get("ETA");
                if (!portOfLoading.equalsIgnoreCase("")) {
                    enterVesselDetailsOfALeg(2, portOfLoading, etd, portOfDischarge, eta);
                }

            }
            addCarriagesOceanPage.saveAndCloseMainCarriageButton.click();
            SeleniumUtils.waitForPageLoad();
        } catch (Exception e) {
            driver.switchTo().defaultContent();
            addCarriagesOceanPage.closeIframeButton.click();
            SeleniumUtils.logInfo("Error Occured while adding Main Carriage");
            SeleniumUtils.logInfo("\n" + e.toString());
        }
    }

    public void addmultipleLeg(String carrier, String jobType, List<Map<String, String>> mainCarriageInfo) throws InterruptedException {
        updateMainCarriageHeader(carrier, jobType);
        addCarriagesOceanPage.originMainCheckBox(1).click();
        addCarriagesOceanPage.destinationMainCheckBox(3).click();
        try {
            for (int i = 0; i < mainCarriageInfo.size(); i++) {

                String portOfLoading = mainCarriageInfo.get(i).get("Port of Loading");
                String etd = mainCarriageInfo.get(i).get("ETD");
                String portOfDischarge = mainCarriageInfo.get(i).get("Port of Discharge");
                String eta = mainCarriageInfo.get(i).get("ETA");

                enterVesselDetailsOfALeg(i + 1, portOfLoading, etd, portOfDischarge, eta);
            }
//            addCarriagesOceanPage.saveAndCloseMainCarriageButton.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", addCarriagesOceanPage.saveAndCloseMainCarriageButton);
            SeleniumUtils.waitForPageLoad();
            Thread.sleep(1000);
        } catch (Exception e) {
            driver.switchTo().defaultContent();
            addCarriagesOceanPage.closeIframeButton.click();
            SeleniumUtils.logInfo("Error Occured while adding Main Carriage");
            SeleniumUtils.logInfo("\n" + e.toString());
        }

    }

    public void enterVesselDetailsOfALeg(int i, String portOfLoading, String etd, String portOfDischarge, String eta) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.vessel(i));
        addCarriagesOceanPage.vessel(i).sendKeys("Single Leg Vessel");
        addCarriagesOceanPage.voyage(i).sendKeys("Single Leg Voyage");
        addCarriagesOceanPage.portOFLoading(i).sendKeys(portOfLoading);
        Thread.sleep(1000);
        addCarriagesOceanPage.portOFLoading(i).sendKeys(Keys.ENTER);
        SeleniumUtils.waitForElementToBeClickable(addCarriagesOceanPage.portOfDischarge(i));
        addCarriagesOceanPage.portOfDischarge(i).sendKeys(portOfDischarge);
        Thread.sleep(1000);
        addCarriagesOceanPage.portOfDischarge(i).sendKeys(Keys.ENTER);
        SeleniumUtils.selectDate(addCarriagesOceanPage.etd(i), Integer.parseInt(etd));
        addCarriagesOceanPage.etdTime(i).sendKeys("12" + Keys.TAB);
        SeleniumUtils.selectDate(addCarriagesOceanPage.eta(i), Integer.parseInt(eta));
        addCarriagesOceanPage.etaTime(i).sendKeys("12" + Keys.TAB);
    }

    public void addPreCarriage(String haulierType, String haulierName, String originCargoCollectionDate, String originCargoDeliveryDate) throws InterruptedException {
        addCarriagesOceanPage.addPreCarriageButton.click();
        SeleniumUtils.waitForElementToVisible(addCarriagesOceanPage.closeIframeButton);
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesOceanPage.preOrOnCarriageFrame);
        Select haulierDropdown = new Select(addCarriagesOceanPage.haulageArrangementDropDown);
        haulierDropdown.selectByVisibleText(haulierType);
        addCarriagesOceanPage.haulierInput.sendKeys(haulierName);
        SeleniumUtils.waitForNumberOfElementsToBeMoreThan(By.xpath("//ul/li/a[contains(text(),'" + haulierName + "')]"), 0);
        addCarriagesOceanPage.inlineSearchRecommendations(haulierName).click();
        addCarriagesOceanPage.originOrDestinationCollDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(originCargoCollectionDate)));
        addCarriagesOceanPage.originOrDestinationCollTime.sendKeys("12");
        addCarriagesOceanPage.originOrDestinationDelDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(originCargoDeliveryDate)));
        addCarriagesOceanPage.originOrDestinationDelTime.sendKeys("12");
        addCarriagesOceanPage.savePreCarriage.click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.takeScreenshot();
    }

    public void addOnCarriage(String haulierType, String haulierName, String destinationCargoCollectionDate, String destinationCargoDeliveryDate) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(addCarriagesOceanPage.addOnCarriageButton).build().perform();
        addCarriagesOceanPage.addOnCarriageButton.click();
        SeleniumUtils.waitForElementToVisible(addCarriagesOceanPage.closeIframeButton);
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesOceanPage.preOrOnCarriageFrame);
        Select haulierDropdown = new Select(addCarriagesOceanPage.haulageArrangementDropDown);
        haulierDropdown.selectByVisibleText(haulierType);
        addCarriagesOceanPage.haulierInput.sendKeys(haulierName);
        SeleniumUtils.waitForNumberOfElementsToBeMoreThan(By.xpath("//ul/li/a[contains(text(),'" + haulierName + "')]"), 0);
        addCarriagesOceanPage.inlineSearchRecommendations(haulierName).click();
        addCarriagesOceanPage.originOrDestinationCollDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(destinationCargoCollectionDate)));
        addCarriagesOceanPage.originOrDestinationCollTime.sendKeys("12");
        addCarriagesOceanPage.originOrDestinationDelDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(destinationCargoDeliveryDate)));
        addCarriagesOceanPage.originOrDestinationDelTime.sendKeys("12");
        addCarriagesOceanPage.savePreCarriage.click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.takeScreenshot();
    }
}
