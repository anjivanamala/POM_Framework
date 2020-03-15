package com.agility.focis.addCarriagesAir;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.apache.commons.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCarriagesAirSteps extends BaseSteps {
    private WebDriver driver;
    AddCarriagesAirPage addCarriagesAirPage;

    public AddCarriagesAirSteps() throws IOException {
        this.driver = getDriver();
        addCarriagesAirPage = new AddCarriagesAirPage(this.driver);

    }

    public void clickOnAddAirportToAirport() throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.addAirportToAirportButton);
        addCarriagesAirPage.addAirportToAirportButton.click();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.tab("Movement"));
    }

    public void addAirportToAirport(String Carrier, String FlightNumber, String AirportOfDeparture, String AirportOfArrival, String ETD, String ETDTime, String ETA, String ETATime, String Supplier, String Cost, String Revenue) throws InterruptedException {
        clickOnAddAirportToAirport();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.addAirportToAirportFrame);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.jobTypeDropdown);
        addCarriagesAirPage.jobTypeDropdown.click();
        addCarriagesAirPage.jobTypeBackToBack.click();
        addCarriagesAirPage.jobTypeChangeAlert.click();
        addCarriagesAirPage.Carrier.sendKeys(Carrier);
        addCarriagesAirPage.Carrier.sendKeys(Keys.TAB);
        addCarriagesAirPage.FlightNumber.sendKeys(FlightNumber);
        addCarriagesAirPage.Aod.sendKeys(AirportOfDeparture);
        addCarriagesAirPage.Aod.sendKeys(Keys.TAB);
        addCarriagesAirPage.Aoa.sendKeys(AirportOfArrival);
        addCarriagesAirPage.Aoa.sendKeys(Keys.TAB);
        addCarriagesAirPage.EtdDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(ETD)) + Keys.TAB);
        addCarriagesAirPage.EtdTime.sendKeys(ETDTime);
        addCarriagesAirPage.EtaDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(ETA)) + Keys.TAB);
        addCarriagesAirPage.EtaTime.sendKeys(ETATime);
        addCarriagesAirPage.pullMawbNumberIcon.click();
        addCarriagesAirPage.saveAndCompleteActivityButton.click();
        SeleniumUtils.waitForPageLoad();
//        driver.switchTo().defaultContent();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.iFrameEstimationscreen);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.Supplier);
        addCarriagesAirPage.Supplier.click();
        searchForSTK(Supplier);
        addCarriagesAirPage.enterCost.sendKeys(Cost);
        addCarriagesAirPage.enterRevenue.sendKeys(Revenue);
        addCarriagesAirPage.saveAndCloseButton.click();
        SeleniumUtils.waitForPageLoad();


    }

}
