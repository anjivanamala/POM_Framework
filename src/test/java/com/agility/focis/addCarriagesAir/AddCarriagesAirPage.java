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
    @FindBy(xpath = "//iframe[contains(@src,'routesearchafmainfrpg')]")
    public WebElement addAirportToAirportFrame;
    @FindBy(id = "drpJobTypes")
    public WebElement jobTypeDropdown;
    @FindBy(xpath = "//button[@id='drpJobTypes']/..//li[@id='liBackToBack']")
    public WebElement jobTypeBackToBack;
    @FindBy(xpath = "//div[@id='alertMsgBox']/..//button[text()=' OK ']")
    public WebElement jobTypeChangeAlert;
    @FindBy(xpath = "//input[contains(@id,'txtCarrierList')]")
    public WebElement Carrier;
    @FindBy(id = "txtFlightNumber_1")
    public WebElement FlightNumber;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortAOD_1')]")
    public WebElement Aod;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortAOA_1')]")
    public WebElement Aoa;
    @FindBy(xpath = "//input[contains(@id,'_txtFlSchViaPortETD_1')]")
    public WebElement EtdDate;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortETDTime_1')]")
    public WebElement EtdTime;
    @FindBy(xpath = "//input[contains(@id,'_txtFlSchViaPortETA_1')]")
    public WebElement EtaDate;
    @FindBy(xpath = "//input[contains(@id,'txtFlSchViaPortETATime_1')]")
    public WebElement EtaTime;
    @FindBy(xpath = "//option[@value='Cargo']/../../select[@id='ddlViaPortAircraftType_1']")
    public WebElement selectAirCraftType;
    @FindBy(id = "txtViaPortAirCraft_1_btnPopup")
    public WebElement searchPickerAirtCratType;
    @FindBy(xpath = "//div[@title = 'Pull available MAWB Number']/span")
    public WebElement pullMawbNumberIcon;
    @FindBy(id = "btnSaveDirectAWB")
    public WebElement saveAndCompleteActivityButton;
    @FindBy(xpath = "//iframe[contains(@src,'estimatesactfrpg.aspx')]")
    public WebElement iFrameEstimationscreen;
    @FindBy(id = "0_COSTFROMSEARCH")
    public WebElement Supplier;
    @FindBy(xpath = "//input[@id='0_CostQ']")
    public  WebElement enterCost;
    @FindBy(xpath = "//input[@id='0_RevQ']")
    public WebElement enterRevenue;
    @FindBy(xpath = "//input[@id='btnSaveNewcharges']")
    public WebElement saveAndCloseButton;


}
