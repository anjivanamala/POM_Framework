package com.agility.focis.utilities.testObject;

import com.agility.focis.base.DriverInstantiation;
import org.openqa.selenium.By;

public class HyperLinkUtils extends DriverInstantiation {
    public static void clickOnLink(String linkText) {
        driver.findElement(By.xpath("//a[text()='" + linkText + "']")).click();
    }
}
