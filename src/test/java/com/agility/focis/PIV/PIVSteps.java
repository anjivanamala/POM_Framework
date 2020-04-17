package com.agility.focis.PIV;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Map;

public class PIVSteps extends BaseSteps {
    private WebDriver driver;
    PIVPage pivPage;

    public PIVSteps() throws IOException {
        this.driver = getDriver();
        pivPage = new PIVPage(this.driver);

    }

    public void createPIVHeader(Map<String, String> pivHeaderDetails) throws InterruptedException {
        GlobalVariables.setOriginOrgComponent("Mumbai", "Ocean Export");
        String invoiceType = pivHeaderDetails.get("Invoice Type");
        String invoiceSubType = pivHeaderDetails.get("Invoice SubType");
        String entityCode = pivHeaderDetails.get("Entity Code");
        String supplierName = pivHeaderDetails.get("Supplier Name");
        GlobalVariables.setSupplierName(supplierName);
        String supplierInvoiceDate = pivHeaderDetails.get("Supplier Invoice Date");
        String pivAmount = pivHeaderDetails.get("PIV Amount");
        String taxAmount = pivHeaderDetails.get("Tax Amount");
        String currency = pivHeaderDetails.get("Currency");
        SeleniumUtils.waitForElementToBeClickable(pivPage.createNewPIVButton);
        pivPage.createNewPIVButton.click();
        SeleniumUtils.waitForElementToBeClickable(pivPage.legalEntitySearchButton);
        pivPage.legalEntitySearchButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.entityCodeSearchBox.sendKeys(entityCode);
        Thread.sleep(1000);
        pivPage.entityCodeSearchBox.sendKeys(Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink(entityCode);

        Select orgComponentDropDown = new Select(pivPage.orgComponent);
        orgComponentDropDown.selectByVisibleText(GlobalVariables.getOriginOrgComponent());
        if (entityCode.equalsIgnoreCase("5910")) {
            pivPage.placeOfSupplySearchButton.click();
            DynamicTableUtils.typeTextOnSearchPickerPopup("DataCode", "AP");
            Thread.sleep(1000);
            HyperLinkUtils.clickOnLink("AP");
        }
        pivPage.supplierNameSearchButton.click();
        searchForSTK(supplierName);
        GlobalVariables.setSuppierinvoiceNum(SeleniumUtils.getCurrentTimeStampAsStrng());
        pivPage.invoiceNum.sendKeys(GlobalVariables.getSuppierinvoiceNum());

        Select invoiceTypeDropDown = new Select(pivPage.invoiceType);
        invoiceTypeDropDown.selectByVisibleText(invoiceType);

        Select invoiceSubTypeDropDown = new Select(pivPage.invoiceSubType);
        invoiceSubTypeDropDown.selectByVisibleText(invoiceSubType);

        pivPage.invoiceDateButton.click();
        pivPage.currentDateAsInvoiceDate.click();

        pivPage.pivAmount.sendKeys(pivAmount);
        pivPage.taxAmount.sendKeys(taxAmount);

        pivPage.currencyButton.click();
        pivPage.currencyCode.sendKeys(currency);
        Thread.sleep(1000);
        pivPage.currencyCode.sendKeys(Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink(currency);

        pivPage.createPIVButton.click();
        SeleniumUtils.waitForPageLoad();

    }

    public void verifyPIVHeader(Map<String, String> pivHeaderDetails) {
        GlobalVariables.setOriginOrgComponent("Mumbai", "Ocean Export");
        String invoiceType = pivHeaderDetails.get("Invoice Type");
        String invoiceSubType = pivHeaderDetails.get("Invoice SubType");
        String entityCode = pivHeaderDetails.get("Entity Code");
        String supplierName = pivHeaderDetails.get("Supplier Name");
        String supplierInvoiceDate = pivHeaderDetails.get("Supplier Invoice Date");
        String pivAmount = pivHeaderDetails.get("PIV Amount");
        String taxAmount = pivHeaderDetails.get("Tax Amount");
        String currency = pivHeaderDetails.get("Currency");
        Select orgComp = new Select(pivPage.orgComponent);
        Assert.assertTrue(orgComp.getFirstSelectedOption().getText().equalsIgnoreCase(GlobalVariables.getOriginOrgComponent()));
        Assert.assertTrue(pivPage.invoiceNum.getAttribute("value").equalsIgnoreCase(GlobalVariables.getSuppierinvoiceNum()));
        Assert.assertTrue(TextBoxUtils.getText("Supplier Name").equalsIgnoreCase(supplierName));
    }

    public void verifySupplierInvoiceNumber() {
        if(!pivPage.supplierInvoiceNumAllocatePage.getText().equalsIgnoreCase(GlobalVariables.getSuppierinvoiceNum())){

            SeleniumUtils.logInfo("Supplier Invoice Number is not matched Expected is :"+GlobalVariables.getSuppierinvoiceNum()+"\n Actual is :"+pivPage.supplierInvoiceNumAllocatePage.getText());
        }


    }

    public void verifySupplierName() {
        if(!SpanUtils.getText("Supplier Name").equalsIgnoreCase(GlobalVariables.getSupplierName())){

            SeleniumUtils.logInfo("Supplier Name is not matched Expected is :"+GlobalVariables.getSupplierName()+"\n Actual is :"+SpanUtils.getText("Supplier Name"));
        }
    }
}
