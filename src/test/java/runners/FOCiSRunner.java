package runners;


import Base.DriverInstantiation;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Base.DriverInstantiation.getDriver;
import static Base.DriverInstantiation.setDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/agility/focis/jp/fcl", tags = {"@gui"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report2",
        "json:target/cucumber-report2/cucumber.json",
        "rerun:target/cucumber-report2/rerun.txt"
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/html/ExtentReport.html "
},
        glue = "com.agility.focis")


public class FOCiSRunner extends DriverInstantiation {

public static WebDriver driver;
    @Before
    public void launchBRowser() throws IOException {
        setDriver();
        String loginUrl = loginURL();
        driver = getDriver();
        driver.get(loginUrl);
    }
    @AfterClass
    public static void generateACucmberReport() {
    File reportOutputDirectory = new File("target");
    List<String> jsonFiles = new ArrayList<String>();
jsonFiles.add("target/cucumber-report2/cucumber.json");

    String buildNumber = "1";
    String projectName = "cucumberProject";

    Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration - check javadoc for details
configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
// do not make scenario failed when step has status SKIPPED
configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
configuration.addClassifications("Platform","Windows");
configuration.addClassifications("Browser","Firefox");
configuration.addClassifications("Branch","release/1.0");

//    // optionally add metadata presented on main page via properties file
//    List<String> classificationFiles = new ArrayList<String>();
//classificationFiles.add("properties-1.properties");
//classificationFiles.add("properties-2.properties");
//configuration.addClassificationFiles(classificationFiles);

    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    Reportable result = reportBuilder.generateReports();
}
@After
    public static void killdriver(){
        driver.quit();
    System.out.println("Hello");
}
}
