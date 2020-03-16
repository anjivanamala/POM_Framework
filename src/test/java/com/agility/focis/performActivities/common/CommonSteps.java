package com.agility.focis.performActivities.common;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.CBR.JOBDETAILS;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommonSteps extends BaseSteps {
    private WebDriver driver;
    CommonPage commonPage;

    public CommonSteps() throws IOException {
        this.driver = getDriver();
        commonPage = new CommonPage(this.driver);

    }

    public void clickOnPerformActivityAndSwithToWindow(String activity) throws InterruptedException {

        commonPage.performActivity(activity).click();
        if (driver.findElements(By.xpath("//div[@aria-describedby ='alrtActivityPerform']//button[text() = 'OK']")).size() > 0) {
            commonPage.acceptAlrtActivityPerform.click();
        }

        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.setParentWindow(driver.getWindowHandle());
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void enterContract(String typeOfContract) throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForPageLoad();
        commonPage.contractInput.sendKeys("AutoContract");
        Select contractType = new Select(commonPage.carrierContractType);
        contractType.selectByVisibleText(typeOfContract);
    }

    public void verifyStatusOfActivities() {
    }
}
