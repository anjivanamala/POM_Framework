package com.agility.focis.jp.initiateJob;

import com.agility.focis.base.BasePage;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitiateJobPage extends BasePage {

    public InitiateJobPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text() = 'Product']/../following-sibling::div//select")
    public WebElement productDropDown;
    @FindBy(xpath = "//span[text() = 'Product Type']/../following-sibling::div//select")
    public WebElement productTypeDropDown;
    @FindBy(xpath = "//span[text() = 'Job Scope']/../following-sibling::div//select")
    public WebElement jobScopeDropDown;
    @FindBy(xpath = "//span[text() = 'Origin Stakeholder']/../following-sibling::div//input")
    public WebElement OriginStakeholderInput;
    @FindBy(xpath = "//span[text() = 'Destination Stakeholder']/../following-sibling::div//input")
    public WebElement DestinationStakeholderInput;
    @FindBy(xpath = "//input[@name= 'STKNAMEANDADDRESS']")
    public WebElement stakeHolderNameOrID;

    //    Network Components
    @FindBy(id = "gs_CountryCode")
    public WebElement countryCode;
    @FindBy(id = "gs_LocationName")
    public WebElement networkComponent;
    @FindBy(id = "gs_NetworkFunctionName")
    public WebElement type;
    @FindBy(id = "gs_DepartmentName")
    public WebElement departmentName;
    @FindBy(id = "gs_IsLive")
    public WebElement isLive;

    public WebElement stkBestMatch(String stk) throws InterruptedException {
        SeleniumUtils.waitForNumberOfElementsToBeMoreThan(By.xpath("//a[contains(text(),'" + stk + "')]"), 0);
        WebElement element = null;
        if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Primary')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Primary')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));

        } else if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Collection')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Collection')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        } else if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Air WayBill')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Air WayBill')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        } else if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'EDI')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'EDI')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        } else {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - No') and contains(text(),'Primary')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        }
        return element;

    }

    public WebElement officebestMatch(String countrycode) {
        SeleniumUtils.waitForNumberOfElementsToBeMoreThan(By.xpath("//a[text() = '" + countrycode + "']"), 0);
        return driver.findElements(By.xpath("//td[@aria-describedby= 'pnlPopupGrid_CountryCode']/a[text() = '" + countrycode + "']")).get(0);
    }
}
