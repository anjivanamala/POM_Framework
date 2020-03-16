package com.agility.focis.addCarriagesAir;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

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
        SeleniumUtils.waitForPageLoad();
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

    public void addOrigin(String haulierType, String haulierName, String originCargoCollectionDate, String originCargoDeliveryDate) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.tab("Movement"));
        addCarriagesAirPage.addOriginButton.click();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.addOriginOrDestinationFrame);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.haulageArrangementDropdown);
        addCarriagesAirPage.haulierType(haulierType).click();
        addCarriagesAirPage.haulierSearchPicker.click();
        searchForSTK(haulierName);
        addCarriagesAirPage.cargoCollectionDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(originCargoCollectionDate)) + Keys.TAB);
        addCarriagesAirPage.cargoCollectionTime.sendKeys("12");
        addCarriagesAirPage.cargoDeliveryDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(originCargoDeliveryDate)) + Keys.TAB);
        addCarriagesAirPage.cargoDeliveryTime.sendKeys("12");
        addCarriagesAirPage.saveAndCloseOriginCarriage.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void addDestination(String haulierType, String haulierName, String destinationCargoCollectionDate, String destinationCargoDeliveryDate) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.tab("Movement"));
        addCarriagesAirPage.addDestinationButton.click();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.addOriginOrDestinationFrame);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.haulageArrangementDropdown);
        addCarriagesAirPage.haulierType(haulierType).click();
        addCarriagesAirPage.haulierSearchPicker.click();
        searchForSTK(haulierName);
        addCarriagesAirPage.cargoCollectionDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(destinationCargoCollectionDate)) + Keys.TAB);
        addCarriagesAirPage.cargoCollectionTime.sendKeys("12");
        addCarriagesAirPage.cargoDeliveryDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(destinationCargoDeliveryDate)) + Keys.TAB);
        addCarriagesAirPage.cargoDeliveryTime.sendKeys("12");
        addCarriagesAirPage.saveAndCloseDestinationCarriage.click();
        SeleniumUtils.waitForPageLoad();
    }
}
