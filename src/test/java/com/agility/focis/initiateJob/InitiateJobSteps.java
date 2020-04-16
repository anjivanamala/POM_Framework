package com.agility.focis.initiateJob;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.DropDownUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.agility.focis.utilities.testObject.TextBoxUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;

public class InitiateJobSteps extends BaseSteps {
    private WebDriver driver;
    InitiateJobPage initiateJobPage;

    public InitiateJobSteps() throws IOException {
        this.driver = getDriver();
        initiateJobPage = new InitiateJobPage(this.driver);

    }

    public void enterDataOnInitiatePageOne(String product, String productType, String jobScope, String originStakeholder, String destinationStakeholder) throws InterruptedException {

        initiateJobPage.OriginStakeholderInput.sendKeys(originStakeholder);
        Thread.sleep(1000);
        initiateJobPage.OriginStakeholderInput.sendKeys(Keys.ENTER);
        initiateJobPage.DestinationStakeholderInput.sendKeys(destinationStakeholder);
        Thread.sleep(1000);
        initiateJobPage.DestinationStakeholderInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        clickOnaButton("Next");
    }

    public void selectJobDistinguishers(String product, String productType, String jobScope) throws InterruptedException {
        Thread.sleep(1000);
        DropDownUtils.selectOptionByVisibleText(initiateJobPage.productDropDown, product);
        DropDownUtils.selectOptionByVisibleText(initiateJobPage.productTypeDropDown, productType);
        DropDownUtils.selectOptionByVisibleText(initiateJobPage.jobScopeDropDown, jobScope);
    }

    public void selectStakeholder(String stakeholderType, String stakeholderIdOrName) throws InterruptedException {
        initiateJobPage.searchIconUsingLable(stakeholderType).click();
        searchForSTK(stakeholderIdOrName);

    }

    public void selectIncoTerm(String incoTerm, String incoTermLocation) {
        DropDownUtils.selectOptionByVisibleText("Incoterm", incoTerm);
        TextBoxUtils.setText("Incoterm Location", incoTermLocation);
        GlobalVariables.setIncoterm(incoTerm);
        GlobalVariables.setIncoTermLocation(incoTermLocation);
    }

    public void selectMBL(String mblType, String mblTerms) {
        DropDownUtils.selectOptionByVisibleText("MBL Type", mblType);
        DropDownUtils.selectOptionByVisibleText("MBL Terms", mblTerms);
        HashMap<String, String> mblinfo = new HashMap<>();
        mblinfo.put("MBL Type", mblType);
        mblinfo.put("MBL Terms", mblTerms);
        GlobalVariables.setMblInformation(mblinfo);
    }

    public void selectSLBL(String sequestType) {
        DropDownUtils.selectOptionByVisibleText("Seaquest Type", sequestType);
    }

    public void selectOffice(String typeOfOffice, String country, String type, String networkComponent, String department, String isLive) throws InterruptedException {
        if (typeOfOffice.equalsIgnoreCase("Origin")) {
            GlobalVariables.setOriginOrgComponent(networkComponent, department);
        } else {
            GlobalVariables.setDestinationOrgComponent(networkComponent, department);
        }
        initiateJobPage.inlineSearchUsingLabel(typeOfOffice + " Office").clear();
        initiateJobPage.searchIconUsingLable(typeOfOffice + " Office").click();
        searchForOffice(country, type, networkComponent, department, isLive);
    }

    public void searchForOffice(String country, String type, String networkComponent, String department, String isLive) throws InterruptedException {
        boolean isOfficeSelected = false;
        for (int i = 0; i < 10; i++) {
            SeleniumUtils.waitForElementToVisible(initiateJobPage.isLive);
            DropDownUtils.selectOptionByVisibleText(initiateJobPage.isLive, isLive);
            initiateJobPage.countryCode.sendKeys(country);
            initiateJobPage.networkComponent.sendKeys(networkComponent);
            initiateJobPage.type.sendKeys(type);
            initiateJobPage.departmentName.sendKeys(department + Keys.ENTER);

            if (driver.findElements(By.xpath("//b[text() = 'No records to view']")).size() > 0) {
                initiateJobPage.refreshIcon.click();
                Thread.sleep(1000);
                searchForOffice(country, type, networkComponent, department, isLive);
            } else {
                Thread.sleep(2000);
                initiateJobPage.officebestMatch(country).click();
                isOfficeSelected = true;
                break;
            }

        }

        if (!isOfficeSelected) {
            initiateJobPage.closePopUpButton("Network Components").click();
        }

    }

    public void verifyJobInformation(String product, String productType, String jobScope) throws InterruptedException {
        SeleniumUtils.waitForElementToVisible(initiateJobPage.verifyjobscope);
        Assert.assertTrue(initiateJobPage.verifyproduct.getText().equalsIgnoreCase(product));
        Assert.assertTrue(initiateJobPage.verifyProductType.getText().equalsIgnoreCase(productType));
        Select jobscopedropdown = new Select(initiateJobPage.verifyjobscope);
        Assert.assertTrue(jobscopedropdown.getFirstSelectedOption().getText().equalsIgnoreCase(jobScope));
        SeleniumUtils.takeScreenshot();
        SeleniumUtils.logInfo("Job Number is: " + initiateJobPage.jobNumber.getText());
        GlobalVariables.setJobNumber(initiateJobPage.jobNumber.getText());
        GlobalVariables.setProduct(initiateJobPage.verifyproduct.getText());
        GlobalVariables.setProductType(initiateJobPage.verifyProductType.getText());
        GlobalVariables.setJobScope(jobscopedropdown.getFirstSelectedOption().getText());
        GlobalVariables.setJobStatus(initiateJobPage.jobStatus.getText());
    }

    public void slecteReferences() throws InterruptedException {
        initiateJobPage.shipperReferenceType.sendKeys("Packing List");
        Thread.sleep(1000);
        initiateJobPage.shipperReferenceType.sendKeys(Keys.ENTER);
        initiateJobPage.shipperReference.sendKeys("AutoShipper");
        initiateJobPage.consigneeReferenceType.sendKeys("Destination Collection");
        Thread.sleep(1000);
        initiateJobPage.consigneeReferenceType.sendKeys(Keys.ENTER);
        initiateJobPage.consigneeReference.sendKeys("AutoConsignee");
    }
}
