package com.agility.focis.purchaseInvoiceAndCredit;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

//        pivPage.currencyButton.click();
//        selectCurrency(currency);
        pivPage.pivCurrencyTetBox.sendKeys(currency);
//        Thread.sleep(1000);
//        pivPage.pivCurrencyTetBox.sendKeys(Keys.ENTER);

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

    public void verifySupplierInvoiceNumber() throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        if (!pivPage.supplierInvoiceNumAllocatePage.getText().equalsIgnoreCase(GlobalVariables.getSuppierinvoiceNum())) {

            SeleniumUtils.logInfo("Supplier Invoice Number is not matched Expected is :" + GlobalVariables.getSuppierinvoiceNum() + "\n Actual is :" + pivPage.supplierInvoiceNumAllocatePage.getText());
        }


    }

    public void verifySupplierName() {
        if (!SpanUtils.getText("Supplier Name").equalsIgnoreCase(GlobalVariables.getSupplierName())) {

            SeleniumUtils.logInfo("Supplier Name is not matched Expected is :" + GlobalVariables.getSupplierName() + "\n Actual is :" + SpanUtils.getText("Supplier Name"));
        }
    }

    public void processPIV(String jobNumber, String pivType) throws InterruptedException {
        pivPage.allocateToJobsORConsolButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.jobNumberOrConsolNumberInput.sendKeys(jobNumber + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        String PIVAmount = "0.00";
        String taxAmount = "0.00";
        if (pivType.equalsIgnoreCase("Purchase Invoice")) {
            PIVAmount = getAmountsFromChargesToBeAllocated("Positive").get("Net PIV Amount");
            taxAmount = getAmountsFromChargesToBeAllocated("Positive").get("Tax Amount");
        } else {
            PIVAmount = getAmountsFromChargesToBeAllocated("Negative").get("Net PIV Amount");
            taxAmount = getAmountsFromChargesToBeAllocated("Negative").get("Tax Amount");
        }
        pivPage.closeDialogButton("Allocate Jobs for Supplier Invoice number : ").click();
        pivPage.pivAmount.sendKeys(Keys.CONTROL + Keys.chord("a"));
        pivPage.pivAmount.sendKeys(Keys.DELETE);
        pivPage.pivAmount.sendKeys(PIVAmount);

        pivPage.taxAmount.sendKeys(Keys.CONTROL + Keys.chord("a"));
        pivPage.taxAmount.sendKeys(Keys.DELETE);
        pivPage.taxAmount.sendKeys(taxAmount);

        pivPage.savePIVButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.allocateToJobsORConsolButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.jobNumberOrConsolNumberInput.sendKeys(jobNumber + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();

        List<WebElement> chargesToSelect;
        if (pivType.equalsIgnoreCase("Purchase Invoice")) {
            chargesToSelect = getPositiveOrNegativeCharges("Positive");
        } else {
            chargesToSelect = getPositiveOrNegativeCharges("Negative");
        }
        for (WebElement charge : chargesToSelect) {
            charge.findElement(By.xpath(".//input[@role='checkbox']")).click();
        }
        pivPage.allocateButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.completeInvoiceButton.click();
        SeleniumUtils.waitForPageLoad();
        String pivNumber = pivPage.generatedPIVNumber(GlobalVariables.getSuppierinvoiceNum()).getText();
        String supplierName = pivPage.generatedPIVSupplierName(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivTotalAmount = pivPage.generatedPIVTotalAmount(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivDate = pivPage.generatedPIVDate(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivDueDate = pivPage.generatedPIVDueDate(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivStatus = pivPage.generatedPIVStatus(GlobalVariables.getSuppierinvoiceNum()).getText();
        SeleniumUtils.logInfo("PIV Number is: " + pivNumber + "\nSupplier Invoice Number: " + GlobalVariables.getSuppierinvoiceNum() + "\nPIV Total Amount: " + pivTotalAmount
                + "\nPIV Date: " + pivDate + "\nPIV Due Date: " + pivDueDate + "\nSupplier Name: " + supplierName + "\nStatus: " + pivStatus);
    }

    public Map<String, Map<String, String>> getAmountInfoTable() {
        Map<String, String> amountInfoRows = new HashMap<>();
        Map<String, Map<String, String>> amountInfo = new HashMap<>();
        List<WebElement> rows = pivPage.amountInfoTable.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        for (WebElement row : rows) {
            String rowLabel = row.findElement(By.xpath(".//td[@aria-describedby='grdAmountInfoPopup_Label']")).getText();
            amountInfoRows.put("PIV Amount", row.findElement(By.xpath(".//td[@aria-describedby='grdAmountInfoPopup_PIVAmount']")).getText());
            amountInfoRows.put("Tax Amount", row.findElement(By.xpath(".//td[@aria-describedby='grdAmountInfoPopup_TaxAmount']")).getText());
            amountInfoRows.put("Total Amount", row.findElement(By.xpath(".//td[@aria-describedby='grdAmountInfoPopup_TotalAmount']")).getText());
            amountInfoRows.put("Currency", row.findElement(By.xpath(".//td[@aria-describedby='grdAmountInfoPopup_Currency']")).getText());
            amountInfo.put(rowLabel, amountInfoRows);
        }

        return amountInfo;
    }

    public Map<String, String> getAmountsFromChargesToBeAllocated(String typeOfCharges) {
        Map<String, String> amounts = new HashMap<>();
        double cost = 0.00;
        double pivAmount = 0.00;
        double taxAmount = 0.00;
        double supplierTaxAmount = 0.00;
        double totalAmount = 0.00;
        List<WebElement> charges = getPositiveOrNegativeCharges(typeOfCharges);
        for (WebElement charge : charges) {
            cost = cost + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_AmountB')]")).getText());
            pivAmount = pivAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText());
            taxAmount = taxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountB')]")).getText());
            supplierTaxAmount = supplierTaxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value"));
            totalAmount = totalAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText());
        }
        amounts.put("Cost", String.format("%.2f", cost));
        amounts.put("Net PIV Amount", String.format("%.2f", pivAmount));
        amounts.put("Tax Amount", String.format("%.2f", taxAmount));
        amounts.put("Supplier Tax Amount", String.format("%.2f", supplierTaxAmount));
        amounts.put("Total Amount", String.format("%.2f", totalAmount));

        return amounts;
    }


    public List<WebElement> getPositiveOrNegativeCharges(String typeOfCharges) {
        List<WebElement> jobs = pivPage.JobsList.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> positiveCharges = new ArrayList<>();
        List<WebElement> negativeCharges = new ArrayList<>();
        List<WebElement> listToReturn = new ArrayList<>();
        for (WebElement job : jobs) {
            List<WebElement> charges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));

            for (WebElement charge : charges) {
                if (charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_AmountB')]")).getText().contains("-")) {
                    negativeCharges.add(charge);
                } else {
                    positiveCharges.add(charge);
                }

            }

        }
        if (typeOfCharges.equalsIgnoreCase("Positive")) {
            listToReturn = positiveCharges;
        } else {
            listToReturn = negativeCharges;
        }
        return listToReturn;
    }
}
