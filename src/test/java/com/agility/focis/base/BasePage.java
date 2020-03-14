package com.agility.focis.base;

import com.agility.focis.base.DriverInstantiation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "Login1_UserName")
    public WebElement userName;
    @FindBy(id = "Login1_Password")
    public WebElement password;
    @FindBy(id = "Login1_LoginButton")
    public WebElement signInButton;
    @FindBy(xpath = "//b[text() = 'No records to view']")
    public WebElement noRecordsToViewText;
    @FindBy(xpath = "//span[@class = 'ui-icon icon-refresh green']")
    public WebElement refreshIcon;


    public WebElement mainMenuOption(String mainMenuOption) {
        return driver.findElement(By.xpath("//a/span[text()='" + mainMenuOption + "']/.."));
    }

    public WebElement buttonTobeClicked(String button) {
        return driver.findElement(By.xpath("//button[text() = '" + button + "']"));
    }

    public WebElement childMenuOption(String mainMenuOption, String childMenuOption) {
        return driver.findElement(By.xpath("//a/span[text()='" + mainMenuOption + "']/../following-sibling::ul//span[text()='" + childMenuOption + "']/.."));
    }

    public WebElement searchIconUsingLable(String lable) {
        return driver.findElement(By.xpath("//span[text()='" + lable + "']/../following-sibling::div//button"));
    }

    public WebElement inlineSearchUsingLabel(String label) {
        return driver.findElement(By.xpath("//span[text()='" + label + "']/../following-sibling::div//input[@profiledatamember='DESCRIPTION']"));

    }

    public WebElement closePopUpButton(String popUpTitle) {
        return driver.findElement(By.xpath("//span[text() ='" + popUpTitle + "']/../button[@class = 'ui-dialog-titlebar-close']"));

    }

    public WebElement tab(String tabname) {
        return driver.findElement(By.xpath("//a[normalize-space(text())='" + tabname + "' and @data-toggle = 'tab']"));
    }

    public WebElement buttonOnPopupOrDialog(String dialogName, String buttonName) {
        return driver.findElement(By.xpath("//span[text() = '" + dialogName + "']/ancestor::div[@role = 'dialog']//button[text() = '" + buttonName + "']"));
    }

    @FindBy(xpath = "//span[contains(@id,'ProdName')]")
    public WebElement verifyproduct;
    @FindBy(xpath = "//span[contains(@id,'ProdTypeName')]")
    public WebElement verifyProductType;
    @FindBy(xpath = "//select[contains(@id,'JobScope')]")
    public WebElement verifyjobscope;
    @FindBy(xpath = "//span[contains(@id,'JobNumber')]")
    public WebElement jobNumber;
    @FindBy(xpath = "//span[contains(@id,'BookingDetailsFr1_BookingDetailsFr1_lblStatusName')]")
    public WebElement jobStatus;

    //    Auto Suggestion from Inline Search Popup
    public WebElement inlineSearchRecommendations(String text) {
        return driver.findElement(By.xpath("//ul/li/a[contains(text(),'" + text + "')]"));
    }

    //    iframe Locators
    @FindBy(xpath = "//div[contains(@class ,'iframe')]//a[@title = 'Close']")
    public WebElement closeIframeButton;

    //TextBox
    public WebElement searchPickerInputBox(String columnName) {
        columnName = columnName.replaceAll(" ", "");
        return driver.findElement(By.xpath("//input[contains(@id,'" + columnName + "')]"));
    }

}

