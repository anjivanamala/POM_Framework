package runners;

import Base.DriverInstantiation;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestNgRunner extends DriverInstantiation {
    public static WebDriver driver;
    @BeforeMethod
    public void launchBRowser() throws IOException {
        setDriver();
        String loginUrl = loginURL();
        driver = getDriver();
        driver.get(loginUrl);
    }
    @Test
    public void AddCharges() throws InterruptedException {
        driver.navigate().to("https://focisagile.agility.com/login.aspx");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text() = 'User Name : ']/..//input")).sendKeys("Exportjob");
        driver.findElement(By.xpath("//label[text() = 'Password : ']/..//input")).sendKeys("q");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
        Thread.sleep(5000);
        driver.navigate().to("https://focisagile.agility.com/pages/focisja/operatorview/estimatesfrpg.aspx?q=cGFnZWlkfEVzdGltYXRlc0ZyUGcmYWN0aW9uaWR8TGlzdEVtcHR5RXN0aW1hdGVzVmlldyZhY3Rpb25jcml0ZXJpYXxKb2JOdW1iZXIrJTNkKzEzMDIyMSZuZXh0YWN0aW9uY3JpdGVyaWF8Sm9iTnVtYmVyKyUzZCsxMzAyMjEmSXNQb3B1cFBhZ2V8ZmFsc2UmVXNlckxhbmd1YWdlfCY%3d-zltj%2bJTo%2fI8%3d");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//td[@id='btnPIVRequest']//span")).click();
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]")));
        List<WebElement> charges = driver.findElements(By.xpath("//table[@id = 'grdEstimatesChargesLs']/tbody/tr/td[@aria-describedby='grdEstimatesChargesLs_AmountQ' and not(contains(.,'-'))]/.."));
        System.out.println(charges.get(2).findElement(By.xpath("td[@aria-describedby='grdEstimatesChargesLs_ChargeName']")).getText());
        charges.get(2).findElement(By.id("DeleteCharge")).click();
        System.out.println(charges.get(1).findElement(By.xpath("td[@aria-describedby='grdEstimatesChargesLs_ChargeName']")).getText());
        charges.get(1).findElement(By.id("DeleteCharge")).click();
//        for(int i =0;i<charges.size();i++){
//            charges.get(i).findElement(By.xpath(""));
//            System.out.println(charges.get(i).findElement(By.xpath("//td[@aria-describedby='grdEstimatesChargesLs_ChargeName']")).getText());
//        }

    }
    @Test
    public void generateACucmberReport() {
        File reportOutputDirectory = new File("target/demo");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber-report2/cucumber.json");

        String buildNumber = "101";
        String projectName = "Live Demo Project";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        // points to the demo trends which is not used for other tests
//        configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
