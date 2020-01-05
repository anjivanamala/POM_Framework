package com.agility.focis.jp.fcl;

import com.agility.focis.base.BasePage;
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
}
