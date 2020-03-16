package com.agility.focis.addPackagesAndUnits;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddPackagesAndUnitsSteps extends BaseSteps {
    private WebDriver driver;
    private AddPackagesAndUnitsPage addPackagesAndUnitsPage;

    AddPackagesAndUnitsSteps() throws IOException {
        this.driver = getDriver();
        addPackagesAndUnitsPage = new AddPackagesAndUnitsPage(this.driver);
    }

    public void clickOnEditPackages() {
        Actions actions = new Actions(driver);
        if (addPackagesAndUnitsPage.productTypeName.getText().equalsIgnoreCase("LCL") || addPackagesAndUnitsPage.productName.getText().equalsIgnoreCase("Air Freight")) {
            SeleniumUtils.waitForElementToVisible(addPackagesAndUnitsPage.addOrEditPackagesLCL);
            actions.moveToElement(addPackagesAndUnitsPage.addOrEditPackagesLCL).perform();
//            addPackagesAndUnitsPage.addOrEditPackagesLCL.click();
        } else {
            SeleniumUtils.waitForElementToVisible(addPackagesAndUnitsPage.addOrEditPackages);
//            addPackagesAndUnitsPage.addOrEditPackages.click();
            actions.moveToElement(addPackagesAndUnitsPage.addOrEditPackages).perform();
        }
        try {
            SeleniumUtils.waitForElementToVisible(addPackagesAndUnitsPage.editPackages, 10);
            addPackagesAndUnitsPage.editPackages.click();

        } catch (Exception e) {
            addPackagesAndUnitsPage.productTypeName.click();
            clickOnEditPackages();
        }
    }

    public void addOrEditMultiplePackages(List<Map<String, String>> packagesinfo) throws InterruptedException {
        Actions action = new Actions(driver);
        for (int i = 0; i < packagesinfo.size(); i++) {

            String noOfPackages = packagesinfo.get(i).get("Packages");
            String typeOfPackages = packagesinfo.get(i).get("Type");
            String per_piece_Wt = packagesinfo.get(i).get("Per piece Wt");
            String gross_Wt = packagesinfo.get(i).get("Gross Wt");
            String length = packagesinfo.get(i).get("Length");
            String width = packagesinfo.get(i).get("Width");
            String height = packagesinfo.get(i).get("Height");
            String volume = packagesinfo.get(i).get("Volume");
            String shippingMarks = packagesinfo.get(i).get("Shipping Marks");
            String description = packagesinfo.get(i).get("Description");
            String isHazardous = packagesinfo.get(i).get("Is Hazardous");
            String isNonStackable = packagesinfo.get(i).get("Is NonStackable");
            String isReefer = packagesinfo.get(i).get("Is Reefer");

            addPackagesAndUnitsPage.noOfPackages(i).sendKeys(noOfPackages);
            addPackagesAndUnitsPage.type(i).sendKeys(typeOfPackages);
            Thread.sleep(1000);
            addPackagesAndUnitsPage.type(i).sendKeys(Keys.ENTER);
            addPackagesAndUnitsPage.perPieceWt(i).sendKeys(per_piece_Wt);
            addPackagesAndUnitsPage.grossWeight(i).sendKeys(gross_Wt);
            addPackagesAndUnitsPage.length(i).sendKeys(length);
            addPackagesAndUnitsPage.width(i).sendKeys(width);
            addPackagesAndUnitsPage.height(i).sendKeys(height);
            addPackagesAndUnitsPage.volume(i).sendKeys(volume);
            addPackagesAndUnitsPage.shippingMarks(i).sendKeys(shippingMarks);

            if (addPackagesAndUnitsPage.getDialogueTitle().equalsIgnoreCase("New Job")) {
                if (isHazardous.equalsIgnoreCase("Yes")) {
                    addPackagesAndUnitsPage.isHazrdous(i).click();
                }
                if (isReefer.equalsIgnoreCase("Yes")) {
                    addPackagesAndUnitsPage.isReefer(i).click();
                }
                if (isNonStackable.equalsIgnoreCase("Yes")) {
                    addPackagesAndUnitsPage.isNonStackable(i).click();
                }
            } else {
                addPackagesAndUnitsPage.description(i).sendKeys(description);
            }


            if ((i + 1) % 4 == 0) {
                addPackagesAndUnitsPage.addRows.click();
            }
        }
        GlobalVariables.setPackagesInfo(packagesinfo);

    }

    //    ****Below are related to "Units"****
    public void clickOnEditUnits() throws InterruptedException {
        Actions actions = new Actions(driver);
        if (addPackagesAndUnitsPage.productTypeName.getText().equalsIgnoreCase("LCL")) {
            SeleniumUtils.waitForElementToVisible(addPackagesAndUnitsPage.addUnitsLCL);
            actions.moveToElement(addPackagesAndUnitsPage.addUnitsLCL).perform();
//            addPackagesAndUnitsPage.addOrEditPackagesLCL.click();
        } else {
            SeleniumUtils.waitForElementToVisible(addPackagesAndUnitsPage.addOrEditUnits);
//            addPackagesAndUnitsPage.addOrEditPackages.click();
            actions.moveToElement(addPackagesAndUnitsPage.addOrEditUnits).perform();
        }
        try {
            SeleniumUtils.waitForElementToVisible(addPackagesAndUnitsPage.addUnits, 10);
            addPackagesAndUnitsPage.addUnits.click();

        } catch (Exception e) {
            addPackagesAndUnitsPage.productTypeName.click();
            clickOnEditPackages();
        }

    }

    public void addUnits(List<Map<String, String>> unitsInfo) {

        for (int i = 0; i < unitsInfo.size(); i++) {
            String noOfUnits = unitsInfo.get(i).get("Units");
            String typeOfUnit = unitsInfo.get(i).get("Unit Type");
            String shipper_Owned = unitsInfo.get(i).get("Shipper Owned");
            String gross_WtPerUnit = unitsInfo.get(i).get("Gross Wt/Unit");
            String volumePerUnit = unitsInfo.get(i).get("Volume/Unit");
            String marksAndNumbers = unitsInfo.get(i).get("Marks And Numbers");
            String description = unitsInfo.get(i).get("Description");

            addPackagesAndUnitsPage.noOfunits(i).sendKeys(noOfUnits);
            Select typeofUnitDropdown = new Select(addPackagesAndUnitsPage.unitType(i));
            typeofUnitDropdown.selectByVisibleText(typeOfUnit);
            if (shipper_Owned.equalsIgnoreCase("Yes")) {
                addPackagesAndUnitsPage.isShipperOwned(i).click();
            }
            addPackagesAndUnitsPage.estimatedGrossWeightPerUnit(i).sendKeys(gross_WtPerUnit);
            addPackagesAndUnitsPage.estimatedVolumePerUnit(i).sendKeys(volumePerUnit);
            addPackagesAndUnitsPage.marksAndNumbers(i).sendKeys(marksAndNumbers);
            addPackagesAndUnitsPage.description(i).sendKeys(description);
            if (i != (unitsInfo.size() - 1)) {
                addPackagesAndUnitsPage.addMoreButton.click();
            }
        }
        GlobalVariables.setUnitsInfo(unitsInfo);
    }

    public void allocatePackages() throws InterruptedException {
        SeleniumUtils.waitForElementToVisible(addPackagesAndUnitsPage.productTypeName);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        int noOfUnallocatedUnits = driver.findElements(By.xpath("//div[@id ='Package_div']//tr//span[contains(@data-bind , 'DisplayNoOfPkgs')]")).size();
        int noOfUnallocatedPackages = driver.findElements(By.xpath("//div[contains(@data-bind , 'AllocatedPackages') and contains(@id,'Unit')]")).size();
        if (noOfUnallocatedUnits >= noOfUnallocatedPackages) {
            for (int i = 0; i < noOfUnallocatedPackages; i++) {
                actions.dragAndDrop(addPackagesAndUnitsPage.unallocatedPackages(0), addPackagesAndUnitsPage.unallocatedUnits(i)).build().perform();
                SeleniumUtils.waitForElementToBeClickable(addPackagesAndUnitsPage.acceptPackageAllocationWarning(i));
                addPackagesAndUnitsPage.acceptPackageAllocationWarning(i).click();
                SeleniumUtils.waitForElementToBeClickable(addPackagesAndUnitsPage.saveBookingDetailsButton);
            }
        } else {
            for (int i = 0; i < noOfUnallocatedPackages; i++) {
                actions.dragAndDrop(addPackagesAndUnitsPage.unallocatedPackages(0), addPackagesAndUnitsPage.unallocatedUnits(i % noOfUnallocatedUnits)).build().perform();
                SeleniumUtils.waitForElementToBeClickable(addPackagesAndUnitsPage.acceptPackageAllocationWarning(i));
                addPackagesAndUnitsPage.acceptPackageAllocationWarning(i).click();
                SeleniumUtils.waitForElementToBeClickable(addPackagesAndUnitsPage.saveBookingDetailsButton);
            }
        }
        addPackagesAndUnitsPage.saveBookingDetailsButton.click();
    }

}
