package com.agility.focis.PIV;

import com.agility.focis.base.BasePage;
import com.agility.focis.performActivities.common.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public  WebElement pivAmount;
    @FindBy(xpath = "//input[contains(@id,'txtTaxAmount')]")
    public WebElement taxAmount;
    @FindBy(xpath = "//span[contains(@id,'lblFinNetAmt')]")
    public WebElement totalAmount;
    @FindBy(xpath = "//button[contains(@id,'PivCny_btnPopup')]")
    public WebElement currencyButton;
    @FindBy(id = "gs_CurrencyCode")
    public WebElement currencyCode;
    @FindBy(id = "grdAmountInfo")
    public WebElement amountInfoTable;
    @FindBy(xpath = "//input[@title = 'Create']")
    public WebElement createPIVButton;
    @FindBy(xpath = "//input[@title = 'Cancel PIV']")
    public WebElement cancelPIVButton;
    @FindBy(xpath = "//input[@title = 'Allocate to Jobs/ Consol']")
    public WebElement allocateToJobsORConsolButton;
    @FindBy(xpath = "//input[@title = 'Save']")
    public WebElement savePIVButton;


}
