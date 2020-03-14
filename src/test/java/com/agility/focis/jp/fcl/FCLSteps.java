package com.agility.focis.jp.fcl;

import com.agility.focis.base.BaseSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FCLSteps extends BaseSteps {
    public WebDriver driver;
    FCLPage fclPage;

    public FCLSteps() throws IOException {
        this.driver = getDriver();
        fclPage = new FCLPage(this.driver);

    }

    public void loginToApp() throws IOException, InterruptedException {
        String loginUrl = loginURL();
        driver = getDriver();
        driver.get(loginUrl);
        Thread.sleep(2000);
        driver.navigate().to("https://www.google.com/");
//        fclPage.searchInput.sendKeys("Hello");
        Thread.sleep(1000);
        fclPage.language("తెలుగు").click();
        Thread.sleep(1000);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
}
