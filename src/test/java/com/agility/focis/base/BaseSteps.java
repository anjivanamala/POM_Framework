package com.agility.focis.base;

import com.agility.focis.base.DriverInstantiation;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseSteps extends DriverInstantiation {
    private WebDriver driver;
    BasePage basePage;


    public BaseSteps() throws IOException {
        if (getDriver() == null) {
            setDriver();
        }
        this.driver = getDriver();
        basePage = new BasePage(this.driver);
    }

    public void loginToApp() throws IOException, InterruptedException {
        driver = getDriver();
        driver.get(loginURL());
        driver.manage().window().maximize();
        basePage.userName.sendKeys(getUserName());
        basePage.password.sendKeys(getPassword());
        basePage.signInButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void selectMenu(String childMenu, String mainMenu) {
        basePage.mainMenuOption(mainMenu).click();
        basePage.childMenuOption(mainMenu, childMenu).click();
    }

    public void clickOnaButton(String button) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.buttonTobeClicked(button));
        basePage.buttonTobeClicked(button).click();

    }


    public void clickOnTab(String tabName) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.tab(tabName));
        basePage.tab(tabName).click();
    }

    public void closePopupWindow(String popUPName) {
        basePage.closePopUpButton(popUPName).click();
    }

    public void clickOnAButtonOnDialoOrPopup(String popuName, String buttonName) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.buttonOnPopupOrDialog(popuName, buttonName));
        basePage.buttonOnPopupOrDialog(popuName, buttonName).click();
    }

    public void enterValuesOnSearchPicker(Map<String, String> searchAttributes) {
        Set<String> keys = searchAttributes.keySet();
        for (String key : keys) {
            basePage.searchPickerInputBox(key).sendKeys(searchAttributes.get(key) + Keys.ENTER);
        }
    }

    public void searchForSTK(String stkName) throws InterruptedException {
        boolean IsSTKSelected = false;
        for (int i = 0; i < 10; i++) {
            basePage.stakeHolderNameOrID.sendKeys(stkName + Keys.ENTER);
            SeleniumUtils.waitForElementToBeClickable(basePage.refreshIcon);
            if (driver.findElements(By.xpath("//b[text() = 'No records to view']")).size() > 0) {
                basePage.refreshIcon.click();
                SeleniumUtils.waitForElementToBeClickable(basePage.refreshIcon);
                searchForSTK(stkName);
            } else {

                basePage.stkBestMatch(stkName).click();
                IsSTKSelected = true;
                break;
            }
        }
        if (!IsSTKSelected) {
            SeleniumUtils.waitForElementToBeClickable(basePage.closePopUpButton("Stakeholders"));
            basePage.closePopUpButton("Stakeholders").click();
        }
    }
}
