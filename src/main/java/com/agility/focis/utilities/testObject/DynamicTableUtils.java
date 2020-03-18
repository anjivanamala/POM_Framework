package com.agility.focis.utilities.testObject;

import com.agility.focis.base.DriverInstantiation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class DynamicTableUtils extends TextBoxUtils {
    private static WebElement elementToGetTextFrom(String referenceColumnName, String referenceData, String columnToGetTextFrom) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'" + referenceColumnName + "') and text() = '" + referenceData + "']/../td[contains(@aria-describedby,'" + columnToGetTextFrom + "')]"));
    }

    private static WebElement textBoxInTable(String columnName) {

        return driver.findElement(By.xpath("//table//input[contains(@name, '" + columnName + "')]"));
    }


    public static String getText(String referenceColumnName, String referenceData, String columnToGetTextFrom) {
        return elementToGetTextFrom(referenceColumnName, referenceData, columnToGetTextFrom).getText();
    }

    public static void typeTextOnSearchPickerPopup(String columnName, String text) {
        columnName = columnName.replaceAll(" ", "");
        driver.findElement(By.xpath("//table//input[contains(@name , '" + columnName + "')]")).clear();
        driver.findElement(By.xpath("//table//input[contains(@name , '" + columnName + "')]")).sendKeys(text);

    }

    public static void clickOnIconUsingReferenceData(String referenceColumn, String referenceData, String colour) throws InterruptedException {
        referenceColumn = referenceColumn.replaceAll(" ", "");
        driver.findElement(By.xpath("//td[contains(@aria-describedby,'" + referenceColumn + "') and text() = '" + referenceData + "']/..//*[contains(@class,'" + colour + "')]")).click();
        SeleniumUtils.waitForPageLoad();
    }
}
