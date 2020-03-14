package com.agility.focis.globalVariables;

import com.agility.focis.base.DriverInstantiation;

import java.io.IOException;

public class GlobalVaraibles {
    private String profile;
    Interface GloablVariable;

    public GlobalVaraibles() throws IOException {
        DriverInstantiation a = new DriverInstantiation();
        this.profile = a.getProfile();
    }

    public Interface GloablVariables() {
        if (this.profile.equalsIgnoreCase("agile")) {

            GloablVariable = new agile();
        } else if (this.profile.equalsIgnoreCase("sit")) {
            GloablVariable = new sit();
        } else {
            GloablVariable = new defaultProfile();

        }
        return GloablVariable;
    }
}

