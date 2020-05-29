package com.agility.focis.purchaseInvoiceAndCredit;

import com.agility.focis.financial.FinancialSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PIVSteps extends FinancialSteps {
    private WebDriver driver;
    PIVPage pivPage;

    public PIVSteps() throws IOException {
        this.driver = getDriver();
        pivPage = new PIVPage(this.driver);

    }

    public void selectEntityCode(String entityCode) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(pivPage.legalEntitySearchButton);
        pivPage.legalEntitySearchButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.entityCodeSearchBox.sendKeys(entityCode);
        Thread.sleep(1000);
        pivPage.entityCodeSearchBox.sendKeys(Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink(entityCode);
        GlobalVariables.setEntityName(pivPage.entityName.getAttribute("value"));
        GlobalVariables.setEntityCode(entityCode);
    }

    public void selectOrgComponent(String OrgComponent) throws InterruptedException {
        Select orgComponentDropDown = new Select(pivPage.orgComponent);
        orgComponentDropDown.selectByVisibleText(OrgComponent);


        if (GlobalVariables.getEntityCode().equalsIgnoreCase("5910")) {
            pivPage.placeOfSupplySearchButton.click();
            DynamicTableUtils.typeTextOnSearchPickerPopup("DataCode", "AP");
            Thread.sleep(1000);
            HyperLinkUtils.clickOnLink("AP");
        }
    }

    public void selectSupplier(String supplierName) throws InterruptedException {
        pivPage.supplierNameSearchButton.click();
        searchForSTK(supplierName);
    }

    public void enterInvoiceNumber(String invoiceNumber) throws InterruptedException {
        GlobalVariables.setSuppierinvoiceNum(invoiceNumber);
        SeleniumUtils.waitForElementToBeClickable(pivPage.invoiceNum);
        pivPage.invoiceNum.sendKeys(invoiceNumber);
    }

    public void selectInvoiceType(String invoiceType) {
        Select invoiceTypeDropDown = new Select(pivPage.invoiceType);
        invoiceTypeDropDown.selectByVisibleText(invoiceType);
    }

    public void selectInvoiceSubType(String invoiceSubType) {
        Select invoiceSubTypeDropDown = new Select(pivPage.invoiceSubType);
        invoiceSubTypeDropDown.selectByVisibleText(invoiceSubType);
        GlobalVariables.setInvoiceSubType(invoiceSubType);
    }

    public void selectInvoiceDate(String supplierInvoiceDate) throws InterruptedException {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentDay = calendar.get(Calendar.DATE);
        pivPage.invoiceDateButton.click();
        String pivDate = pivPage.pivDate.getText().split("-")[0];

        if (!(supplierInvoiceDate.equalsIgnoreCase("Today") || supplierInvoiceDate.equalsIgnoreCase("Current Date"))) {
            int intNoOfDays = Integer.parseInt(supplierInvoiceDate.split(" ")[2]);
            String sign = supplierInvoiceDate.split(" ")[1];
            if (sign.equalsIgnoreCase("-") && intNoOfDays > currentDay) {
                pivPage.prevMonth.click();
                SeleniumUtils.waitForPageLoad();
                int IntSupplierInvoiceDate = Integer.parseInt(supplierInvoiceDate.split("-")[1].replaceAll(" ", ""));
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) - IntSupplierInvoiceDate + 30);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            } else if (sign.equalsIgnoreCase("+") && intNoOfDays > (30 - currentDay)) {
                pivPage.nextMonth.click();
                SeleniumUtils.waitForPageLoad();
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) + intNoOfDays - 30);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            } else if (sign.equalsIgnoreCase("+")) {
                SeleniumUtils.waitForPageLoad();
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) + intNoOfDays);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            } else if (sign.equalsIgnoreCase("-")) {
                SeleniumUtils.waitForPageLoad();
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) - intNoOfDays);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            }

        } else {
            pivPage.currentDateAsInvoiceDate.click();
        }

    }


    public void enterPIVAmount(String pivAmount) {
        SeleniumUtils.clearText(pivPage.pivAmount);
        pivPage.pivAmount.sendKeys(pivAmount);
    }

    public void enterTaxAmount(String taxAmount) {
        if (!GlobalVariables.getInvoiceSubType().equalsIgnoreCase("Duties and Taxes")) {
            pivPage.taxAmount.click();
            SeleniumUtils.clearText(pivPage.taxAmount);
            pivPage.taxAmount.sendKeys(taxAmount);
            pivPage.taxAmount.sendKeys(Keys.TAB);
        }
    }

    public void createPIVHeader(Map<String, String> pivHeaderDetails) throws InterruptedException {
        String invoiceType = pivHeaderDetails.get("Invoice Type");
        GlobalVariables.setInvoiceType(invoiceType);
        String invoiceSubType = pivHeaderDetails.get("Invoice SubType");
        GlobalVariables.setInvoiceSubType(invoiceSubType);
        String entityCode = pivHeaderDetails.get("Entity Code");
        GlobalVariables.setEntityCode(entityCode);
        String OrgComponent;
        if (pivHeaderDetails.containsKey("Org Component")) {
            OrgComponent = pivHeaderDetails.get("Org Component");
        } else {
            if (GlobalVariables.getJobScope().contains("Destination")) {
                OrgComponent = GlobalVariables.getDestinationOrgComponent();

            } else {
                OrgComponent = GlobalVariables.getOriginOrgComponent();

            }
        }

        String supplierName = pivHeaderDetails.get("Supplier Name");
        GlobalVariables.setSupplierName(supplierName);
        String supplierInvoiceDate = pivHeaderDetails.get("Supplier Invoice Date");
        String pivAmount = pivHeaderDetails.get("PIV Amount");
        String taxAmount = pivHeaderDetails.get("Tax Amount");
        String currency = pivHeaderDetails.get("Currency");

        if (!driver.getCurrentUrl().contains("managepivfrpg")) {
            SeleniumUtils.waitForElementToBeClickable(pivPage.createNewPIVButton);
            pivPage.createNewPIVButton.click();
        }

        selectEntityCode(entityCode);

        selectOrgComponent(OrgComponent);

        selectSupplier(supplierName);

        enterInvoiceNumber(SeleniumUtils.getCurrentTimeStampAsStrng());

        selectInvoiceType(invoiceType);

        selectInvoiceSubType(invoiceSubType);

        selectInvoiceDate(supplierInvoiceDate);

        enterPIVAmount(pivAmount);

        enterTaxAmount(taxAmount);

        selectInvoiceCurrency(currency);

        pivPage.createPIVButton.click();
        SeleniumUtils.waitForPageLoad();

    }

    public void selectInvoiceCurrency(String currency) throws InterruptedException {
        pivPage.currencyButton.click();
        selectCurrency(currency);
        SeleniumUtils.waitForPageLoad();
    }

    public void verifyPIVHeader(Map<String, String> pivHeaderDetails) {
        String invoiceType = pivHeaderDetails.get("Invoice Type");
        String invoiceSubType = pivHeaderDetails.get("Invoice SubType");
        String entityCode = pivHeaderDetails.get("Entity Code");
        String OrgComponent;
        if (pivHeaderDetails.containsKey("Org Component")) {
            OrgComponent = pivHeaderDetails.get("Org Component");
        } else {
            if (GlobalVariables.getJobScope().contains("Destination")) {
                OrgComponent = GlobalVariables.getDestinationOrgComponent();

            } else {
                OrgComponent = GlobalVariables.getOriginOrgComponent();

            }
        }
        String supplierName = pivHeaderDetails.get("Supplier Name");
        String supplierInvoiceDate = pivHeaderDetails.get("Supplier Invoice Date");
        String invoiceDate = SeleniumUtils.getEffectiveDateAfterDays(0);
        if (!(supplierInvoiceDate.equalsIgnoreCase("Today") || supplierInvoiceDate.equalsIgnoreCase("Current Date"))) {
            int intNoOfDays = Integer.parseInt(supplierInvoiceDate.split(" ")[2]);
            String sign = supplierInvoiceDate.split(" ")[1];
            if (sign.equalsIgnoreCase("+")) {
                invoiceDate = SeleniumUtils.getEffectiveDateAfterDays(intNoOfDays);
            } else {
                invoiceDate = SeleniumUtils.getEffectiveDateBeforeDays(intNoOfDays);
            }
        }

        String pivAmount = pivHeaderDetails.get("PIV Amount");
        String taxAmount = pivHeaderDetails.get("Tax Amount");
        String currency = pivHeaderDetails.get("Currency");
        Select orgComp = new Select(pivPage.orgComponent);
        if (!pivPage.entityName.getAttribute("value").equalsIgnoreCase(GlobalVariables.getEntityName())) {
            SeleniumUtils.logInfo("\nEntity Name:\nExpected :" + GlobalVariables.getEntityName() + "\nActual :" + pivPage.entityName.getAttribute("value"));
        }
        if (!orgComp.getFirstSelectedOption().getText().equalsIgnoreCase(OrgComponent)) {
            SeleniumUtils.logInfo("\nOrg Components :\nExpected :" + OrgComponent + "\nActual :" + orgComp.getFirstSelectedOption().getText());
        }
        if (!supplierName.equalsIgnoreCase(pivPage.supplier.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nSupplier Name :\nExpected :" + supplierName + "\nActual :" + pivPage.supplier.getAttribute("value"));
        }
        if (!GlobalVariables.getSuppierinvoiceNum().equalsIgnoreCase(pivPage.invoiceNum.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nSupplier Invoice Number :\nExpected :" + GlobalVariables.getSuppierinvoiceNum() + "\nActual :" + pivPage.invoiceNum.getAttribute("value"));
        }
        if (!invoiceDate.equalsIgnoreCase(pivPage.invoiceDate.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nSupplier Invoice Date :\nExpected :" + invoiceDate + "\nActual :" + pivPage.invoiceDate.getAttribute("value"));
        }
        if (!pivPage.pivDate.getText().equalsIgnoreCase(SeleniumUtils.getEffectiveDateAfterDays(0))) {
            SeleniumUtils.logInfo("\nPIV Date :\nExpected :" + SeleniumUtils.getEffectiveDateAfterDays(0) + "\nActual :" + pivPage.pivDate.getText());
        }
        Select pivDropDown = new Select(pivPage.invoiceType);
        if (!invoiceType.equalsIgnoreCase(pivDropDown.getFirstSelectedOption().getText())) {
            SeleniumUtils.logInfo("\nPIV Type :\nExpected :" + invoiceType + "\nActual :" + pivDropDown.getFirstSelectedOption().getText());
        }
        Select pivSubTypeDropDown = new Select(pivPage.invoiceSubType);
        if (!invoiceSubType.equalsIgnoreCase(pivSubTypeDropDown.getFirstSelectedOption().getText())) {
            SeleniumUtils.logInfo("\nInvoice Sub Type :\nExpected :" + invoiceSubType + "\nActual :" + pivSubTypeDropDown.getFirstSelectedOption().getText());
        }
        if (!String.format("%.2f", Double.parseDouble(pivAmount)).equalsIgnoreCase(pivPage.pivAmount.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nPIV Amount :\nExpected :" + String.format("%.2f", Double.parseDouble(pivAmount)) + "\nActual :" + pivPage.pivAmount.getAttribute("value"));
        }
        if (!String.format("%.2f", Double.parseDouble(taxAmount)).equalsIgnoreCase(pivPage.taxAmount.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nTax Amount :\nExpected :" + String.format("%.2f", Double.parseDouble(taxAmount)) + "\nActual :" + pivPage.taxAmount.getAttribute("value"));
        }
        if (!currency.equalsIgnoreCase(pivPage.pivCurrencyTetBox.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nCurrency Code :\nExpected :" + currency + "\nActual :" + pivPage.pivCurrencyTetBox.getAttribute("value"));
        }
        String totalAmount = String.format("%.2f", Double.parseDouble(pivAmount) + Double.parseDouble(taxAmount));

        if (!totalAmount.equalsIgnoreCase(pivPage.totalAmount.getText())) {
            SeleniumUtils.logInfo("\nTotal Amount:\nExpected :" + totalAmount + "\nActual :" + pivPage.totalAmount.getText());
        }

    }

    public void verifySupplierInvoiceNumber() throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        if (!pivPage.supplierInvoiceNumAllocatePage.getText().equalsIgnoreCase(GlobalVariables.getSuppierinvoiceNum())) {

            SeleniumUtils.logInfo("\nSupplier Invoice Number\nExpected :" + GlobalVariables.getSuppierinvoiceNum() + "\n Actual :" + pivPage.supplierInvoiceNumAllocatePage.getText());
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

        updatedPIVAmountAndTaxAmount();

        pivPage.allocateToJobsORConsolButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.jobNumberOrConsolNumberInput.sendKeys(jobNumber + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        selectCharges();
        pivPage.allocateButton.click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(pivPage.completeInvoiceButton);
        pivPage.completeInvoiceButton.click();
        SeleniumUtils.waitForPageLoad();
        searchForPurchaseInvoice(GlobalVariables.getSupplierName(), GlobalVariables.getInvoiceType(), GlobalVariables.getInvoiceSubType(), GlobalVariables.getSuppierinvoiceNum(), GlobalVariables.getEntityCode());
        String pivNumber = pivPage.generatedPIVNumber(GlobalVariables.getSuppierinvoiceNum()).getText();
        String supplierName = pivPage.generatedPIVSupplierName(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivTotalAmount = pivPage.generatedPIVTotalAmount(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivDate = pivPage.generatedPIVDate(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivDueDate = pivPage.generatedPIVDueDate(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivStatus = pivPage.generatedPIVStatus(GlobalVariables.getSuppierinvoiceNum()).getText();
        SeleniumUtils.logInfo("PIV Number is: " + pivNumber + "\nSupplier Invoice Number: " + GlobalVariables.getSuppierinvoiceNum() + "\nPIV Total Amount: " + pivTotalAmount
                + "\nPIV Date: " + pivDate + "\nPIV Due Date: " + pivDueDate + "\nSupplier Name: " + supplierName + "\nStatus: " + pivStatus);
    }

    public void updatedPIVAmountAndTaxAmount() throws InterruptedException {
        String PIVAmount = "0.00";
        String taxAmount = "0.00";
        if (GlobalVariables.getInvoiceType().equalsIgnoreCase("Purchase Invoice")) {
            PIVAmount = getAmountsFromChargesToBeAllocated("Positive").get("Net PIV Amount");
            taxAmount = getAmountsFromChargesToBeAllocated("Positive").get("Tax Amount");
        } else {
            PIVAmount = getAmountsFromChargesToBeAllocated("Negative").get("Net PIV Amount");
            taxAmount = getAmountsFromChargesToBeAllocated("Negative").get("Tax Amount");
        }
        pivPage.closeDialogButton("Allocate Jobs for Supplier Invoice number : ").click();
        SeleniumUtils.clearText(pivPage.pivAmount);
        pivPage.pivAmount.sendKeys(PIVAmount);
        SeleniumUtils.clearText(pivPage.taxAmount);
        pivPage.taxAmount.sendKeys(taxAmount);
        pivPage.savePIVButton.click();
        SeleniumUtils.waitForPageLoad();

    }

    public Map<String, Map<String, String>> getAmountInfoTable() {
        Map<String, String> amountInfoRows = new HashMap<>();
        Map<String, Map<String, String>> amountInfo = new HashMap<>();
        List<WebElement> rows = pivPage.amountInfoTable.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        for (WebElement row : rows) {
            String rowLabel = row.findElement(By.xpath(".//td[contains(@aria-describedby,'Label')]")).getText();
            amountInfoRows.put("PIV Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'PIVAmount')]")).getText());
            amountInfoRows.put("Tax Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TaxAmount')]")).getText());
            amountInfoRows.put("Total Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TotalAmount')]")).getText());
            amountInfoRows.put("Currency", row.findElement(By.xpath(".//td[contains(@aria-describedby,'Currency')]")).getText());
            amountInfo.put(rowLabel, amountInfoRows);
        }

        return amountInfo;
    }

    public Map<String, Map<String, String>> getAmountInfoAllocateTable() {
        Map<String, Map<String, String>> amountInfo = new HashMap<>();
        List<WebElement> rows = pivPage.amountInfoTableAllocateJobs.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        for (WebElement row : rows) {
            Map<String, String> amountInfoRows = new HashMap<>();
            String rowLabel = row.findElement(By.xpath(".//td[contains(@aria-describedby,'Label')]")).getAttribute("title");
            amountInfoRows.put("PIV Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'PIVAmount')]")).getText());
            amountInfoRows.put("Tax Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TaxAmount')]")).getText());
            amountInfoRows.put("Total Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TotalAmount')]")).getText());
            amountInfoRows.put("Currency", row.findElement(By.xpath(".//td[contains(@aria-describedby,'Currency')]")).getText());
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
            cost = cost + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_AmountB')]")).getText().replaceAll(",", ""));
            pivAmount = pivAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText().replaceAll(",", ""));
            taxAmount = taxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountB')]")).getText().replaceAll(",", ""));
            supplierTaxAmount = supplierTaxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value").replaceAll(",", ""));
            totalAmount = totalAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText().replaceAll(",", "")
            );
        }
