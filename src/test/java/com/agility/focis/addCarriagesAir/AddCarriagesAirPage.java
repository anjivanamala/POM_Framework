package com.agility.focis.addCarriagesAir;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.awt.windows.WEmbeddedFrame;

public class AddCarriagesAirPage extends BasePage {

    public AddCarriagesAirPage(WebDriver driver) {
        super(driver);
    }

//-----------------------Airport to Airport-----------------------

    @FindBy(xpath = "//td[normalize-space(text())='Airport to Airport']/..//a[@title='Add Main Carriage']")
    public WebElement addAirportToAirportButton;
    @FindBy(xpath = "//button[@id='drpJobTypes']/..//li[@id='liBackToBack']")
    public WebElement jobTypeBackToBack;
    @FindBy(xpath = "//input[contains(@id,'txtCarrierList')]")
    public WebElement selectCarrier;
    @FindBy(id = "txtFlightNumber_1")
    public WebElement enterFlightNumber;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortAOD_1')]")
    public WebElement selectAod;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortAOA_1')]")
    public WebElement selectAoa;
    @FindBy(xpath = "//button[contains(@id,'txtFlSchViaPortETD_1')]")
    public WebElement selectEtdDate;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortETDTime_1')]")
    public WebElement selectEtdTime;
    @FindBy(xpath = "//button[contains(@id,'txtFlSchViaPortETA_1')]")
    public WebElement selectEtaDate;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortETATime_1')]")
    public WebElement selectEtaTime;
    @FindBy(xpath = "//option[@value='Cargo']/../../select[@id='ddlViaPortAircraftType_1']")
    public WebElement selectAirCraftType;
    @FindBy(id = "txtViaPortAirCraft_1_btnPopup")
    public WebElement searchPickerAirtCratType;
    @FindBy(className = "ui-icon ui-icon ui-icon ui-icon icon-pushpin red")
    public WebElement pullMawbNumberIcon;
    @FindBy(id = "btnSaveDirectAWB")
    public WebElement saveAndCompleteActivityButton;
    @FindBy(id = "0_COSTFROMDESC")
    public WebElement selectSupplier;
    @FindBy(xpath = "//input[@id='0_CostQ']")
    public  WebElement enterCost;
    @FindBy(xpath = "//input[@id='0_RevQ']")
    public WebElement enterRevenue;
    @FindBy(xpath = "//input[@id='btnSaveNewcharges']")
    public WebElement saveAndCloseButton;


}
