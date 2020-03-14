package com.agility.focis.globalVariables;

import java.util.List;
import java.util.Map;

public class GlobalVariables {
    private static String jobNumber;
    private static String jobStatus;
    private static String product;
    private static String productType;
    private static String jobScope;
    private static String incoterm;
    private static String incoTermLocation;
    private static List<Map<String, String>> packagesInfo;
    private static List<Map<String, String>> unitsInfo;
    private static Map<String, Map<String, String>> parties;
    private static Map<String, String> jobReferences;
    private static Map<String, String> mblInformation;
    private static List<Map<String, String>> locationDetails;
    private static String cbrXMLData;

    public static String getJobNumber() {
        return jobNumber;
    }

    public static void setJobNumber(String jobNumber) {
        GlobalVariables.jobNumber = jobNumber;
    }

    public static String getJobStatus() {
        return jobStatus;
    }

    public static void setJobStatus(String jobStatus) {
        GlobalVariables.jobStatus = jobStatus;
    }

    public static String getProduct() {
        return product;
    }

    public static void setProduct(String product) {
        GlobalVariables.product = product;
    }

    public static String getProductType() {
        return productType;
    }

    public static void setProductType(String productType) {
        GlobalVariables.productType = productType;
    }

    public static String getIncoterm() {
        return incoterm;
    }

    public static void setIncoterm(String incoterm) {
        GlobalVariables.incoterm = incoterm;
    }

    public static String getIncoTermLocation() {
        return incoTermLocation;
    }

    public static void setIncoTermLocation(String incoTermLocation) {
        GlobalVariables.incoTermLocation = incoTermLocation;
    }

    public static Map<String, String> getJobReferences() {
        return jobReferences;
    }

    public static void setJobReferences(Map<String, String> jobReferences) {
        GlobalVariables.jobReferences = jobReferences;
    }

    public static Map<String, String> getMblInformation() {
        return mblInformation;
    }

    public static void setMblInformation(Map<String, String> mblInformation) {
        GlobalVariables.mblInformation = mblInformation;
    }

    public static List<Map<String, String>> getLocationDetails() {
        return locationDetails;
    }

    public static void setLocationDetails(List<Map<String, String>> locationDetails) {
        GlobalVariables.locationDetails = locationDetails;
    }

    public static String getJobScope() {
        return jobScope;
    }

    public static void setJobScope(String jobScope) {
        GlobalVariables.jobScope = jobScope;
    }

    public static List<Map<String, String>> getPackagesInfo() {
        return packagesInfo;
    }

    public static void setPackagesInfo(List<Map<String, String>> packagesInfo) {
        GlobalVariables.packagesInfo = packagesInfo;
    }

    public static List<Map<String, String>> getUnitsInfo() {
        return unitsInfo;
    }

    public static void setUnitsInfo(List<Map<String, String>> unitsInfo) {
        GlobalVariables.unitsInfo = unitsInfo;
    }

    public static String getCbrXMLData() {
        return cbrXMLData;
    }

    public static void setCbrXMLData(String cbrXMLData) {
        GlobalVariables.cbrXMLData = cbrXMLData;
    }

    public static Map<String, Map<String, String>> getParties() {
        return parties;
    }

    public static void setParties(Map<String, Map<String, String>> parties) {
        GlobalVariables.parties = parties;
    }
}
