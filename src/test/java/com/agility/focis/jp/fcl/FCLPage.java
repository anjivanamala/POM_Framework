package com.agility.focis.jp.fcl;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FCLPage extends BasePage {
    public WebDriver driver;

    public FCLPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@title = 'Search']")
    public WebElement searchInput;
    @FindBy(xpath = "Google apps")
    public WebElement googleApps;

    public WebElement menu(String menuOption) {
        return this.driver.findElement(By.xpath("//span[text() ='" + menuOption + "']/.."));
    }

    public WebElement language(String language) {
        return this.driver.findElement(By.xpath("//*[text() = '" + language + "']"));
    }
}
