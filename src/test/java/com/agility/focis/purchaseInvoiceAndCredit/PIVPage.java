package com.agility.focis.purchaseInvoiceAndCredit;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PIVPage extends BasePage {

    public PIVPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@data-original-title='Create New PIV']//span[@class='ui-icon icon-plus-sign purple']")
    public WebElement createNewPIVButton;
    @FindBy(id = "spnHeaderStateId")
    public WebElement invoiceStatus;
    @FindBy(xpath = "//button[contains(@id,'txtLegalEntity_btnPopup')]")
    public WebElement legalEntitySearchButton;
    @FindBy(id = "gs_OrganizationCode")
    public WebElement entityCodeSearchBox;
    @FindBy(id = "ddlBranch")
    public WebElement orgComponent;
    @FindBy(xpath = "//span[contains(@id,'lblPivNo')]")
    public WebElement pivNo;
    //    public List<WebElement> pivNums;
    @FindBy(xpath = "//button[contains(@id,'txtPlaceOfSupply_btnPopup')]")
    public WebElement placeOfSupplySearchButton;
    @FindBy(xpath = "//button[contains(@id,'txtSupplier_btnPopup')]")
    public WebElement supplierNameSearchButton;
    @FindBy(xpath = "//span[contains(@id,'lblInvoiceFromadd')]")
    public WebElement supplierAddress;
    @FindBy(xpath = "//input[contains(@id,'SupplierInvNo')]")
    public WebElement invoiceNum;
    @FindBy(xpath = "//button[contains(@id,'txtSupplierInvoiceDate_btnPopup')]")
    public WebElement invoiceDateButton;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//td[@class = 'day active']")
    public WebElement currentDateAsInvoiceDate;
    @FindBy(xpath = "//span[contains(@id,'lblPivDateTime')]")
    public WebElement pivDate;
    @FindBy(xpath = "//span[contains(@id,'lblPivDueDate')]")
    public WebElement pivDueDate;
    @FindBy(xpath = "//input[contains(@id,'txtBankersRef')]")
    public WebElement bankReference;
    @FindBy(xpath = "//select[contains(@id,'ManagePurchaseInvoiceFrUC_ddlPivType')]")
    public WebElement invoiceType;
    @FindBy(xpath = "//select[contains(@id,'ddlPivSubType')]")
    public WebElement invoiceSubType;
    @FindBy(xpath = "//input[contains(@id,'ChkTaxAtHeader')]")
    public WebElement taxAtHeader;
    @FindBy(xpath = "//input[contains(@id,'txtPivAmount')]")
    public WebElement pivAmount;
    @FindBy(xpath = "//input[contains(@id,'txtTaxAmount')]")
    public WebElement taxAmount;
    @FindBy(xpath = "//span[contains(@id,'lblFinNetAmt')]")
    public WebElement totalAmount;
    @FindBy(xpath = "//button[contains(@id,'PivCny_btnPopup')]")
    public WebElement currencyButton;
    @FindBy(id = "gs_CurrencyCode")
    public WebElement currencyCode;
    @FindBy(xpath = "//input[contains(@id,'txtPivCny')]")
    public WebElement pivCurrencyTetBox;
    @FindBy(id = "grdAmountInfo")
    public WebElement amountInfoTable;
    @FindBy(xpath = "//input[@title = 'Create']")
    public WebElement createPIVButton;
    @FindBy(xpath = "//input[@title = 'Cancel PIV']")
    public WebElement cancelPIVButton;
    @FindBy(xpath = "//input[@title = 'Allocate to Jobs/ Consol']")
    public WebElement allocateToJobsORConsolButton;
    @FindBy(xpath = "//input[contains(@id,'ManagePurchaseInvoiceFrUC_btnSave')]")
    public WebElement savePIVButton;
    @FindBy(id = "idSuppNum")
    public WebElement supplierInvoiceNumAllocatePage;

    @FindBy(id = "grdTagJobsLs")
    public WebElement JobsList;

    @FindBy(id = "grdAmountInfoPopup")
    public WebElement amountInfoTableAllocateJobs;

    @FindBy(xpath = "//input[contains(@id,'PIVTagJobsFrUC_btnSavePIVDetails')]")
    public WebElement allocateButton;

    @FindBy(xpath = "//input[contains(@id,'PIVTagJobsFrUC_txtJobNumber')]")
    public WebElement jobNumberOrConsolNumberInput;

    @FindBy(xpath = "//input[contains(@id,'ManagePurchaseInvoiceFrUC_btnComplete')]")
    public WebElement completeInvoiceButton;

    public WebElement generatedPIVNumber(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVNo')]"));
    }

    public WebElement generatedPIVTotalAmount(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVAmount')]"));
    }

    public WebElement generatedPIVSupplierName(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'StakeHolderName')]"));
    }

    public WebElement generatedPIVDate(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVDateTime')]"));
    }

    public WebElement generatedPIVDueDate(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVDueDate')]"));
    }

    public WebElement generatedPIVStatus(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'StateName')]"));
    }


//    Search Companion - PIV

    @FindBy(xpath = "//input[contains(@id,'txtSupplierInvNo')]")
    public WebElement supplierInvoiceNumberSearchCompanion;

    @FindBy(xpath = "//select[contains(@id,'ManagePIVLsUc_ddlPIVType')]")
    public WebElement pivTypeSearchCompanion;

    @FindBy(xpath = "//select[contains(@id,'ManagePIVLsUc_ddlPivSubType')]")
    public WebElement pivSubtypeSearchCompanion;

    @FindBy(xpath = "//input[contains(@id,'ManagePIVLsUc_btnSearch')]")
    public WebElement searchButtonManagePIV;
}
