package com.agility.focis.base;

import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.DynamicTableUtils;
import com.agility.focis.utilities.testObject.HyperLinkUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public void selectMenu(String childMenu, String mainMenu) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        basePage.mainMenuOption(mainMenu).click();
        basePage.childMenuOption(mainMenu, childMenu).click();
        SeleniumUtils.waitForPageLoad();
    }

    public void selectMenu(String childSubMenu, String childMenu, String mainMenu) throws InterruptedException {
        Actions actions = new Actions(driver);
        SeleniumUtils.waitForPageLoad();
        basePage.mainMenuOption(mainMenu).click();
        actions.moveToElement(basePage.childMenuOption(mainMenu, childMenu)).build().perform();
        basePage.childSubMenuOption(mainMenu, childMenu, childSubMenu).click();
        SeleniumUtils.waitForPageLoad();
    }

    public void clickOnaButton(String button) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.buttonTobeClicked(button));
        basePage.buttonTobeClicked(button).click();

    }


    public void clickOnTab(String tabName) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.tab(tabName));
        basePage.tab(tabName).click();
        SeleniumUtils.waitForPageLoad();
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

    public void acceptWarningIfPopulated(String warningMessage) throws InterruptedException {
        if (driver.findElements(By.xpath("//p[text() = '" + warningMessage + "']/ancestor::div[@role = 'dialog' and contains(@style,'display: block;')]")).size() > 0) {
            SeleniumUtils.waitForElementToBeClickable(basePage.okButtonWarning(warningMessage));
            basePage.okButtonWarning(warningMessage).click();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", basePage.okButtonWarning(warningMessage));
        }

    }

    public boolean isDialogPopulated(String dialog) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        boolean flag = false;
        if (driver.findElements(By.xpath("//span[text() ='" + dialog + "']/ancestor::div[@role='dialog' and contains(@style,'display: block;')]")).size() != 0) {
            flag = true;
        }

        return flag;
    }

    public boolean isDialogPopulated(String dialog, String warningMesage) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        boolean flag = false;
        if (driver.findElements(By.xpath("//span[text() ='" + dialog + "']/ancestor::div[@role='dialog' and contains(@style,'display: block;')]//p[contains(text(),'" + warningMesage + "')]")).size() != 0) {
            flag = true;
        }

        return flag;
    }

    public void navigateToTasksScreen() throws InterruptedException {
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("bookingdetailsfrpg")) {

            clickOnTab("Tasks");
        } else if (currentURL.contains("advancedsearchfrpg")) {

        } else if (currentURL.contains("estimatesfrpg")) {

        } else if (currentURL.contains("stakeholderfrpg")) {

        } else if (currentURL.contains("dashboard")) {

            DynamicTableUtils.setText("JobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.paginationCount);
            if (driver.findElements(By.xpath("//a[text() = '" + GlobalVariables.getJobNumber() + "']")).size() > 0) {

                driver.findElements(By.xpath("//a[text() = '" + GlobalVariables.getJobNumber() + "']")).get(0).click();
            } else {

//                fromMenu(GlobalVariable.JobNumber)
//                clickOnJobDetailsIcon(GlobalVariable.JobNumber)
//                navigateToTasksScreen()
            }
        } else {

            SeleniumUtils.switchToParentWindow();
            navigateToTasksScreen();
        }
        SeleniumUtils.waitForPageLoad();

        clickOnTab("Tasks");
    }

    public void navigateToDashboard() throws InterruptedException {
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("dashboard")) {

            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.paginationCount);
            Select pagenationDropwDown = new Select(basePage.paginationCount);
            pagenationDropwDown.selectByVisibleText("50");
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
        } else if (currentURL.contains("bookingdetailsfrpg") || currentURL.contains("advancedsearchfrpg") || currentURL.contains("stakeholderfrpg") || currentURL.contains("default")) {

            selectMenu("Dashboard", "Job");
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.paginationCount);
            Select pagenationDropwDown = new Select(basePage.paginationCount);
            pagenationDropwDown.selectByVisibleText("50");
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
        } else {

            SeleniumUtils.switchToParentWindow();
            navigateToDashboard();
        }
    }

    public void validateCompletedTasksOrEvents() {
        List<String> nonCompletedActivitiesDashboard = new ArrayList<>();
        List<String> nonCompletedActivitiesTasks = new ArrayList<>();
        if (driver.getCurrentUrl().contains("dashboard")) {
//            nonCompletedActivitiesDashboard = dashboard.EventsAndActivitiesValidations.getNonCompletedEventsOrActivities(GlobalVariables.getList());
//            nonCompletedActivitiesTasks = tasks.Activity.getNonCompletedEventsOrActivities(GlobalVariables.getList());
        }
//        else {
//            nonCompletedActivitiesTasks = tasks.Activity.getNonCompletedEventsOrActivities(GlobalVariables.getList())
//            nonCompletedActivitiesDashboard = dashboard.EventsAndActivitiesValidations.getNonCompletedEventsOrActivities(GlobalVariables.getList());
//        }
//
//        if (nonCompletedActivitiesTasks.size() > 0 || nonCompletedActivitiesDashboard.size() > 0) {
//            KeywordUtil.logInfo("Below Activities are not Completed\n")
//            KeywordUtil.logInfo("Dashboard: \n")
//            for (int i = 0; i < nonCompletedActivitiesDashboard.size(); i++) {
//
//                KeywordUtil.logInfo(GlobalVariables.getList().get(i))
//            }
//            KeywordUtil.logInfo("Tasks Screen: \n")
//            for (int j = 0; j < nonCompletedActivitiesTasks.size(); j++) {
//
//                KeywordUtil.logInfo(GlobalVariables.getList().get(j))
//            }
//            KeywordUtil.markFailed("")
//        } else {
//            KeywordUtil.logInfo("Below Activities are Completed at both End Points")
//            for (int i = 0; i < GlobalVariables.getList().size(); i++) {
//                KeywordUtil.logInfo(GlobalVariables.getList().get(i))
//            }
//        }
//    }
    }

    public void navigateToFinancialScreen() {
    }

    public void navigateToFinancialScreen(String JobNumber) throws InterruptedException {
        selectMenu("Advanced Search", "Job");
        basePage.advancedSearchInputBox.sendKeys(JobNumber + Keys.ENTER);
        DynamicTableUtils.clickOnIconUsingReferenceData("OperationalJobNumber", JobNumber, "coins");
        SeleniumUtils.switchToNewWindow();
    }

    public void selectCurrency(String currency) throws InterruptedException {
        basePage.currencyCodeInputBox.sendKeys(currency + Keys.ENTER);
        HyperLinkUtils.clickOnLink(currency);
        SeleniumUtils.waitForPageLoad();
    }
}
