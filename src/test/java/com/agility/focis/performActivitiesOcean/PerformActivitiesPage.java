package com.agility.focis.performActivitiesOcean;

import com.agility.focis.base.BasePage;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformActivitiesPage extends BasePage {

    public PerformActivitiesPage(WebDriver driver) {
        super(driver);
    }

    //    ---------------------------------------------Common Locators for Activities---------------------------------------------
    public WebElement performActivity(String activityName) {
        return driver.findElement(By.xpath("//td[text()='" + activityName + "']/preceding-sibling::td//div[@title ='Perform Activity']/span[contains(@class,'pencil')]"));
    }

    @FindBy(xpath = "//div[@aria-describedby ='alrtActivityPerform']//button[text() = 'OK']")
    public WebElement acceptAlrtActivityPerform;

    @FindBy(id = "txtCarrFilingRef")
    public WebElement contractInput;

    @FindBy(xpath = "//select[contains(@id,'CarrierContract') and @selected = 'selected']")
    public WebElement carrierContractType;

//-------------------------------------------------  More Links Locators ----------------------------------------

    @FindBy(id = "btnJobMoreLinks")
    public WebElement moreLinksButton;
    @FindBy(xpath = "//iframe[contains(@src,'bookingdeatilslinksfrpg')]")
    public WebElement moreLinksIframe;

    public WebElement moreLinks_linkToBeClicked(String text) {
        return driver.findElement(By.xpath("//ul[@id = 'ulSideMenuBar']//a[text() = '" + text + "']"));
    }

    public WebElement fobSearchButton(String jobNumber, String transactionType) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'TransactionType') and text() = '" + transactionType + "']/following-sibling::td[contains(@aria-describedby,'Criteria') and text() = 'Original']/preceding-sibling::td[contains(@aria-describedby,'FobId')]//span"));
    }

    public WebElement xmlDataLink(String transactionType) {
        return driver.findElement(By.xpath("//span[text() ='" + transactionType + "']/following-sibling::span/a[text() = 'XML Data']"));
    }

    @FindBy(id = "xmlRawDataOutput")
    public WebElement xmlRawData;

//-------------------------------------------------  CBR Locators -----------------------------------------------

    public WebElement referenceSearchButton(String stakeholderType) {
        return driver.findElement(By.xpath("//legend[text()='" + stakeholderType + "']/ancestor::div[1]//span[text()='Reference']/ancestor::div[1]//button"));
    }

    public WebElement partyName(String partyType) {
        return driver.findElement(By.xpath("//legend[contains(text() , '" + partyType + "')]/ancestor::div[1]//span[text() = 'Name']/ancestor::div[1]//input[@holdername = 'CarierBookingFrHolder']"));

    }

    public WebElement partyAddress(String partyType) {
            return driver.findElement(By.xpath("//legend[contains(text() , '" + partyType + "')]/ancestor::div[1]//span[text() = 'Address']/ancestor::div[1]//textarea"));
    }

    @FindBy(xpath = "//div[text() = 'Reference Type']/ancestor::tr//input")
    public WebElement selectAllReferences;
    @FindBy(xpath = "//span[@class='ui-icon icon-save purple']")
    public WebElement saveReferences;

    @FindBy(xpath = "//input[@value='Complete']")
    public WebElement completeButton;
    @FindBy(xpath = "//div[@role = 'dialog' and not(@aria-describedby='AutomaticPrealert')]//button[text()= 'Ok']")
    public WebElement alertButtonToComplete;
    @FindBy(xpath = "//p[text() = 'To view the document, please click on Print button.']/../../..//button[contains(text() , 'OK')]")
    public WebElement alertButtonToPrint;
    @FindBy(xpath = "//input[@id='btnEDI']")
    public WebElement ediButton;
    @FindBy(xpath = "//div[@role = 'dialog' and @aria-describedby='alrtdialog']//button[text()=' OK ']")
    public WebElement clickOnSuccessOkButton;

}