//        Put all amounts to map
        amounts.put("Cost", String.format("%.2f", cost));
        amounts.put("Net PIV Amount", String.format("%.2f", pivAmount));
        amounts.put("Tax Amount", String.format("%.2f", taxAmount));
        amounts.put("Supplier Tax Amount", String.format("%.2f", supplierTaxAmount));
        amounts.put("Total Amount", String.format("%.2f", totalAmount));

        return amounts;
    }


    public List<WebElement> getPositiveOrNegativeCharges(String typeOfCharges) {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
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

    public void searchForPurchaseInvoice(String supplierName, String pivType, String pivSubType, String supplierInvoiceNumber, String entityCode) throws InterruptedException {
        expandPanel("Search Companion");
//        pivPage.supplierNameSearchButton.click();
//        SeleniumUtils.waitForPageLoad();
//        searchForSTK(supplierName);
        SeleniumUtils.clearText(pivPage.supplierInvoiceNumberSearchCompanion);
        pivPage.supplierInvoiceNumberSearchCompanion.sendKeys(supplierInvoiceNumber);
        Select pivTypeDropDown = new Select(pivPage.pivTypeSearchCompanion);
        pivTypeDropDown.selectByVisibleText(pivType);
        Select pivSubTypeDropDown = new Select(pivPage.pivSubtypeSearchCompanion);
        pivSubTypeDropDown.selectByVisibleText(pivSubType);
        pivPage.legalEntitySearchButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.entityCodeSearchBox.sendKeys(entityCode);
        Thread.sleep(1000);
        pivPage.entityCodeSearchBox.sendKeys(Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink(entityCode);
        SeleniumUtils.waitForPageLoad();
        pivPage.searchButtonManagePIV.click();
        SeleniumUtils.waitForPageLoad();

    }

    public void clickOnCreateNewPIVIcon() throws InterruptedException {
        pivPage.createNewPIVButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void verifyInvoiceStatus(String invoiceStatus) {
        if (!invoiceStatus.equalsIgnoreCase(pivPage.invoiceStatus.getText().trim())) {
            SeleniumUtils.logInfo("\nInvoice Status Populated Incorrectly\nExpected :" + invoiceStatus + "\nActual :" + pivPage.invoiceStatus.getText());
        }
    }

    public void verifyStateAndPlaceOfSupplyArePopulated() {
        Assert.assertFalse(pivPage.orgStateComponent.getAttribute("style").contains("none"));
        Assert.assertFalse(pivPage.placeOfSupplyDiv.getAttribute("style").contains("none"));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyBankReferenceStatus(String enabledStatus) {
        if (enabledStatus.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue(pivPage.bankReference.isEnabled());
        } else {
            Assert.assertFalse(pivPage.bankReference.isEnabled());
        }
        SeleniumUtils.takeScreenshot();
    }

    public void verifypivDueDate(String stepDefPiVDueDate) {
        int intNoOfDays = Integer.parseInt(stepDefPiVDueDate.split(" ")[2]);
        String pivDueDate = SeleniumUtils.getEffectiveDateAfterDays(intNoOfDays);
        Assert.assertTrue("Expected :" + pivDueDate + "\nActual :" + pivPage.pivDueDate.getText(), pivDueDate.equalsIgnoreCase(pivPage.pivDueDate.getText()));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyTaxAmountStatus(String enabledStatus) {
        if (enabledStatus.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue(pivPage.taxAmount.isEnabled());
        } else {
            Assert.assertFalse(pivPage.taxAmount.isEnabled());
        }
        SeleniumUtils.takeScreenshot();
    }

    public void verifyTotalAmount(String totalAmount) {
        Assert.assertTrue("Expected :" + String.format("%.2f", Double.parseDouble(totalAmount)) + "\nActual :" + pivPage.totalAmount.getText(), String.format("%.2f", Double.parseDouble(totalAmount)).equalsIgnoreCase(pivPage.totalAmount.getText()));
        SeleniumUtils.takeScreenshot();
    }

    public void verifySupplierAddress() {
        String expected = GlobalVariables.getSupplierAddress().replace(GlobalVariables.getSupplierAddress().split("\n")[0], "").replaceAll("\n", "").replaceAll(" ", "");
        String actual = pivPage.supplierAddress.getText().replaceAll("\n", "").replaceAll(" ", "");
        System.out.println(expected);
        System.out.println(actual);
        Assert.assertTrue(expected.equalsIgnoreCase(actual));
    }

    public void selectTaxAtHeader() {
        pivPage.taxAtHeader.click();
    }

    public void verifyPIVAmountStatus(String enabledStatus) {
        if (enabledStatus.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue(pivPage.pivAmount.isEnabled());
        } else {
            Assert.assertFalse(pivPage.pivAmount.isEnabled());
        }
        SeleniumUtils.takeScreenshot();
    }

    public void verifyCurrencyInAmountInfoTable(String currency) {
        Assert.assertTrue(getAmountInfoTable().get("Header Amount").get("Currency").equalsIgnoreCase(currency));
        Assert.assertTrue(getAmountInfoTable().get("Allocated Amount").get("Currency").equalsIgnoreCase(currency));
        Assert.assertTrue(getAmountInfoTable().get("To be Allocated Amount").get("Currency").equalsIgnoreCase(currency));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyRowDataAmountInfoTable(String row, String PIVAmount, String TaxAmount, String TotalAmount, String Currency) {
        Assert.assertTrue(getAmountInfoTable().get(row).get("PIV Amount").equalsIgnoreCase(PIVAmount));
        Assert.assertTrue(getAmountInfoTable().get(row).get("Tax Amount").equalsIgnoreCase(TaxAmount));
        Assert.assertTrue(getAmountInfoTable().get(row).get("Total Amount").equalsIgnoreCase(TotalAmount));
        Assert.assertTrue(getAmountInfoTable().get(row).get("Currency").equalsIgnoreCase(Currency));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyRowDataAmountInfoTableAllocatePage(String row, String PIVAmount, String TaxAmount, String Currency) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        if (PIVAmount.contains("Sum")) {
            PIVAmount = getSumOfPIVAmountsOfSelectedChargesAsString();
            TaxAmount = getSumOfTaxAmountsOfSelectedChargesAsString();
        } else if (PIVAmount.contains("-") || PIVAmount.contains("Difference")) {
            String headerPIVAmount = getAmountInfoAllocateTable().get("Header Amount").get("PIV Amount");
            String allocatedPIVAmount = getSumOfPIVAmountsOfSelectedChargesAsString();
            PIVAmount = String.format("%.2f", Double.parseDouble(headerPIVAmount) - Double.parseDouble(allocatedPIVAmount));
            String headerTaxAmount = getAmountInfoAllocateTable().get("Header Amount").get("Tax Amount");
            String allocatedTaxAmount = getSumOfTaxAmountsOfSelectedChargesAsString();
            TaxAmount = String.format("%.2f", Double.parseDouble(headerTaxAmount) - Double.parseDouble(allocatedTaxAmount));
        }

        String TotalAmount = String.format("%.2f", Double.parseDouble(PIVAmount) + Double.parseDouble(TaxAmount));

        Assert.assertTrue("PIV Amount Expected :" + Double.parseDouble(PIVAmount) + "\nActual ;" + getAmountInfoAllocateTable().get(row).get("PIV Amount"), getAmountInfoAllocateTable().get(row).get("PIV Amount").equalsIgnoreCase(String.format("%.2f", Double.parseDouble(PIVAmount))));
        Assert.assertTrue("Tax Amount Expected :" + Double.parseDouble(TaxAmount) + "\nActual :" + getAmountInfoAllocateTable().get(row).get("Tax Amount"), getAmountInfoAllocateTable().get(row).get("Tax Amount").equalsIgnoreCase(String.format("%.2f", Double.parseDouble(TaxAmount))));
        Assert.assertTrue("Total Amount Expected :" + Double.parseDouble(TotalAmount) + "\nActual :" + getAmountInfoAllocateTable().get(row).get("Total Amount"), getAmountInfoAllocateTable().get(row).get("Total Amount").equalsIgnoreCase(String.format("%.2f", Double.parseDouble(TotalAmount))));
        Assert.assertTrue("Currency Expected :" + Currency + "\nActual :" + getAmountInfoAllocateTable().get(row).get("Currency"), getAmountInfoAllocateTable().get(row).get("Currency").equalsIgnoreCase(Currency));
        SeleniumUtils.takeScreenshot();
    }

    private String getSumOfTaxAmountsOfSelectedChargesAsString() {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        double sumofTaxAmounts = 0.00;
        for (WebElement job : jobs) {
            List<WebElement> selectedCharges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow') and @aria-selected = 'true']"));

            for (WebElement charge : selectedCharges) {
                sumofTaxAmounts = sumofTaxAmounts + Double.parseDouble(charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value"));
            }

        }
        return String.format("%.2f", sumofTaxAmounts);
    }

    private String getSumOfPIVAmountsOfSelectedChargesAsString() {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        double sumofPIVAmounts = 0.00;
        for (WebElement job : jobs) {
            List<WebElement> selectedCharges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow') and @aria-selected = 'true']"));

            for (WebElement charge : selectedCharges) {
                sumofPIVAmounts = sumofPIVAmounts + Double.parseDouble(charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText());
            }

        }
        return String.format("%.2f", sumofPIVAmounts);
    }


    public void verifyListedChargesforSupplier(String supplier) {
        Map<String, String> expected = getChargesOfASupplier(supplier);
        Map<String, String> actual = getListOfCharges();
        Assert.assertEquals(expected, actual);


    }

    public Map<String, String> getListOfCharges() {
        Map<String, String> mapToReturn = new HashMap<>();
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        for (WebElement job : jobs) {
            List<WebElement> charges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));

            for (WebElement charge : charges) {
                String chargeName = charge.findElement(By.xpath("./td[contains(@aria-describedby,'ChargeName')]")).getText();
                String cost = charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_AmountQ')]")).getText();
                mapToReturn.put(chargeName, cost);
            }

        }
        return mapToReturn;
    }

    public void enterJobNumber(String jobNumber) throws InterruptedException {
        pivPage.jobNumberOrConsolNumberInput.sendKeys(jobNumber + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
    }

    public void verifyTaggedJobDetails(String jobNumber, String originSTKName, String destinationSTKName, String jobStatus) {
        String jobNumberActual = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_OpJobNumber')]")).getText();
        String shipperActual = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_Shipper')]")).getText();
        String consigneeActual = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_Consignee')]")).getText();
        String finStatus = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_JobFinStatus')]")).getText();
        Assert.assertTrue("Job Number Expected :" + jobNumber + "\nActual :" + jobNumberActual, jobNumber.equalsIgnoreCase(jobNumberActual));
        Assert.assertTrue("Shipper Expected :" + originSTKName + "\nActual :" + shipperActual, originSTKName.equalsIgnoreCase(shipperActual));
        Assert.assertTrue("Consignee Expected :" + destinationSTKName + "\nActual :" + consigneeActual, destinationSTKName.equalsIgnoreCase(consigneeActual));
        Assert.assertTrue("Financial Status Expected :" + jobStatus + "\nActual :" + finStatus, jobStatus.equalsIgnoreCase(finStatus));
    }

    public void selectCharges() {
        List<WebElement> chargesToSelect;
        if (GlobalVariables.getInvoiceType().equalsIgnoreCase("Purchase Invoice")) {
            chargesToSelect = getPositiveOrNegativeCharges("Positive");
        } else {
            chargesToSelect = getPositiveOrNegativeCharges("Negative");
        }
        for (WebElement charge : chargesToSelect) {
            charge.findElement(By.xpath(".//input[@role='checkbox']")).click();
        }
    }

    public void modifyTaxCodeForACharge() throws InterruptedException {
        List<WebElement> charges = getCharges();
        int randomNum = ThreadLocalRandom.current().nextInt(0, charges.size() - 1);
        String pivAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
        String taxAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        String taxRate = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatRatePer')]")).getText();
        String taxCode = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//input")).getAttribute("value");
        String totalAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText();

        charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//button")).click();
        SeleniumUtils.waitForPageLoad();
        List<WebElement> taxCodes = driver.findElements(By.xpath("//td[@aria-describedby='grdTaxCodeData_VatRate' and not(@title='" + taxRate.replace("%", "") + "')]/..//a"));
        int randomTaxCodeIndex = ThreadLocalRandom.current().nextInt(0, taxCodes.size() - 1);
        taxCodes.get(randomTaxCodeIndex).click();
        SeleniumUtils.waitForPageLoad();
        String modifiedTaxCode = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//input")).getAttribute("value");
        String modifiedTaxRate = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatRatePer')]")).getText();
        System.out.println("Charge Index is :" + randomNum);
        System.out.println("Random Index is :" + randomTaxCodeIndex);
        System.out.println("Tax Code is :" + taxCode);
        System.out.println("Modified Tax Code is :" + modifiedTaxCode);
        Map<String, String> chargeDetails = new HashMap<>();
        chargeDetails.put("index", String.valueOf(randomNum));
        chargeDetails.put("pivAmount", pivAmount);
        chargeDetails.put("taxAmount", taxAmount);
        chargeDetails.put("taxRate", taxRate);
        chargeDetails.put("taxCode", taxCode);
        chargeDetails.put("modifiedTaxCode", modifiedTaxCode);
        chargeDetails.put("modifiedTaxRate", modifiedTaxRate);
        chargeDetails.put("totalAmount", totalAmount);
        GlobalVariables.setRandomChargeDetails(chargeDetails);

    }

    public void verifyAmountsOfTaxModifiedCharge() throws InterruptedException {
        List<WebElement> charges = getCharges();
        Map<String, String> chargeDetails = GlobalVariables.getRandomChargeDetails();
        int chargeIndex = Integer.parseInt(chargeDetails.get("index"));
        double pivAmountOld = Double.parseDouble(chargeDetails.get("pivAmount"));
        int taxRateOld = Integer.parseInt(chargeDetails.get("modifiedTaxRate").replace("%", ""));
        String taxCodeOld = chargeDetails.get("modifiedTaxCode");
        double expTaxAmount = (pivAmountOld * taxRateOld) / 100;
        double expTotalAmount = pivAmountOld + expTaxAmount;
//        String strExpTotalAmount = String.format("%.2f", expTotalAmount);

        String pivAmount = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
        String taxAmount = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        String taxRate = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatRatePer')]")).getText();
        String taxCode = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//input")).getAttribute("value");
        String totalAmount = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText();

        Assert.assertTrue("PIV Amount Expected :" + String.format("%.2f", pivAmountOld) + "\nActual :" + pivAmount, pivAmount.equalsIgnoreCase(String.format("%.2f", pivAmountOld)));
        Assert.assertTrue("Tax Amount Expected :" + String.format("%.2f", expTaxAmount) + "\nActual :" + taxAmount, taxAmount.equalsIgnoreCase(String.format("%.2f", expTaxAmount)));
        Assert.assertTrue("Total Amount Expected :" + String.format("%.2f", expTotalAmount) + "\nActual :" + totalAmount, totalAmount.equalsIgnoreCase(String.format("%.2f", expTotalAmount)));
        Assert.assertTrue("Tax Rate Expected :" + String.valueOf(taxRateOld) + "\nActual :" + taxRate, taxRate.equalsIgnoreCase(String.valueOf(taxRateOld) + "%"));
        Assert.assertTrue("Total Code Expected :" + taxCodeOld + "\nActual :" + taxCode, taxCodeOld.equalsIgnoreCase(taxCode));
    }

    public void modifySupplierTaxAmountForACharge() {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> NonZeroTaxRatedCharges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]//td[contains(@aria-describedby,'t_VatRatePer') and not(@title='0%')]/ancestor::tr[1]"));
        int randomNum = ThreadLocalRandom.current().nextInt(0, NonZeroTaxRatedCharges.size() - 1);

        String pivAmount = NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();

        SeleniumUtils.clearText(NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")));
        NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).sendKeys("6.00" + Keys.TAB);

        Assert.assertTrue("User is not able to modify Supplier Tax Amounts", NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value").equalsIgnoreCase("6.00"));

        Map<String, String> chargeDetails = new HashMap<>();
        chargeDetails.put("pivAmount", pivAmount);
        chargeDetails.put("index", String.valueOf(randomNum));
        GlobalVariables.setRandomChargeDetails(chargeDetails);
    }

    public void verifyTotalAmountAfterModifyinSupplierTaxAmount() {
        Map<String, String> chargeDetails = GlobalVariables.getRandomChargeDetails();
        double pivAmount = Double.parseDouble(chargeDetails.get("pivAmount"));
        int chargeIndex = Integer.parseInt(chargeDetails.get("index"));
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> NonZeroTaxRatedCharges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]//td[contains(@aria-describedby,'t_VatRatePer') and not(@title='0%')]/ancestor::tr[1]"));
        double totalAmount = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText());
        double expTotalAmount = pivAmount + 6.00;
        Assert.assertEquals("Total Amount Expected :" + expTotalAmount + "\nActual :" + totalAmount, expTotalAmount, totalAmount, 0.0);
    }

    public void verifytaxAmtDiffAfterSuppTaxModification() {
        Map<String, String> chargeDetails = GlobalVariables.getRandomChargeDetails();
        int chargeIndex = Integer.parseInt(chargeDetails.get("index"));
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> NonZeroTaxRatedCharges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]//td[contains(@aria-describedby,'t_VatRatePer') and not(@title='0%')]/ancestor::tr[1]"));
        double taxAmt = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountB')]")).getText());
        double supplierTaxAmt = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value"));
        double taxAmtDiff = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountDiffB')]")).getText());
        double expectedDiff = supplierTaxAmt - taxAmt;
        Assert.assertEquals("Total Amount Expected :" + expectedDiff + "\nActual :" + taxAmtDiff, expectedDiff, taxAmtDiff, 0.0);

    }

    public void applyWriteOffForACharge() throws InterruptedException {
        List<WebElement> charges = getCharges();
        int randomNum = ThreadLocalRandom.current().nextInt(0, charges.size() - 1);
        String pivAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
        String taxAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        String totalAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText();
        double tobePIVedAmount = performWriteOffForGivenCharge(charges.get(randomNum));

        Map<String, String> chargeDetails = new HashMap<>();
        chargeDetails.put("index", String.valueOf(randomNum));
        chargeDetails.put("pivAmount", pivAmount);
        chargeDetails.put("taxAmount", taxAmount);
        chargeDetails.put("totalAmount", totalAmount);
        chargeDetails.put("tobePIVedAmount", String.format("%.2f", tobePIVedAmount));
        GlobalVariables.setRandomChargeDetails(chargeDetails);
    }

    public double performWriteOffForGivenCharge(WebElement charge) throws InterruptedException {
        charge.findElement(By.xpath(".//div[@title='Variations']//span[@class='i-icon icon-external-link']")).click();
        SeleniumUtils.waitForPageLoad();
        double cost = Double.parseDouble(pivPage.costWriteOffDialog.getAttribute("value"));
        double random = 0.00;
        if (cost > 0.00) {
            random = ThreadLocalRandom.current().nextDouble(1.00, cost);
        } else {
            random = ThreadLocalRandom.current().nextDouble(cost, -1.00);
        }
        SeleniumUtils.clearText(pivPage.tobePIVedAmount);
        pivPage.tobePIVedAmount.sendKeys(String.format("%.2f", random) + Keys.TAB);

        Select writeOffReasonCode = new Select(pivPage.writeOffReasonCode);
        writeOffReasonCode.selectByVisibleText("Others");
        SeleniumUtils.waitForPageLoad();
        pivPage.saveButtonWriteOff.click();
        SeleniumUtils.checkForAlertAndAccept();
        return random;

    }

    public void verifyTotalAmountAfterWriteOff() {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> charges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        int chargeIndex = Integer.parseInt(GlobalVariables.getRandomChargeDetails().get("index"));
        double tobePIVedAmount = Double.parseDouble(GlobalVariables.getRandomChargeDetails().get("tobePIVedAmount"));
        double totalAmount = Double.parseDouble(charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText());
        Assert.assertEquals("Total Amount Expected :" + tobePIVedAmount + "\nActual :" + totalAmount, tobePIVedAmount, totalAmount, 0.0);

    }

    public List<WebElement> getCharges() throws InterruptedException {
        List<WebElement> listToReturn;
        if (isDialogPopulated("Allocate Jobs for Supplier Invoice number : ")) {
            List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
            listToReturn = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        } else {
            List<WebElement> jobs = pivPage.jobsList.findElements(By.xpath(".//table[contains(@id,'grdSavedPIVDetails')]"));
            listToReturn = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        }
        return listToReturn;
    }
}
