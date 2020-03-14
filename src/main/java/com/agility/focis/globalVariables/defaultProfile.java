package com.agility.focis.globalVariables;

public class defaultProfile implements Interface {

    String jobNumber = "";

    public int timeout() {
        return 20;
    }


    public String url() {
        return "agile";
    }

    @Override
    public void putjobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    @Override
    public String getjobNumber() {
        return this.jobNumber;
    }
}
